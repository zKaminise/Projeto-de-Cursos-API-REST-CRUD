package com.example.crudProjectRocketSeat.controllers;

import com.example.crudProjectRocketSeat.entities.Cursos;
import com.example.crudProjectRocketSeat.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos" +
        "")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<String> saveCurso(@RequestBody Cursos cursos) {
        try {
            cursoService.saveCurso(cursos);
            return ResponseEntity.ok("Curso salvo com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Cursos> findAll() {
        List<Cursos> findAllCursos = cursoService.findAll();
        return findAllCursos;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCurso (@PathVariable Long id, @RequestBody Cursos cursos) {
        try {
            cursoService.updateCurso(id, cursos);
            return ResponseEntity.ok("Curso atualizado com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCurso(@PathVariable Long id) {
        try {
            cursoService.deleteCurso(id);
            return ResponseEntity.ok("Curso deletado com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<String> updateActiveStatus (@PathVariable Long id, @RequestBody boolean isActive) {
        try {
            cursoService.updateActiveStatus(id, isActive);
        return ResponseEntity.ok("Status de ativação foi alterado com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
