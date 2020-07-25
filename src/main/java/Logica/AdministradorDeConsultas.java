package Logica;

import java.util.ArrayList;
import java.util.Date;

public abstract class AdministradorDeConsultas {

    public abstract ArrayList<ResumenConsulta> listar(String documento);

    public abstract void agregar(ResumenConsulta vacuna);

    public abstract void eliminar(ResumenConsulta vacuna);

    public abstract int contarConsultasHastaFecha(Date fecha);

}
