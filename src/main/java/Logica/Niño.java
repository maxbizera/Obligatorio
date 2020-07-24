package Logica;

import java.util.Date;

public class Niño {

    private final String id;

    public Niño(String id,String nombre,String documento) {
        this.id = id;
    }

    public Niño() {
        this.id = "";
    }

    public String getId() {
        return this.id;
    }

}
