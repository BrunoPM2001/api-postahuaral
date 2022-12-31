package com.example.postahuaral.services.implement;

import com.example.postahuaral.models.Paciente;
import com.example.postahuaral.repository.PacienteRepo;
import com.example.postahuaral.services.PacienteService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> getOnePaciente(Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            Paciente p = pacienteRepo.findByIdpaciente(id);
            result.put("Paciente", p);
            return result;
        } catch (ExpiredJwtException e) {
            result.put("Message", "Fail");
            return result;
        }
    }

    @Override
    public String createPaciente() {
        return null;
    }

    @Override
    public String updatePaciente() {
        return null;
    }

    @Override
    public String deletePaciente() {
        return null;
    }
}
