package Dominio;

import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Paciente {

    private final String nombre;
    private final String documento;
    private final Instant fechaNacimiento;
    private final String servicioMedico;
    private final String medicoCabecera;
    private final boolean tieneFonasa;
    private final ArrayList<Consulta> consultas;
    private final ArrayList<Vacuna> vacunas;
    private final ArrayList<Control> controles;

    public Paciente(String nombre, String documento, Instant fechaDeNacimiento, String servicioMedico, String medicoCabecera, boolean tieneFonasa) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaDeNacimiento;
        this.servicioMedico = servicioMedico;
        this.medicoCabecera = medicoCabecera;
        this.tieneFonasa = tieneFonasa;
        this.documento = documento;
        this.consultas = new ArrayList<>();
        this.vacunas = new ArrayList<>();
        this.controles = new ArrayList<>();
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

    public String getEdad() {
        Instant now = Instant.now();
        Instant ago = this.getFechaNacimiento();

        long edad = ChronoUnit.YEARS.between(
                ago.atZone(ZoneId.systemDefault()),
                now.atZone(ZoneId.systemDefault()));
        return String.valueOf(edad);
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public ArrayList<Vacuna> getVacunas() {
        return vacunas;
    }

    public ArrayList<Control> getControles() {
        return controles;
    }

    public void agregarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public void agregarControl(Control control) {
        this.controles.add(control);
    }

    public void agregarVacuna(Vacuna vacuna) {
        this.vacunas.add(vacuna);
    }

    public void eliminarConsulta(Consulta consulta) {
        for (Consulta consultaRepo : this.consultas) {
            if (consultaRepo.getFecha().equals(consulta.getFecha())) {
                this.consultas.remove(consultaRepo);
            }
        }
    }

    public void eliminarControl(Control control) {
        for (Control controlRepo : this.controles) {
            if (controlRepo.getPeso().equals(control.getPeso())) {
                this.controles.remove(controlRepo);
            }
        }
    }

    public void eliminarVacuna(Vacuna vacuna) {
        for (Vacuna vacunaRepo : this.vacunas) {
            if (vacunaRepo.getFecha().equals(vacuna.getFecha())) {
                this.vacunas.remove(vacunaRepo);
            }
        }
    }

}
