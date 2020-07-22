package Logica;

import java.util.Date;

public abstract class AdministradorDeRegistro {

    public abstract int contarConsultasHastaFecha(Date fecha);

    public abstract void agregarConsulta(Consulta consulta);

}
