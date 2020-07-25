package Despliegue;

import Dominio.RepositorioDePacientes;
import Dominio.RepositorioDePacientesEnMemoria;
import Logica.AdministradorDeConsultas;
import Logica.AdministradorDeConsultasReferencia;
import Logica.AdministradorDeControl;
import Logica.AdministradorDeControlReferencia;
import Logica.AdministradorDeNiños;
import Logica.AdministradorDeNiñosReferencia;
import Logica.AdministradorDeVacunas;
import Logica.AdministradorDeVacunasReferencia;
import Vistas.ListaNiños;
import java.io.FileNotFoundException;

public class main {

    public static void main(String[] args) throws FileNotFoundException {

        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria();
        AdministradorDeNiños administradorDeNiño = new AdministradorDeNiñosReferencia(repositorio);

        AdministradorDeConsultas administradorDeConsultas = new AdministradorDeConsultasReferencia(repositorio);
        AdministradorDeControl administradorDeControles = new AdministradorDeControlReferencia(repositorio);
        AdministradorDeVacunas administradorDeVacunas = new AdministradorDeVacunasReferencia(repositorio);
        new ListaNiños(administradorDeNiño, administradorDeConsultas, administradorDeControles, administradorDeVacunas).setVisible(true);

    }

}
