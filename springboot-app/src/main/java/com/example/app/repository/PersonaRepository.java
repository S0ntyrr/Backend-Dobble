package com.example.app.repository;
import com.example.app.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PersonaRepository extends JpaRepository<Persona, Long> {}
