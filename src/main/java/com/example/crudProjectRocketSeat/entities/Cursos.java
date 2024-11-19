package com.example.crudProjectRocketSeat.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String categoria;
    private Boolean active;


    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public Cursos(Cursos cursos) {
        id = cursos.getId();
        name = cursos.getName();
        categoria = cursos.getCategoria();
        active = cursos.getActive();
        createdAt = cursos.getCreatedAt();
        updatedAt = cursos.getUpdatedAt();
    }
}
