package com.example.app.controller;
import com.example.app.model.Ubicacion;
import com.example.app.repository.UbicacionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/ubicaciones")
public class UbicacionController {
    private final UbicacionRepository repo;
    public UbicacionController(UbicacionRepository repo){this.repo=repo;}
    @GetMapping public List<Ubicacion> all(){return repo.findAll();}
    @GetMapping("/{id}") public ResponseEntity<Ubicacion> get(@PathVariable Long id){return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}
    @PostMapping public ResponseEntity<Ubicacion> create(@RequestBody Ubicacion u){Ubicacion saved = repo.save(u); return ResponseEntity.status(201).body(saved);}
    @PutMapping("/{id}") public ResponseEntity<Ubicacion> update(@PathVariable Long id,@RequestBody Ubicacion u){return repo.findById(id).map(existing->{existing.setNombre(u.getNombre()); existing.setLatitud(u.getLatitud()); existing.setLongitud(u.getLongitud()); existing.setDireccion(u.getDireccion()); repo.save(existing); return ResponseEntity.ok(existing);}).orElse(ResponseEntity.notFound().build());}
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){ if(!repo.existsById(id)) return ResponseEntity.notFound().build(); repo.deleteById(id); return ResponseEntity.noContent().build(); }
}
