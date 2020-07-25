package Logica;

import Dominio.Paciente;
import Dominio.PacienteNoEncontradoException;
import Dominio.RepositorioDePacientes;
import Dominio.Control;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministradorDeControlReferencia extends AdministradorDeControl {

    private final RepositorioDePacientes repositorio;

    public AdministradorDeControlReferencia(RepositorioDePacientes repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public ArrayList<ResumenControl> listar(String documento) {
        ArrayList<ResumenControl> respuesta = new ArrayList<>();
        try {
            Paciente paciente = this.repositorio.obtener(documento);
            paciente.getControles().forEach(control -> {
                respuesta.add(new ResumenControl(paciente.getDocumento(), control.getFecha(), control.getPeso(), control.getAltura()));
            }
            );
        } catch (PacienteNoEncontradoException ex) {
            Logger.getLogger(AdministradorDeControlReferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public void agregar(ResumenControl control) {
        try {
            Paciente paciente = this.repositorio.obtener(control.documento);
            paciente.agregarControl(new Control(control.fechaDeRegistro, control.peso, control.altura));
        } catch (PacienteNoEncontradoException ex) {
            Logger.getLogger(AdministradorDeControlReferencia.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(ResumenControl control) {
        try {
            Paciente paciente = this.repositorio.obtener(control.documento);
            paciente.eliminarControl(new Control(control.fechaDeRegistro, control.peso, control.altura));
        } catch (PacienteNoEncontradoException ex) {
            Logger.getLogger(AdministradorDeControlReferencia.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
