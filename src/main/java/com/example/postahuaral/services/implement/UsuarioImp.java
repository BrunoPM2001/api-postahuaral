package com.example.postahuaral.services.implement;

import com.example.postahuaral.repository.UsuarioRepo;
import com.example.postahuaral.services.UsuarioService;
import com.example.postahuaral.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UsuarioService")
public class UsuarioImp implements UsuarioService {

    @Qualifier("UsuarioRepo")
    private final UsuarioRepo usuarioRepo;

    @Autowired
    public UsuarioImp(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        List<Usuario> result = usuarioRepo.findAll();
        return result;
    }
}
