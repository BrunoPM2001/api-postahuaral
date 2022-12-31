package com.example.postahuaral.services;

import com.example.postahuaral.models.Horario;

import java.util.List;

public interface HorarioService {

    List<Horario> getHorarios();

    List<Horario> getHorariosByMedico(Long id);
}
