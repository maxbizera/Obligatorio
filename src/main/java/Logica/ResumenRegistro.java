package Logica;

import java.util.Date;

public class ResumenRegistro {

    private final String documento;
    private final String fechaDeRegistro;
    private final String nombre;

    public ResumenRegistro(String documento, String fechaDeRegistro, String nombre) {
        this.documento = documento;
        this.fechaDeRegistro = fechaDeRegistro;
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public String getNombre() {
        return nombre;
    }

}
