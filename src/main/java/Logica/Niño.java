package Logica;

import java.util.Date;

public class Niño {

    private final String document;
    private final String nombre;
    private final String fechaDeNacimiento;
    private final String servicioMedico;
    private final String medicoCabezera;
    private final boolean fonasa;
    private final String sexo;

    public Niño(String document, String nombre, String fechaDeNacimiento, String servicioMedico, String medicoCabezera, boolean fonasa, String sexo) {
        this.document = document;
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.servicioMedico = servicioMedico;
        this.medicoCabezera = medicoCabezera;
        this.fonasa = fonasa;
        this.sexo = sexo;
    }

    public String getDocument() {
        return this.document;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String getFechaDeNacimiento() {
        return this.fechaDeNacimiento;
    }
    
    public String getServicioMedico() {
        return this.servicioMedico;
    }
    
    public String getMedicoCabezera() {
        return this.medicoCabezera;
    }
    
    public boolean getFonasa() {
        return this.fonasa;
    }
    
    public String getSexo() {
        return this.sexo;
    }

}
