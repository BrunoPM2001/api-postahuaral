package com.example.postahuaral.services;

import com.example.postahuaral.models.Medico;

import java.util.List;

public interface MedicoService {

    List<Medico> getAllMedicos();
    List<Medico> getAllMedicosFromOneEspecialidad(Long idespecialidad);
    Medico getMedico(Long id);

}
