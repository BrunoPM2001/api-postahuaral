package com.example.postahuaral.repository;

import com.example.postahuaral.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UsuarioRepo")
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {

    @Query("select u from Usuario u")
    List<Usuario> findAll();

    @Query("select u from Usuario u where u.idusuario = ?1")
    Usuario findByIdusuario(Long id);

    @Query("select u from Usuario u where u.correo = ?1")
    Usuario findByCorreo(String correo);
}
