package Logica;

import java.util.ArrayList;

public abstract class AdministradorDeNiños {

    public abstract ArrayList<ResumenNiño> listar();

    public abstract Niño obtener(String id) throws NiñoNoExistenteException;

    public abstract void registrar(Niño niño);

}
