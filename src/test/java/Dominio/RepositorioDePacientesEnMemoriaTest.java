package Dominio;

import java.time.Instant;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RepositorioDePacientesEnMemoriaTest {

    @Test
    public void deberiaListarVacioSiNoPasoData() {
        //Arrange
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria();
        //Act
        ArrayList<Paciente> resultadoActual = repositorio.listar();
        //Assert
        assertEquals(resultadoActual.size(), 0);
    }

    @Test
    public void deberiaPoderListarSiPasoData() {
        //Arrange
        ArrayList<Paciente> resultadoEsperado = new ArrayList<>();
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria(resultadoEsperado);
        //Act
        ArrayList<Paciente> resultadoActual = repositorio.listar();
        //Assert
        assertEquals(resultadoActual.size(), resultadoEsperado.size());
    }

    @Test
    public void deberiaPoderObtenerUnPacienteEspecificoSiSeEncuentraEnElRepositorio() throws PacienteNoEncontradoException {
        //Arrange
        Paciente resultadoEsperado = new Paciente("", "", Instant.now(), "", "", false);
        ArrayList<Paciente> data = new ArrayList<>();
        data.add(resultadoEsperado);
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria(data);
        //Act
        Paciente resultadoActual = repositorio.obtener(resultadoEsperado.getDocumento());
        //Assert
        assertEquals(resultadoEsperado.getDocumento(), resultadoActual.getDocumento());
    }

    @Test
    public void deberiaRetornarUnaExcepcionAlObtenerUnPacienteEspecificoSiNoSeEncuentraEnElRepositorio() throws PacienteNoEncontradoException {
        //Arrange
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria();
        //Act
        //Asserts
        assertThrows(PacienteNoEncontradoException.class, () -> {
            repositorio.obtener(UUID.randomUUID().toString());
        });
    }

    @Test
    public void deberiaPoderAgregarUnPacienteAlRepositorio() {
        //Arrange
        int resultadoEsperado = 1;
        Paciente paciente = new Paciente("", "", Instant.now(), "", "", false);
        ArrayList<Paciente> pacientes = new ArrayList<>();
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria(pacientes);
        //Act
        repositorio.agregar(paciente);
        //Assert
        assertEquals(resultadoEsperado, repositorio.listar().size());
    }
}
