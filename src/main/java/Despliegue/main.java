package Despliegue;

import Dominio.RepositorioDePacientes;
import Dominio.RepositorioDePacientesEnMemoria;
import Logica.AdministradorDeNiños;
import Logica.AdministradorDeNiñosReferencia;
import Vistas.ListaNiños;
import java.io.FileNotFoundException;

public class main {

    public static void main(String[] args) throws FileNotFoundException {

        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria();
        AdministradorDeNiños administradorDeNiño = new AdministradorDeNiñosReferencia(repositorio);
        new ListaNiños(administradorDeNiño).setVisible(true);

    }

}
