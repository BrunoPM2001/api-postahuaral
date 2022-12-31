package com.example.postahuaral.services.implement;

import com.example.postahuaral.models.Medico;
import com.example.postahuaral.repository.MedicoRepo;
import com.example.postahuaral.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MedicoService")
public class MedicoImp implements MedicoService {

    @Qualifier
    MedicoRepo medicoRepo;

    @Autowired
    public MedicoImp (MedicoRepo medicoRepo) {
        this.medicoRepo = medicoRepo;
    }

    @Override
    public List<Medico> getAllMedicos() {
        List<Medico> result = medicoRepo.findAll();
        return result;
    }

    @Override
    public List<Medico> getAllMedicosFromOneEspecialidad(Long idespecialidad) {
        List<Medico> result = medicoRepo.findByEspecialidadIdespecialidad(idespecialidad);
        return result;
    }
}
