package com.example.postahuaral.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

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
}
