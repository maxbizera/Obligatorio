package Dominio;

public class PacienteNoEncontradoException extends Exception {

    public PacienteNoEncontradoException() {
        super("Paciente no encontrado");
    }
}
