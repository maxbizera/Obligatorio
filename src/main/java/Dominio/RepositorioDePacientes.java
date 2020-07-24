package Dominio;

import java.util.ArrayList;

public abstract class RepositorioDePacientes {

    public abstract ArrayList<Paciente> listar();

    public abstract Paciente obtener(String id) throws PacienteNoEncontradoException;

    public abstract void agregar(Paciente paciente);

    public abstract Paciente obtenerPorDocumento(String document) throws PacienteNoEncontradoException;

}
