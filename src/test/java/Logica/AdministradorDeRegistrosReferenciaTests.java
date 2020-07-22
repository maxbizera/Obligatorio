package Logica;

import Dominio.RepositorioDePacientesEnMemoria;
import Dominio.Paciente;
import Dominio.RepositorioDePacientes;
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
        Paciente niño1 = new Paciente(consultas);
        ArrayList<Paciente> lista = new ArrayList<>();
        lista.add((niño1));
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria(lista);
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
        Paciente niño1 = new Paciente(consultas);
        ArrayList<Paciente> lista = new ArrayList<>();
        lista.add((niño1));
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria(lista);
        Date fecha = new Date();
        AdministradorDeRegistro administrador = new AdministradorDeRegistroReferencia(repositorio);
        //Act
        int respuestaActual = administrador.contarConsultasHastaFecha(fecha);
        //Assert
        assertEquals(respuestaEsperada, respuestaActual);
    }

    @Test
    public void deberiaPoderAgregarUnaConsultaAUnNiñoExistente() throws ConsultaNoAgregadaException {
        //Arrange
        int respuestaEsperada = 1;
        Date fechaDeRegistro = new Date();
        Paciente niño1 = new Paciente();
        ArrayList<Paciente> data = new ArrayList<>();
        data.add(niño1);
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria(data);
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
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria();
        AdministradorDeRegistro administrador = new AdministradorDeRegistroReferencia(repositorio);
        Logica.Consulta consulta = new Consulta("", new Date());
        //Act
        //Assert
        assertThrows(ConsultaNoAgregadaException.class, () -> {
            administrador.agregarConsulta(consulta);
        });
    }

    @Test
    public void deberiaPoderAgregarUnaVacunaAUnNiñoExistente() throws VacunaNoAgregadaException {
        //Arrange
        int respuestaEsperada = 1;
        Date fechaDeRegistro = new Date();
        Paciente niño1 = new Paciente();
        ArrayList<Paciente> data = new ArrayList<>();
        data.add(niño1);
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria(data);
        AdministradorDeRegistro administrador = new AdministradorDeRegistroReferencia(repositorio);
        Logica.Vacuna vacuna = new Vacuna(niño1.getId(), fechaDeRegistro);
        //Act
        administrador.agregarVacuna(vacuna);
        //Assert
        int respuestaActual = niño1.getRegistros().size();
        assertEquals(respuestaEsperada, respuestaActual);
    }

    @Test
    public void deberiaLanzarUnaExcepcionAlAgregarUnaVacunaAUnNiñoNoExistente() {
        //Arrange
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria();
        AdministradorDeRegistro administrador = new AdministradorDeRegistroReferencia(repositorio);
        Logica.Vacuna vacuna = new Vacuna("", new Date());
        //Act
        //Assert
        assertThrows(VacunaNoAgregadaException.class, () -> {
            administrador.agregarVacuna(vacuna);
        });
    }

    @Test
    public void deberiaPoderAgregarUnControlAUnNiñoExistente() throws ControlNoAgregadoException {
        //Arrange
        int respuestaEsperada = 1;
        Date fechaDeRegistro = new Date();
        Paciente niño1 = new Paciente();
        ArrayList<Paciente> data = new ArrayList<>();
        data.add(niño1);
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria(data);
        AdministradorDeRegistro administrador = new AdministradorDeRegistroReferencia(repositorio);
        Logica.Control control = new Control(niño1.getId(), fechaDeRegistro);
        //Act
        administrador.agregarControl(control);
        //Assert
        int respuestaActual = niño1.getRegistros().size();
        assertEquals(respuestaEsperada, respuestaActual);
    }
}
