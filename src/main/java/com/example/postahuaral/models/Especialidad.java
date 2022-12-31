package com.example.postahuaral.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "especialidad")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Especialidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idespecialidad;
    private String nombre;
    private Double costo;

    @JsonIgnore
    @OneToMany(
            mappedBy = "especialidad",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Medico> ListaMedicos = new ArrayList<>();

}
