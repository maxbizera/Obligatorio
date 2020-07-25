package Dominio;

import java.util.Date;

public class Consulta {

    private final Date fechaDeRegistro;
    private final String medico;
    private final String diagnostico;
    private final String recomendaciones;

    public Consulta(Date fechaDeRegistro, String medico, String diagnostico, String recomendaciones) {
        this.fechaDeRegistro = fechaDeRegistro;
        this.medico = medico;
        this.diagnostico = diagnostico;
        this.recomendaciones = recomendaciones;
    }

    public Date getFecha() {
        return this.fechaDeRegistro;
    }

    public String getMedico() {
        return this.medico;
    }

    public String getDiagnostico() {
        return this.diagnostico;
    }

    public String getRecomendaciones() {
        return this.recomendaciones;
    }
}
