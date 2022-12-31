package com.example.postahuaral.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "paciente")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Paciente implements Serializable {
    @Id
    private int idpaciente;
    private String nombres;
    private String apellidos;
    private String dni;
    private String telefono;
    private char estado_historial;

    @OneToOne(
            mappedBy = "paciente",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Usuario usuario;

}
