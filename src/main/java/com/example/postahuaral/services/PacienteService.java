package com.example.postahuaral.services;

import com.example.postahuaral.models.Paciente;

import java.util.List;
import java.util.Map;

public interface PacienteService {
    List<Paciente> getAllPacientes();
    Map<String, Object> getOnePaciente(Long id);
    String createPaciente();
    String updatePaciente();
    String deletePaciente();

}
