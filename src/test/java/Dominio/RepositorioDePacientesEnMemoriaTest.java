package Dominio;

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
        Paciente resultadoEsperado = new Paciente();
        ArrayList<Paciente> data = new ArrayList<>();
        data.add(resultadoEsperado);
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria(data);
        //Act
        Paciente resultadoActual = repositorio.obtener(resultadoEsperado.getId());
        //Assert
        assertEquals(resultadoEsperado.getId(), resultadoActual.getId());
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
}
