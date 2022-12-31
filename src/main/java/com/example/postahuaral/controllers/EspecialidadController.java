package com.example.postahuaral.controllers;

import com.example.postahuaral.models.Especialidad;
import com.example.postahuaral.services.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping(value = "getEspecialidades")
    public List<Especialidad> getEspecialidades(){
        return especialidadService.getAllEspecialidades();
    }
}
