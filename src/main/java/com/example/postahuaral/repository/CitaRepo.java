package com.example.postahuaral.repository;

import com.example.postahuaral.models.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CitaRepo")
public interface CitaRepo extends JpaRepository<Cita, Long> {

    @Query("select c from Cita c where c.usuario.idusuario = ?1")
    List<Cita> findByUsuarioIdusuario(Long idusuario);

}
