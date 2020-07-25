package Logica;

import java.util.ArrayList;
import java.util.Date;

public abstract class AdministradorDeRegistro {

    public abstract ArrayList<ResumenRegistro> listar(String documento);

    public abstract int contarConsultasHastaFecha(Date fecha);

    public abstract void agregarConsulta(Consulta consulta) throws ConsultaNoAgregadaException;

    public abstract void agregarVacuna(Vacuna vacuna) throws VacunaNoAgregadaException;

    public abstract void agregarControl(Control control) throws ControlNoAgregadoException;

}
