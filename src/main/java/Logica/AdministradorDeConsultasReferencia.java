/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.IRepositorioDeNiños;
import Persistencia.Niño;
import Persistencia.Consulta;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gcarrillo
 */
public class AdministradorDeConsultasReferencia implements IAdministradorDeConsultas {

    private final IRepositorioDeNiños repositorio;

    public AdministradorDeConsultasReferencia(IRepositorioDeNiños repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public int contarHastaFecha(Date fecha) {

        int respuesta = 0;
        ArrayList<Niño> niños = this.repositorio.listar();
        ArrayList<Consulta> consultas = this.buscarConsultasEnRepositorio(niños);
        ArrayList<Consulta> consultasPorFecha = this.filtrarConsultasPorFecha(consultas, fecha);
        respuesta = consultasPorFecha.size();

        return respuesta;
    }

    private ArrayList<Consulta> buscarConsultasEnRepositorio(ArrayList<Niño> niños) {
        ArrayList<Consulta> respuesta = new ArrayList();
        niños.forEach(niño -> {
            niño.consultas.forEach(consulta -> respuesta.add(consulta));
        });
        return respuesta;
    }

    private ArrayList<Consulta> filtrarConsultasPorFecha(ArrayList<Consulta> consultas, Date fecha) {
        ArrayList<Consulta> respuesta = new ArrayList();
        consultas.forEach(consulta -> {
            if (consulta.fecha.compareTo(fecha) <= 0) {
                respuesta.add(consulta);
            }
        });
        return respuesta;
    }

}
