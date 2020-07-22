package Logica;

import java.util.Date;

public class Vacuna {

    private final String idNiño;
    private final Date fechaDeRegistro;

    Vacuna(String idNiño, Date fechaDeRegistro) {
        this.idNiño = idNiño;
        this.fechaDeRegistro = fechaDeRegistro;
    }

    Date getFecha() {
        return this.fechaDeRegistro;
    }

    String getIdNiño() {
        return this.idNiño;
    }

}
