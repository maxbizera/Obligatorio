package Logica;

import Dominio.RepositorioDePacientesEnMemoria;
import Dominio.Paciente;
import Dominio.RepositorioDePacientes;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AdministradorDeNiñosReferenciaTests {

    @Test
    public void deberiaTraerUnListadoVacioSiNoHayNiñosEnElSistema() {
        //Arrange
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria();
        AdministradorDeNiños administrador = new AdministradorDeNiñosReferencia(repositorio);
        ArrayList<ResumenNiño> respuestaEsperada = new ArrayList<>();
        //Act
        ArrayList<ResumenNiño> respuestaActual = administrador.listar();
        //Assert
        assertEquals(respuestaEsperada.size(), respuestaActual.size());
    }

    @Test
    public void deberiaPoderListarTodosLosNiñosExistentesEnElSistema() {
        //Arrange
        Paciente niño1 = new Paciente("", "", new Date(), "", "", false);;
        ArrayList<Paciente> lista = new ArrayList<>();
        lista.add((niño1));
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria(lista);
        AdministradorDeNiños administrador = new AdministradorDeNiñosReferencia(repositorio);
        ArrayList<ResumenNiño> respuestaEsperada = new ArrayList<>();
        ResumenNiño niñoEsperado = new ResumenNiño("", "", "", "", "");
        respuestaEsperada.add(niñoEsperado);
        //Act
        ArrayList<ResumenNiño> respuestaActual = administrador.listar();
        //Assert
        assertEquals(respuestaEsperada.size(), respuestaActual.size());
    }

    @Test
    public void deberiaPoderObtenerUnNiñoExistentePorId() throws NiñoNoExistenteException {
        //Arrange
        Paciente niño = new Paciente("", "", new Date(), "", "", false);
        ArrayList<Paciente> pacientes = new ArrayList<>();
        pacientes.add(niño);
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria(pacientes);
        AdministradorDeNiños administrador = new AdministradorDeNiñosReferencia(repositorio);
        Niño respuestaEsperada = new Niño(niño.getId(), "", "");
        //Act
        Niño respuestaActual = administrador.obtener(niño.getId());
        //Assert
        assertEquals(respuestaEsperada.getId(), respuestaActual.getId());
    }

    @Test
    public void deberiaLanzarUnaExcepcionAlObtenerUnNiñoNoExistente() {
        //Arrange
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria();
        AdministradorDeNiños administrador = new AdministradorDeNiñosReferencia(repositorio);
        //Act
        //Assert
        assertThrows(NiñoNoExistenteException.class, () -> {
            administrador.obtener("");
        });
    }

    @Test
    public void deberiaPoderRegistrarUnNiño() {
        int respuestaEsperada = 1;
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria();
        Niño niño = new Niño("", "", "");
        AdministradorDeNiños administrador = new AdministradorDeNiñosReferencia(repositorio);
        //Act
        administrador.registrar(niño);
        //Assert
        assertEquals(respuestaEsperada, repositorio.listar().size());
    }
}
