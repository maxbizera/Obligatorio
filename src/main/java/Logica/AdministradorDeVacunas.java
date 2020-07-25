package Logica;

import java.util.ArrayList;

public abstract class AdministradorDeVacunas {

    public abstract ArrayList<ResumenVacuna> listar(String documento);

    public abstract void agregar(ResumenVacuna vacuna);

    public abstract void eliminar(ResumenVacuna vacuna);

}
