package Dominio;

import java.util.ArrayList;

public abstract class RepositorioDePacientes {

    public abstract ArrayList<Paciente> listar();

    public abstract Paciente obtener(String id) throws PacienteNoEncontradoException;

}
