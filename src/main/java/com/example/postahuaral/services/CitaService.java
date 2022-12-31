package com.example.postahuaral.services;

import com.example.postahuaral.converter.CitaDatos;
import com.example.postahuaral.models.Cita;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface CitaService {

    List<Cita> getCitasByUsuario(Long id);
    Map<String, Object> createCita(String token, CitaDatos citaDatos);
}
