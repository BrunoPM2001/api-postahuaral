package com.example.postahuaral.services;

import com.example.postahuaral.models.Usuario;

import java.util.List;
import java.util.Map;

public interface UsuarioService {
    List<Usuario> getAllUsuarios();
    Map<String, Object> getOneUsuario(Long id);
    String createUsuario();
    String updateUsuario();
    String deleteUsuario();
}
