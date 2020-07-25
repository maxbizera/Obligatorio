package Logica;

import java.util.Date;

public class ResumenVacuna {

    public String documento;
    public Date fechaDeRegistro;
    public String nombre;
    public int dosis;
    public boolean obligatoria;

    public ResumenVacuna(String documento, Date fechaDeRegistro, String nombre, int dosis, boolean obligatoria) {
        this.documento = documento;
        this.fechaDeRegistro = fechaDeRegistro;
        this.nombre = nombre;
        this.dosis = dosis;
        this.obligatoria = obligatoria;
    }
}
