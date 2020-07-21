package Persistencia;

import java.util.ArrayList;

/**
 *
 * @author gcarrillo
 */
public class Niño {

    public ArrayList<Consulta> consultas;

    public Niño() {
        this.consultas = null;
    }

    public Niño(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

}
