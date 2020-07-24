/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.Paciente;
import Dominio.Registro;
import Dominio.RepositorioDePacientes;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

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
        ArrayList<ResumenNiño> respuesta = new ArrayList<>();
        this.repositorio.listar().forEach(niño -> {
            Instant now = Instant.now();
            Instant ago = niño.getFechaNacimiento();

            long edad = ChronoUnit.YEARS.between(
                    ago.atZone(ZoneId.systemDefault()),
                    now.atZone(ZoneId.systemDefault()));
            
            respuesta.add(new ResumenNiño(niño.getId(), niño.getNombre(), niño.getDocumento(), String.valueOf(edad), niño.getServicioMedico()));
        });

        return respuesta;
    }

    @Override
    public Niño obtener(String id) throws NiñoNoExistenteException {
        try {
            Paciente paciente = this.repositorio.obtener(id);
            Niño niño = new Niño(
                paciente.getDocumento(),
                paciente.getNombre(),
                paciente.getFechaNacimiento().toString(),
                paciente.getServicioMedico(),
                paciente.getMedicoCabecera(),
                true,
                "Niño"
            );
            return niño;
        } catch (Dominio.PacienteNoEncontradoException e) {
            throw new NiñoNoExistenteException();
        }
    }

    @Override
    public void registrar(Niño niño) {
        this.repositorio.agregar(new Paciente("", "", Instant.now(), "", "", false));
    }

    @Override
    public Niño obtenerPorDocumento(String document) throws NiñoNoExistenteException {
        try {
            Paciente paciente = this.repositorio.obtenerPorDocumento(document);
            Niño niño = new Niño(
                paciente.getDocumento(),
                paciente.getNombre(),
                paciente.getFechaNacimiento().toString(),
                paciente.getServicioMedico(),
                paciente.getMedicoCabecera(),
                true,
                "Niño"
            );
            return niño;
        } catch (Dominio.PacienteNoEncontradoException e) {
            throw new NiñoNoExistenteException();
        }
    }

}
