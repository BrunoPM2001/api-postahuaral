package com.example.postahuaral.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "horario")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Horario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idhorario;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime horainicio;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime horafin;

    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date fechaatencion;

}
