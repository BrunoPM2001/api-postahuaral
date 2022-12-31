package com.example.postahuaral.controllers;

import com.example.postahuaral.models.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PacienteController {

    @RequestMapping(value = "getPacientes")
    public List<Usuario> getUsuarios() {
        return usuarioService.getAllUsuarios();
    }

}
