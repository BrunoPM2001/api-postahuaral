package com.example.postahuaral.services.implement;

import com.example.postahuaral.converter.CitaDatos;
import com.example.postahuaral.models.Cita;
import com.example.postahuaral.models.Medico;
import com.example.postahuaral.models.Usuario;
import com.example.postahuaral.repository.CitaRepo;
import com.example.postahuaral.repository.MedicoRepo;
import com.example.postahuaral.repository.UsuarioRepo;
import com.example.postahuaral.services.CitaService;
import com.example.postahuaral.utils.Tokens;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("CitaService")
public class CitaImp implements CitaService {

    @Qualifier("CitaRepo")
    private final CitaRepo citaRepo;
    @Qualifier("UsuarioRepo")
    private final UsuarioRepo usuarioRepo;
    @Qualifier("MedicoRepo")
    private final MedicoRepo medicoRepo;
    private final Tokens jwt;

    @Autowired
    public CitaImp(CitaRepo citaRepo, UsuarioRepo usuarioRepo, MedicoRepo medicoRepo, Tokens jwt) {
        this.citaRepo = citaRepo;
        this.usuarioRepo = usuarioRepo;
        this.medicoRepo = medicoRepo;
        this.jwt = jwt;
    }

    @Override
    public List<Cita> getCitasByUsuario(Long id) {
        List<Cita> result = citaRepo.findByUsuarioIdusuario(id);
        return result;
    }

    @Override
    public Map<String, Object> createCita(String token, CitaDatos citaDatos) {
        Map<String, Object> result = new HashMap<>();
        try {
            String nombre = jwt.validateToken(token);
            Cita c = citaDatos.getCita();
            //  Búsqueda de los objetos correspondientes a las ids de usuario y médico
            Usuario u = usuarioRepo.findByIdusuario(citaDatos.getIdusuario());
            Medico m = medicoRepo.findByIdmedico(citaDatos.getIdmedico());
            //  Cálculo de los costos
            double pagotransferencia = (m.getEspecialidad().getCosto() * 0.029) + (1.17);
            double pagototal = pagotransferencia + m.getEspecialidad().getCosto();
            c.setPagotransferencia(pagotransferencia);
            c.setPagototal(pagototal);
            //  Añadir esos objetos a la cita para guardar el registro en la entidad
            c.setUsuario(u);
            c.setMedico(m);
            citaRepo.save(c);
            result.put("Message", "Cita creado exitosamente por " + nombre);
            return result;
        } catch (Exception e) {
            result.put("Message", "Sesión expirada o inválida");
            return result;
        }
    }
}
