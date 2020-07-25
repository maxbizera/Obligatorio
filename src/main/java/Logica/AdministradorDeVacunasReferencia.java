package Logica;

import Dominio.Paciente;
import Dominio.PacienteNoEncontradoException;
import Dominio.RepositorioDePacientes;
import Dominio.Vacuna;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministradorDeVacunasReferencia extends AdministradorDeVacunas {

    private final RepositorioDePacientes repositorio;

    public AdministradorDeVacunasReferencia(RepositorioDePacientes repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public ArrayList<ResumenVacuna> listar(String documento) {
        ArrayList<ResumenVacuna> respuesta = new ArrayList<>();
        try {
            Paciente paciente = this.repositorio.obtener(documento);
            paciente.getVacunas().forEach(vacuna -> {
                respuesta.add(new ResumenVacuna(paciente.getDocumento(), vacuna.getFecha(), vacuna.getNombre(), vacuna.getDosis(), vacuna.esObligatoria()));
            }
            );
        } catch (PacienteNoEncontradoException ex) {
            Logger.getLogger(AdministradorDeVacunasReferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public void agregar(ResumenVacuna vacuna) {
        try {
            Paciente paciente = this.repositorio.obtener(vacuna.documento);
            paciente.agregarVacuna(new Vacuna(vacuna.fechaDeRegistro, vacuna.nombre, vacuna.dosis, vacuna.obligatoria));
        } catch (PacienteNoEncontradoException ex) {
            Logger.getLogger(AdministradorDeVacunasReferencia.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(ResumenVacuna vacuna) {
        try {
            Paciente paciente = this.repositorio.obtener(vacuna.documento);
            paciente.eliminarVacuna(new Vacuna(vacuna.fechaDeRegistro, vacuna.nombre, vacuna.dosis, vacuna.obligatoria));
        } catch (PacienteNoEncontradoException ex) {
            Logger.getLogger(AdministradorDeVacunasReferencia.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
