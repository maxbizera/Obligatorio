package Dominio;

import java.util.ArrayList;

public interface IRepositorioDeNiños {

    public ArrayList<Niño> listar();

    public Niño obtener(String id);

}
