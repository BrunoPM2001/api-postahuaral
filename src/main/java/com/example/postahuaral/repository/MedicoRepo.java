package com.example.postahuaral.repository;

import com.example.postahuaral.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("MedicoRepo")
public interface MedicoRepo extends JpaRepository<Medico, Long> {

    @Query("select m from Medico m")
    List<Medico> findAll();

    @Query("select m from Medico m where m.especialidad.idespecialidad = ?1")
    List<Medico> findByEspecialidadIdespecialidad(Long id);

}
