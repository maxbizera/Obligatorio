package Dominio;

public class NiñoNoEncontradoException extends Exception {

    public NiñoNoEncontradoException() {
        super("Niño no encontrado");
    }
}
