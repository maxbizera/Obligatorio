package Logica;

import java.util.ArrayList;
import java.util.Date;

public abstract class AdministradorDeConsultas {

    public abstract ArrayList<ResumenConsulta> listar(String documento);

    public abstract void agregar(ResumenConsulta consulta);

    public abstract void eliminar(ResumenConsulta consulta);

    public abstract int contarConsultasHastaFecha(String documento, Date fecha);

}
