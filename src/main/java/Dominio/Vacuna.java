package Dominio;

import java.util.Date;

public class Vacuna {

    private final String idNiño;
    private final Date fechaDeRegistro;
    private final String nombre;
    private final int dosis;
    private final boolean obligatoria;

    Vacuna(String idNiño, Date fechaDeRegistro, String nombre, int dosis, boolean obligatoria) {
        this.idNiño = idNiño;
        this.fechaDeRegistro = fechaDeRegistro;
        this.nombre = nombre;
        this.dosis = dosis;
        this.obligatoria = obligatoria;
    }

    Date getFecha() {
        return this.fechaDeRegistro;
    }

    String getIdNiño() {
        return this.idNiño;
    }

    int getDosis() {
        return this.dosis;
    }

    String getNombre() {
        return this.nombre;
    }

    boolean esObligatoria() {
        return this.obligatoria;
    }

}
