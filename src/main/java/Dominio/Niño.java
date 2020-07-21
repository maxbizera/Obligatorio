package Dominio;

import java.util.ArrayList;
import java.util.UUID;

public class Niño {

    private final UUID id;
    private final ArrayList<Consulta> consultas;

    public Niño() {
        this.id = UUID.randomUUID();
        this.consultas = null;
    }

    public Niño(ArrayList<Consulta> consultas) {
        this.id = UUID.randomUUID();
        this.consultas = consultas;
    }

    public String getId() {
        return this.id.toString();
    }

    public ArrayList<Consulta> getConsultas() {
        return this.consultas;
    }
}
