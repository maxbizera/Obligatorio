package Dominio;

import java.util.Date;

public class Control {

    private final String idDeNiño;
    private final Date fechaDeRegistro;
    private final String peso;
    private final String altura;

    Control(String idDeNiño, Date fechaDeRegistro, String peso, String altura) {
        this.idDeNiño = idDeNiño;
        this.fechaDeRegistro = fechaDeRegistro;
        this.altura = altura;
        this.peso = peso;
    }

    String getIdNiño() {
        return this.idDeNiño;
    }

    Date getFecha() {
        return this.fechaDeRegistro;
    }

}
