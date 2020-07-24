package Dominio;

import java.time.Instant;
import java.util.ArrayList;
 import java.util.UUID;

public class Paciente {

    private final UUID id;
    private final String nombre;
    private final String documento;
    private final Instant fechaNacimiento;
    private final String servicioMedico;
    private final String medicoCabecera;
    private final boolean tieneFonasa;
    private final ArrayList<Registro> registros;

    public Paciente(String nombre, String documento, Instant fechaDeNacimiento, String servicioMedico, String medicoCabecera, boolean tieneFonasa) {
        this.id = UUID.randomUUID();
        this.registros = new ArrayList<>();
        this.nombre = nombre;
        this.fechaNacimiento = fechaDeNacimiento;
        this.servicioMedico = servicioMedico;
        this.medicoCabecera = medicoCabecera;
        this.tieneFonasa = tieneFonasa;
        this.documento = documento;
    }

    public Paciente(ArrayList<Registro> consultas, String nombre, String documento, Instant fechaDeNacimiento, String servicioMedico, String medicoCabecera, boolean tieneFonasa) {
        this.id = UUID.randomUUID();
        this.registros = consultas;
        this.nombre = nombre;
        this.fechaNacimiento = fechaDeNacimiento;
        this.servicioMedico = servicioMedico;
        this.medicoCabecera = medicoCabecera;
        this.tieneFonasa = tieneFonasa;
        this.documento = documento;
    }

    public String getId() {
        return this.id.toString();
    }

    public ArrayList<Registro> getRegistros() {
        return this.registros;
    }

    public void agregarRegistro(Registro registro) {
        this.registros.add(registro);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public Instant getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getServicioMedico() {
        return servicioMedico;
    }

    public String getMedicoCabecera() {
        return medicoCabecera;
    }

    public boolean isTieneFonasa() {
        return tieneFonasa;
    }

}
