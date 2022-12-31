package com.example.postahuaral.services.implement;

import com.example.postahuaral.models.Paciente;
import com.example.postahuaral.repository.UsuarioRepo;
import com.example.postahuaral.services.UsuarioService;
import com.example.postahuaral.models.Usuario;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> getOneUsuario(Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            Usuario u = usuarioRepo.findByIdusuario(id);
            result.put("Usuario", u);
            return result;
        } catch (ExpiredJwtException e) {
            result.put("Message", "Fail");
            return result;
        }
    }

    @Override
    public String createUsuario() {
        return null;
    }

    @Override
    public String updateUsuario() {
        return null;
    }

    @Override
    public String deleteUsuario() {
        return null;
    }
}
