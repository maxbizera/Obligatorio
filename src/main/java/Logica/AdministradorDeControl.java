package Logica;

import java.util.ArrayList;

public abstract class AdministradorDeControl {

    public abstract ArrayList<ResumenControl> listar(String documento);

    public abstract void agregar(ResumenControl consulta);

    public abstract void eliminar(ResumenControl consulta);

}
