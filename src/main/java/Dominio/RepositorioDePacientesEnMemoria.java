package Dominio;

import java.util.ArrayList;

public class RepositorioDePacientesEnMemoria extends RepositorioDePacientes {

    private final ArrayList<Paciente> data;

    public RepositorioDePacientesEnMemoria(ArrayList<Paciente> data) {
        this.data = data;
    }

    public RepositorioDePacientesEnMemoria() {
        this.data = new ArrayList<>();
    }

    @Override
    public ArrayList<Paciente> listar() {
        return this.data;
    }

    @Override
    public Paciente obtener(String id) throws PacienteNoEncontradoException {
        Paciente respuesta = null;
        for (Paciente paciente : this.data) {
            if (paciente.getDocumento().equals(id)) {
                respuesta = paciente;
            }
        }
        if (respuesta != null) {
            return respuesta;
        } else {
            throw new PacienteNoEncontradoException();
        }
    }

    @Override
    public void agregar(Paciente paciente) {
        this.data.add(paciente);
    }

    @Override
    public void eliminar(String id) {
        Paciente pacienteEncontrado=  null;
        for (Paciente paciente : this.data) {
            if (paciente.getDocumento().equals(id)) {
                pacienteEncontrado = paciente;
            }
        }
        if (pacienteEncontrado != null) {
            this.data.remove(pacienteEncontrado);
        }
    }

}
