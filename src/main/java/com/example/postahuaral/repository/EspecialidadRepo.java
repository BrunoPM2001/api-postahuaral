package com.example.postahuaral.repository;

import com.example.postahuaral.models.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("EspecialidadRepo")
public interface EspecialidadRepo extends JpaRepository<Especialidad, Long> {

    @Query("select e from Especialidad e")
    List<Especialidad> findAll();

}
