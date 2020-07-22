package Dominio;

import java.util.ArrayList;

public class RepositorioDeNiñosEnMemoria extends RepositorioDeNiños {

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
    public Niño obtener(String id) throws NiñoNoEncontradoException {
        Niño respuesta = null;
        for (Niño niño : this.data) {
            if (niño.getId().equals(id)) {
                respuesta = niño;
            }
        }
        if (respuesta != null) {
            return respuesta;
        } else {
            throw new NiñoNoEncontradoException();
        }
    }

}
