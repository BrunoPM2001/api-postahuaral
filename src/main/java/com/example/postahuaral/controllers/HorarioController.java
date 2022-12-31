package com.example.postahuaral.controllers;

import com.example.postahuaral.models.Horario;
import com.example.postahuaral.services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HorarioController {

    @Autowired
    HorarioService horarioService;

    @GetMapping("getHorarios")
    public List<Horario> getHorarios() {
        return horarioService.getHorarios();
    }
}
