package Logica;

import Dominio.RepositorioDeNiños;
import Dominio.Niño;
import Dominio.Registro;
import java.util.ArrayList;
import java.util.Date;

public class AdministradorDeRegistroReferencia extends AdministradorDeRegistro {

    private final RepositorioDeNiños repositorio;

    public AdministradorDeRegistroReferencia(RepositorioDeNiños repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public int contarConsultasHastaFecha(Date fecha) {

        int respuesta = 0;
        ArrayList<Niño> niños = this.repositorio.listar();
        ArrayList<Registro> consultas = this.buscarConsultasEnRepositorio(niños);
        ArrayList<Registro> consultasPorFecha = this.filtrarConsultasPorFecha(consultas, fecha);
        respuesta = consultasPorFecha.size();

        return respuesta;
    }

    private ArrayList<Registro> buscarConsultasEnRepositorio(ArrayList<Niño> niños) {
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

    @Override
    public void agregarConsulta(Consulta consulta) throws ConsultaNoAgregadaException {
        try {
            Niño niño = this.repositorio.obtener(consulta.getIdNiño());
            niño.agregarRegistro(new Registro("consulta", consulta.getFecha()));
        } catch (Dominio.NiñoNoEncontradoException e) {
            throw new ConsultaNoAgregadaException();
        }
    }

    @Override
    public void agregarVacuna(Vacuna vacuna) throws VacunaNoAgregadaException {
        try {
            Niño niño = this.repositorio.obtener(vacuna.getIdNiño());
            niño.agregarRegistro(new Registro("vacuna", vacuna.getFecha()));
        } catch (Dominio.NiñoNoEncontradoException e) {
            throw new VacunaNoAgregadaException();
        }
    }
}
