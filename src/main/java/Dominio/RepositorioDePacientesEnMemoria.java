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
        for (Paciente niño : this.data) {
            if (niño.getId().equals(id)) {
                respuesta = niño;
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

}
