package com.example.postahuaral.converter;

import com.example.postahuaral.models.Cita;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CitaDatos {
    private int idcita;
    private double pagotransferencia;
    private double pagototal;
    private char estado;
    private long idusuario;
    private long idmedico;

    public Cita getCita() {
        Cita cita = new Cita();
        cita.setIdcita(idcita);
        cita.setPagotransferencia(pagotransferencia);
        cita.setPagototal(pagototal);
        cita.setEstado(estado);
        return cita;
    }
}
