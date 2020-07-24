package Logica;

public class ResumenNiño {

    private final String id;
    private final String nombre;
    private final String documento;
    private final String edad;
    private final String servicioDeSalud;

    public ResumenNiño(String id, String nombre, String documento, String edad, String servicioDeSalud) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.servicioDeSalud = servicioDeSalud;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEdad() {
        return edad;
    }

    public String getServicioDeSalud() {
        return servicioDeSalud;
    }

}
