package com.example.crudProjectRocketSeat;

import com.example.crudProjectRocketSeat.entities.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositorys extends JpaRepository<Cursos, Long> {
}
