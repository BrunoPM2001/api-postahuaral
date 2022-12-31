package com.example.postahuaral.services.implement;

import com.example.postahuaral.models.Especialidad;
import com.example.postahuaral.repository.EspecialidadRepo;
import com.example.postahuaral.services.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EspecialidadService")
public class EspecialidadImp implements EspecialidadService {

    @Qualifier
    EspecialidadRepo especialidadRepo;

    @Autowired
    public EspecialidadImp(EspecialidadRepo especialidadRepo) {
        this.especialidadRepo = especialidadRepo;
    }

    @Override
    public List<Especialidad> getAllEspecialidades() {
        List<Especialidad> result = especialidadRepo.findAll();
        return result;
    }
}
