package Logica;

import Dominio.Consulta;
import Dominio.Paciente;
import Dominio.PacienteNoEncontradoException;
import Dominio.RepositorioDePacientes;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministradorDeConsultasReferencia extends AdministradorDeConsultas {

    private final RepositorioDePacientes repositorio;

    public AdministradorDeConsultasReferencia(RepositorioDePacientes repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public ArrayList<ResumenConsulta> listar(String documento) {
        ArrayList<ResumenConsulta> respuesta = new ArrayList<>();
        try {
            Paciente paciente = this.repositorio.obtener(documento);
            paciente.getConsultas().forEach(consulta
                    -> {
                respuesta.add(
                        new ResumenConsulta(paciente.getDocumento(), consulta.getMedico(), consulta.getDiagnostico(), consulta.getFecha(), consulta.getRecomendaciones())
                );
            }
            );
        } catch (PacienteNoEncontradoException ex) {
            Logger.getLogger(AdministradorDeConsultasReferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public void agregar(ResumenConsulta vacuna) {
        try {
            Paciente paciente = this.repositorio.obtener(vacuna.documento);
            paciente.agregarConsulta(new Consulta(vacuna.fechaDeRegistro, vacuna.medico, vacuna.diagnostico, vacuna.recomendaciones));
        } catch (PacienteNoEncontradoException ex) {
            Logger.getLogger(AdministradorDeConsultasReferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(ResumenConsulta vacuna) {
        try {
            Paciente paciente = this.repositorio.obtener(vacuna.documento);
            paciente.eliminarConsulta(new Consulta(vacuna.fechaDeRegistro, vacuna.medico, vacuna.diagnostico, vacuna.recomendaciones));
        } catch (PacienteNoEncontradoException ex) {
            Logger.getLogger(AdministradorDeConsultasReferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int contarConsultasHastaFecha(String documento, Date fecha) {
        int respuesta = 0;
        try {
            Paciente paciente = this.repositorio.obtener(documento);
            for (Consulta consulta : paciente.getConsultas()) {
                if (consulta.getFecha().before(fecha)) {
                    respuesta += 1;
                };
            }

        } catch (PacienteNoEncontradoException ex) {
            Logger.getLogger(AdministradorDeConsultasReferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

}
