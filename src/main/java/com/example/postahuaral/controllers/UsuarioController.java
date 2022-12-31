package com.example.postahuaral.controllers;

import com.example.postahuaral.services.UsuarioService;
import com.example.postahuaral.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "getUsuarios")
    public List<Usuario> getUsuarios() {
        return usuarioService.getAllUsuarios();
    }
}
