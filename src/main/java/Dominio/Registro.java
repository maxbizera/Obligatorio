package Dominio;

import java.util.Date;

public class Registro {

    private final Date fecha;
    private final String tipo;
    private final String data;

    public Registro(String tipo, Date fecha, String data) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.data = data;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public String getData() {
        return data;
    }
}
