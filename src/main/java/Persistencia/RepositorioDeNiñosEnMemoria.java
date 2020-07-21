package Persistencia;

import java.util.ArrayList;

public class RepositorioDeNiñosEnMemoria implements IRepositorioDeNiños {

    private final ArrayList<Niño> data;

    public RepositorioDeNiñosEnMemoria(ArrayList<Niño> data) {
        this.data = data;
    }

    public RepositorioDeNiñosEnMemoria() {
        this.data = new ArrayList<Niño>();
    }

    @Override
    public ArrayList<Niño> listar() {
        return this.data;
    }

}
