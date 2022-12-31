package com.example.postahuaral.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "medico")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Medico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmedico;
    private String nombre;
    private String apellido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idespecialidad")
    private Especialidad especialidad;

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "medicoxhorario",
            joinColumns = @JoinColumn(name = "idmedico"),
            inverseJoinColumns = @JoinColumn(name = "idhorario")
    )
    private List<Horario> horarios;

}
