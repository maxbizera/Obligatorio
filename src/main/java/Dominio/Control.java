package Dominio;

import java.util.Date;

public class Control {

    private final Date fechaDeRegistro;
    private final String peso;
    private final String altura;

    public Control(Date fechaDeRegistro, String peso, String altura) {
        this.fechaDeRegistro = fechaDeRegistro;
        this.altura = altura;
        this.peso = peso;
    }

    public Date getFecha() {
        return this.fechaDeRegistro;
    }

    public String getPeso() {
        return peso;
    }

    public String getAltura() {
        return altura;
    }

}
