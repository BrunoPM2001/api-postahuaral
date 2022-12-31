package com.example.postahuaral.controllers;

import com.example.postahuaral.models.Paciente;
import com.example.postahuaral.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping(value = "getPacientes")
    public List<Paciente> getPacientes() {
        return pacienteService.getAllPacientes();
    }

    @GetMapping(value = "getPaciente/{id}")
    public Map<String, Object> getPaciente(@PathVariable Long id) {
        return pacienteService.getOnePaciente(id);
    }

    @PostMapping(value = "createPaciente")
    public Map<String, String> createPaciente() {
        return null;
    }

    @PutMapping(value = "updatePaciente")
    public Map<String, String> updatePaciente() {
        return null;
    }

    @DeleteMapping(value = "deletePaciente")
    public Map<String, String> deletePaciente() {
        return null;
    }

}
