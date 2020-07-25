package Dominio;

import java.util.Date;

public class Vacuna {

    private final Date fechaDeRegistro;
    private final String nombre;
    private final int dosis;
    private final boolean obligatoria;

    public Vacuna(Date fechaDeRegistro, String nombre, int dosis, boolean obligatoria) {
        this.fechaDeRegistro = fechaDeRegistro;
        this.nombre = nombre;
        this.dosis = dosis;
        this.obligatoria = obligatoria;
    }

    public Date getFecha() {
        return this.fechaDeRegistro;
    }

    public int getDosis() {
        return this.dosis;
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean esObligatoria() {
        return this.obligatoria;
    }

}
