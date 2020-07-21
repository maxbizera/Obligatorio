package Logica;

import Dominio.RepositorioDeNiñosEnMemoria;
import Dominio.Niño;
import Dominio.IRepositorioDeNiños;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AdministradorDeConsultasReferenciaTests {

    @Test
    public void deberiaRetornarElNumeroDeConsultasAntesDeUnaDeterminadaFecha() {
        //Arrange
        int respuestaEsperada = 1;
        Dominio.Consulta consulta = new Dominio.Consulta(new Date());
        ArrayList< Dominio.Consulta> consultas
                = new ArrayList<>();
        consultas.add(consulta);
        Niño niño1 = new Niño(consultas);
        ArrayList<Niño> lista = new ArrayList<>();
        lista.add((niño1));
        IRepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria(lista);
        Date fecha = new Date();
        IAdministradorDeConsultas administrador = new AdministradorDeConsultasReferencia(repositorio);
        //Act
        int respuestaActual = administrador.contarHastaFecha(fecha);
        //Assert
        assertEquals(respuestaEsperada, respuestaActual);
    }

    @Test
    public void deberiaRetornarCeroConsultasAlBuscarDespuesDeUnaDeterminadaFecha() {
        //Arrange
        int respuestaEsperada = 0;
        Date fechaFutura = new Date(System.currentTimeMillis() + 600000l);
        Dominio.Consulta consulta = new Dominio.Consulta(fechaFutura);
        ArrayList< Dominio.Consulta> consultas
                = new ArrayList<>();
        consultas.add(consulta);
        Niño niño1 = new Niño(consultas);
        ArrayList<Niño> lista = new ArrayList<>();
        lista.add((niño1));
        IRepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria(lista);
        Date fecha = new Date();
        IAdministradorDeConsultas administrador = new AdministradorDeConsultasReferencia(repositorio);
        //Act
        int respuestaActual = administrador.contarHastaFecha(fecha);
        //Assert
        assertEquals(respuestaEsperada, respuestaActual);
    }
}
