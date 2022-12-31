package com.example.postahuaral.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "cita")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcita;

    private double pagotransferencia;
    private double pagototal;
    private char estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idmedico")
    private Medico medico;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

}
