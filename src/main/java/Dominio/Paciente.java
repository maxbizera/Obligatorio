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
        Consulta consult = null;

        for (Consulta consultaRepo : this.consultas) {
            if (consultaRepo.getFecha().equals(consulta.getFecha())) {
                consult = consultaRepo;
            }
        }
        if (consult != null) {
            this.consultas.remove(consult);
        }
    }

    public void eliminarControl(Control control) {
        Control contr = null;

        for (Control controlRepo : this.controles) {
            if (controlRepo.getFecha().equals(control.getFecha())) {
                contr = controlRepo;
            }
        }
        if (control != null) {
            this.controles.remove(control);
        }
    }

    public void eliminarVacuna(Vacuna vacuna) {
        Vacuna vacu = null;

        for (Vacuna vacRepo : this.vacunas) {
            if (vacRepo.getFecha().equals(vacuna.getFecha())) {
                vacu = vacRepo;
            }
        }
        if (vacu != null) {
            this.vacunas.remove(vacu);
        }
    }

}
