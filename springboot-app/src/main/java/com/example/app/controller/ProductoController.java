package com.example.app.controller;
import com.example.app.model.Producto;
import com.example.app.repository.ProductoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoRepository repo;
    public ProductoController(ProductoRepository repo){this.repo=repo;}
    @GetMapping public List<Producto> all(){return repo.findAll();}
    @GetMapping("/{id}") public ResponseEntity<Producto> get(@PathVariable Long id){return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}
    @PostMapping public ResponseEntity<Producto> create(@RequestBody Producto p){Producto saved = repo.save(p); return ResponseEntity.status(201).body(saved);}
    @PutMapping("/{id}") public ResponseEntity<Producto> update(@PathVariable Long id,@RequestBody Producto p){return repo.findById(id).map(existing->{existing.setNombre(p.getNombre()); existing.setDescripcion(p.getDescripcion()); existing.setPrecio(p.getPrecio()); repo.save(existing); return ResponseEntity.ok(existing);}).orElse(ResponseEntity.notFound().build());}
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){ if(!repo.existsById(id)) return ResponseEntity.notFound().build(); repo.deleteById(id); return ResponseEntity.noContent().build(); }
}
