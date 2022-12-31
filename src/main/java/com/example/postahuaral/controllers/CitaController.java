package com.example.postahuaral.controllers;

import com.example.postahuaral.converter.CitaDatos;
import com.example.postahuaral.models.Cita;
import com.example.postahuaral.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping("getCitasFromUsuario")
    public List<Cita> getCitasFromUsuario(@RequestParam(value = "idusuario") Long id) {
        return citaService.getCitasByUsuario(id);
    }

    @PostMapping("createCita")
    public Map<String, Object> createCita(
            @RequestHeader(value = "Auth") String token ,
            @RequestBody CitaDatos citaDatos
    ) {
        return citaService.createCita(token, citaDatos);
    }
}
