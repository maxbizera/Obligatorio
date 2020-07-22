package Logica;

import Dominio.RepositorioDePacientesEnMemoria;
import Dominio.Paciente;
import Dominio.RepositorioDePacientes;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
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
        Paciente niño1 = new Paciente();
        ArrayList<Paciente> lista = new ArrayList<>();
        lista.add((niño1));
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria(lista);
        AdministradorDeNiños administrador = new AdministradorDeNiñosReferencia(repositorio);
        ArrayList<ResumenNiño> respuestaEsperada = new ArrayList<>();
        ResumenNiño niñoEsperado = new ResumenNiño();
        respuestaEsperada.add(niñoEsperado);
        //Act
        ArrayList<ResumenNiño> respuestaActual = administrador.listar();
        //Assert
        assertEquals(respuestaEsperada.size(), respuestaActual.size());
    }

}
