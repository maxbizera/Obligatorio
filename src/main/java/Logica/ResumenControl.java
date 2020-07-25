package Logica;

import java.util.Date;

public class ResumenControl {

    public String documento;
    public Date fechaDeRegistro;
    public String peso;
    public String altura;

    public ResumenControl(String documento, Date fechaDeRegistro, String peso, String altura) {
        this.documento = documento;
        this.fechaDeRegistro = fechaDeRegistro;
        this.peso = peso;
        this.altura = altura;
    }

}
