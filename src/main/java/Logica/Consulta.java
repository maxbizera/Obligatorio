package Logica;

import java.util.Date;

public class Consulta {

    private final String idNiño;
    private final Date fechaDeRegistro;
    private final String medico;
    private final String diagnostico;
    private final String recomendaciones;

    Consulta(String idNiño, Date fechaDeRegistro, String medico, String diagnostico, String recomendaciones) {
        this.idNiño = idNiño;
        this.fechaDeRegistro = fechaDeRegistro;
        this.medico = medico;
        this.diagnostico = diagnostico;
        this.recomendaciones = recomendaciones;
    }

    public String getIdNiño() {
        return this.idNiño;
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
