/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.Paciente;
import Dominio.RepositorioDePacientes;
import java.util.ArrayList;

/**
 *
 * @author gcarrillo
 */
public class AdministradorDeNiñosReferencia extends AdministradorDeNiños {

    private final RepositorioDePacientes repositorio;

    public AdministradorDeNiñosReferencia(RepositorioDePacientes repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public ArrayList<ResumenNiño> listar() {
        ArrayList<ResumenNiño> respuesta = new ArrayList<ResumenNiño>();
        this.repositorio.listar().forEach(niño -> {
            respuesta.add(new ResumenNiño());
        });

        return respuesta;
    }

}
