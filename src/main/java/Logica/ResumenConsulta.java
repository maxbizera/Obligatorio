package Logica;

import java.util.Date;

public class ResumenConsulta {

    public String documento;
    public Date fechaDeRegistro;
    public String medico;
    public String diagnostico;
    public String recomendaciones;

    public ResumenConsulta(String documento, String medico, String diagnostico, Date fecha, String recomendaciones) {
        this.documento = documento;
        this.medico = medico;
        this.diagnostico = diagnostico;
        this.fechaDeRegistro = fecha;
        this.recomendaciones = recomendaciones;
    }
}
