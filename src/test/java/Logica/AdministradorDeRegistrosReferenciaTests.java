package Logica;

import Dominio.RepositorioDeNiñosEnMemoria;
import Dominio.Niño;
import Dominio.RepositorioDeNiños;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AdministradorDeRegistrosReferenciaTests {

    @Test
    public void deberiaRetornarElNumeroDeConsultasAntesDeUnaDeterminadaFecha() {
        //Arrange
        int respuestaEsperada = 1;
        Dominio.Registro consulta = new Dominio.Registro("consulta", new Date(System.currentTimeMillis() - 600000l));
        ArrayList< Dominio.Registro> consultas
                = new ArrayList<>();
        consultas.add(consulta);
        Niño niño1 = new Niño(consultas);
        ArrayList<Niño> lista = new ArrayList<>();
        lista.add((niño1));
        RepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria(lista);
        Date fecha = new Date();
        AdministradorDeRegistro administrador = new AdministradorDeRegistroReferencia(repositorio);
        //Act
        int respuestaActual = administrador.contarConsultasHastaFecha(fecha);
        //Assert
        assertEquals(respuestaEsperada, respuestaActual);
    }

    @Test
    public void deberiaRetornarCeroConsultasAlBuscarDespuesDeUnaDeterminadaFecha() {
        //Arrange
        int respuestaEsperada = 0;
        Date fechaFutura = new Date(System.currentTimeMillis() + 600000l);
        Dominio.Registro consulta = new Dominio.Registro("consulta", fechaFutura);
        ArrayList< Dominio.Registro> consultas
                = new ArrayList<>();
        consultas.add(consulta);
        Niño niño1 = new Niño(consultas);
        ArrayList<Niño> lista = new ArrayList<>();
        lista.add((niño1));
        RepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria(lista);
        Date fecha = new Date();
        AdministradorDeRegistro administrador = new AdministradorDeRegistroReferencia(repositorio);
        //Act
        int respuestaActual = administrador.contarConsultasHastaFecha(fecha);
        //Assert
        assertEquals(respuestaEsperada, respuestaActual);
    }

    @Test
    public void deberiaPoderAgregarUnaConsultaAUnNiñoExistente() {
        //Arrange
        int respuestaEsperada = 1;
        Date fechaDeRegistro = new Date();
        Niño niño1 = new Niño();
        ArrayList<Niño> data = new ArrayList<>();
        data.add(niño1);
        RepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria(data);
        AdministradorDeRegistro administrador = new AdministradorDeRegistroReferencia(repositorio);
        Logica.Consulta consulta = new Consulta(niño1.getId(), fechaDeRegistro);
        //Act
        administrador.agregarConsulta(consulta);
        //Assert
        int respuestaActual = niño1.getRegistros().size();
        assertEquals(respuestaEsperada, respuestaActual);
    }

    @Test
    public void deberiaLanzarUnaExcepcionAlAgregarUnaConsultaAUnNiñoNoExistente() {
        //Arrange
        int respuestaEsperada = 1;
        Date fechaDeRegistro = new Date();
        Niño niño1 = new Niño();
        ArrayList<Niño> data = new ArrayList<>();
        data.add(niño1);
        RepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria(data);
        AdministradorDeRegistro administrador = new AdministradorDeRegistroReferencia(repositorio);
        Logica.Consulta consulta = new Consulta(niño1.getId(), fechaDeRegistro);
        //Act
        administrador.agregarConsulta(consulta);
        //Assert
        int respuestaActual = niño1.getRegistros().size();
        assertEquals(respuestaEsperada, respuestaActual);
    }
}
