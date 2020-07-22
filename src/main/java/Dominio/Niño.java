package Dominio;

import java.util.ArrayList;
import java.util.UUID;

public class Niño {

    private final UUID id;
    private final ArrayList<Registro> registros;

    public Niño() {
        this.id = UUID.randomUUID();
        this.registros = new ArrayList<>();
    }

    public Niño(ArrayList<Registro> consultas) {
        this.id = UUID.randomUUID();
        this.registros = consultas;
    }

    public String getId() {
        return this.id.toString();
    }

    public ArrayList<Registro> getRegistros() {
        return this.registros;
    }

    public void agregarRegistro(Registro registro) {
        this.registros.add(registro);
    }
}
