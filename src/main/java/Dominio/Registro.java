package Dominio;

import java.util.Date;

public class Registro {

    private final Date fecha;
    private final String tipo;

    public Registro(String tipo, Date fecha) {
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public Date getFecha() {
        return this.fecha;
    }
}
