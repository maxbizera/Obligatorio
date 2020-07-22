package Logica;

import java.util.Date;

public class Consulta {

    private final String idNiño;
    private final Date fechaDeRegistro;

    Consulta(String idNiño, Date fechaDeRegistro) {
        this.idNiño = idNiño;
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public String getIdNiño() {
        return this.idNiño;
    }

    public Date getFecha() {
        return this.fechaDeRegistro;
    }
}
