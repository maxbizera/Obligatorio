package Dominio;

import java.util.ArrayList;
import java.util.UUID;

public class Paciente {

    private final UUID id;
    private final ArrayList<Registro> registros;

    public Paciente() {
        this.id = UUID.randomUUID();
        this.registros = new ArrayList<>();
    }

    public Paciente(ArrayList<Registro> consultas) {
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
