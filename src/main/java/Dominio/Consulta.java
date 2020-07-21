package Dominio;

import java.util.Date;

public class Consulta {

    private final Date fecha;

    public Consulta(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return this.fecha;
    }
}
