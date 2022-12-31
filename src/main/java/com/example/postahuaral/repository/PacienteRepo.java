package com.example.postahuaral.repository;

import com.example.postahuaral.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PacienteRepo")
public interface PacienteRepo extends JpaRepository<Paciente, Long> {

    @Query("select u from Paciente u")
    List<Paciente> findAll();
}
