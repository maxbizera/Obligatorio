package Logica;

import java.util.Date;

public class Control {

    private final String idDeNiño;
    private final Date fechaDeRegistro;

    Control(String idDeNiño, Date fechaDeRegistro) {
        this.idDeNiño = idDeNiño;
        this.fechaDeRegistro = fechaDeRegistro;
    }

    String getIdNiño() {
        return this.idDeNiño;
    }

    Date getFecha() {
        return this.fechaDeRegistro;
    }

}
