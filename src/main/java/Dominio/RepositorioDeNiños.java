package Dominio;

import java.util.ArrayList;

public abstract class RepositorioDeNiños {

    public abstract ArrayList<Niño> listar();

    public abstract Niño obtener(String id) throws NiñoNoEncontradoException;

}
