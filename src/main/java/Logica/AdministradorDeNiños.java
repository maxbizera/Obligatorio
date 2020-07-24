package Logica;

import java.util.ArrayList;

public abstract class AdministradorDeNiños {

    public abstract ArrayList<ResumenNiño> listar();

    public abstract Niño obtener(String id) throws NiñoNoExistenteException;

    public abstract void registrar(Niño niño);

    public abstract void eliminar(String id);

    public abstract void modificar(Niño niño);

}
