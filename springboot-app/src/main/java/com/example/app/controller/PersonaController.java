package com.example.app.controller;
import com.example.app.model.Persona;
import com.example.app.repository.PersonaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    private final PersonaRepository repo;
    public PersonaController(PersonaRepository repo){this.repo=repo;}
    @GetMapping public List<Persona> all(){return repo.findAll();}
    @GetMapping("/{id}") public ResponseEntity<Persona> get(@PathVariable Long id){return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}
    @PostMapping public ResponseEntity<Persona> create(@RequestBody Persona p){Persona saved = repo.save(p); return ResponseEntity.status(201).body(saved);}
    @PutMapping("/{id}") public ResponseEntity<Persona> update(@PathVariable Long id,@RequestBody Persona p){return repo.findById(id).map(existing->{existing.setNombre(p.getNombre()); existing.setEmail(p.getEmail()); existing.setTelefono(p.getTelefono()); repo.save(existing); return ResponseEntity.ok(existing);}).orElse(ResponseEntity.notFound().build());}
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){ if(!repo.existsById(id)) return ResponseEntity.notFound().build(); repo.deleteById(id); return ResponseEntity.noContent().build(); }
}
