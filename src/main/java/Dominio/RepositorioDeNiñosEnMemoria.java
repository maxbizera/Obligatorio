package Dominio;

import java.util.ArrayList;

public class RepositorioDeNiñosEnMemoria implements IRepositorioDeNiños {

    private final ArrayList<Niño> data;

    public RepositorioDeNiñosEnMemoria(ArrayList<Niño> data) {
        this.data = data;
    }

    public RepositorioDeNiñosEnMemoria() {
        this.data = new ArrayList<>();
    }

    @Override
    public ArrayList<Niño> listar() {
        return this.data;
    }

    @Override
    public Niño obtener(String id) {
        Niño respuesta = null;
        for (Niño niño : this.data) {
            if (niño.getId().equals(id)) {
                respuesta = niño;
            }
        }
        return respuesta;
    }

}
