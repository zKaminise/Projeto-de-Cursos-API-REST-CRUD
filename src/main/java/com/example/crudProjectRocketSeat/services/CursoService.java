package com.example.crudProjectRocketSeat.services;

import com.example.crudProjectRocketSeat.entities.Cursos;
import com.example.crudProjectRocketSeat.repositorys.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursosRepository cursosRepository;

    @Transactional(readOnly = true)
    public void saveCurso(Cursos cursos) {
        if (cursos.getName() == null || cursos.getName().isEmpty()) {
            throw new RuntimeException("Nome do curso não pode estar vazio");
        } else if (cursos.getCategoria() == null || cursos.getCategoria().isEmpty()) {
            throw new RuntimeException("Categoria não pode estar vazia");
        }
        Cursos novoCurso = new Cursos();
        cursosRepository.save(novoCurso);
    }

    @Transactional(readOnly = true)
    public List<Cursos> findAll() {
        List<Cursos> findAllCursos = cursosRepository.findAll();
        return findAllCursos.stream().map(Cursos::new).toList();
    }

    @Transactional
    public void updateCurso (@PathVariable Long id, @RequestBody Cursos cursos) {
        Cursos cursoExistente = cursosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        cursoExistente.setName(cursos.getName());
        cursoExistente.setCategoria(cursos.getCategoria());
        cursoExistente.setActive(cursos.getActive());
        cursoExistente.setCreatedAt(cursos.getCreatedAt());
        cursoExistente.setUpdatedAt(cursos.getUpdatedAt());

        cursosRepository.save(cursoExistente);
    }

    @Transactional
    public void deleteCurso(@PathVariable Long id) {
        if (!cursosRepository.existsById(id)) {
            throw new RuntimeException("Curso não existe");
        }
        cursosRepository.deleteById(id);
    }

    public void updateActiveStatus(Long id, boolean isActive) {
        Cursos cursos = cursosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não existe"));

        cursos.setActive(isActive);
        cursosRepository.save(cursos);
    }
}
