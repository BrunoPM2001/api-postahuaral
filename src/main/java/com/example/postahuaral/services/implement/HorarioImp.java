package com.example.postahuaral.services.implement;

import com.example.postahuaral.models.Horario;
import com.example.postahuaral.repository.HorarioRepo;
import com.example.postahuaral.services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("HorarioService")
public class HorarioImp implements HorarioService {

    @Qualifier
    HorarioRepo horarioRepo;

    @Autowired
    public HorarioImp (HorarioRepo horarioRepo) {
        this.horarioRepo = horarioRepo;
    }

    @Override
    public List<Horario> getHorarios() {
        List<Horario> result = horarioRepo.findAll();
        return result;
    }

    @Override
    public List<Horario> getHorariosByMedico(Long id) {
        List<Horario> result = horarioRepo.findAll();
        return result;
    }
}
