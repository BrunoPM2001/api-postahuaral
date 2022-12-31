package com.example.postahuaral.controllers;

import com.example.postahuaral.services.UsuarioService;
import com.example.postahuaral.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "getUsuarios")
    public List<Usuario> getUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping(value = "getUsuario/{id}")
    public Map<String, Object> getUsuario(@PathVariable Long id) {
        return usuarioService.getOneUsuario(id);
    }

    @PostMapping(value = "createUsuario")
    public Map<String, String> createUsuario() {
        return null;
    }

    @PutMapping(value = "updateUsuario")
    public Map<String, String> updateUsuario() {
        return null;
    }

    @DeleteMapping(value = "deleteUsuario")
    public Map<String, String> deleteUsuario() {
        return null;
    }

    @PutMapping(value = "login")
    public Map<String, Object> login(@RequestBody Usuario usuario) {
        return usuarioService.login(usuario);
    }

}
