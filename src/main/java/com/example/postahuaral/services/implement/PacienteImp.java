package com.example.postahuaral.services.implement;

import com.example.postahuaral.models.Paciente;
import com.example.postahuaral.repository.PacienteRepo;
import com.example.postahuaral.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PacienteService")
public class PacienteImp implements PacienteService {

    @Qualifier("UsuarioRepo")
    PacienteRepo pacienteRepo;

    @Autowired
    public PacienteImp(PacienteRepo pacienteRepo) {
        this.pacienteRepo = pacienteRepo;
    }

    @Override
    public List<Paciente> getAllPacientes() {
        List<Paciente> result = pacienteRepo.findAll();
        return result;
    }
}
