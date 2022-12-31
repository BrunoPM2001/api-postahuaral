package com.example.postahuaral.repository;

import com.example.postahuaral.models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("HorarioRepo")
public interface HorarioRepo extends JpaRepository<Horario, Long> {

    @Query("select h from Horario h")
    List<Horario> findAll();

}
