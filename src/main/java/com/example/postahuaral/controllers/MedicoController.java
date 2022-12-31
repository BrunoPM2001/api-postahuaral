package com.example.postahuaral.controllers;

import com.example.postahuaral.models.Medico;
import com.example.postahuaral.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping("getMedicos")
    public List<Medico> getMedicos() {
        return medicoService.getAllMedicos();
    }

    @GetMapping("getMedicosByEspecialidad")
    public List<Medico> getMedicosByEspecialidad(@RequestParam(value = "idEspecialidad") Long idEspecialidad) {
        return medicoService.getAllMedicosFromOneEspecialidad(idEspecialidad);
    }

    @GetMapping("getMedico")
    public Medico getMedico(@RequestParam(value = "id") Long id) {
        return medicoService.getMedico(id);
    }

}
