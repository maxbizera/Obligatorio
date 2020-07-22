package Logica;

import Dominio.RepositorioDePacientes;
import Dominio.Paciente;
import Dominio.Registro;
import java.util.ArrayList;
import java.util.Date;

public class AdministradorDeRegistroReferencia extends AdministradorDeRegistro {

    private final RepositorioDePacientes repositorio;

    public AdministradorDeRegistroReferencia(RepositorioDePacientes repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public int contarConsultasHastaFecha(Date fecha) {

        int respuesta = 0;
        ArrayList<Paciente> niños = this.repositorio.listar();
        ArrayList<Registro> consultas = this.buscarConsultasEnRepositorio(niños);
        ArrayList<Registro> consultasPorFecha = this.filtrarConsultasPorFecha(consultas, fecha);
        respuesta = consultasPorFecha.size();

        return respuesta;
    }

    @Override
    public void agregarConsulta(Consulta consulta) throws ConsultaNoAgregadaException {
        try {
            Paciente niño = this.repositorio.obtener(consulta.getIdNiño());
            niño.agregarRegistro(new Registro("consulta", consulta.getFecha()));
        } catch (Dominio.PacienteNoEncontradoException e) {
            throw new ConsultaNoAgregadaException();
        }
    }

    @Override
    public void agregarVacuna(Vacuna vacuna) throws VacunaNoAgregadaException {
        try {
            Paciente niño = this.repositorio.obtener(vacuna.getIdNiño());
            niño.agregarRegistro(new Registro("vacuna", vacuna.getFecha()));
        } catch (Dominio.PacienteNoEncontradoException e) {
            throw new VacunaNoAgregadaException();
        }
    }

    @Override
    public void agregarControl(Control control) throws ControlNoAgregadoException {
        try {
            Paciente niño = this.repositorio.obtener(control.getIdNiño());
            niño.agregarRegistro(new Registro("control", control.getFecha()));
        } catch (Dominio.PacienteNoEncontradoException e) {
            throw new ControlNoAgregadoException();
        }
    }

    private ArrayList<Registro> buscarConsultasEnRepositorio(ArrayList<Paciente> niños) {
        ArrayList<Registro> respuesta = new ArrayList();
        niños.forEach(niño -> {
            niño.getRegistros().forEach(registro -> respuesta.add(registro));
        });
        return respuesta;
    }

    private ArrayList<Registro> filtrarConsultasPorFecha(ArrayList<Registro> consultas, Date fecha) {
        ArrayList<Registro> respuesta = new ArrayList();
        consultas.forEach(consulta -> {
            if (consulta.getFecha().compareTo(fecha) <= 0) {
                respuesta.add(consulta);
            }
        });
        return respuesta;
    }
}
