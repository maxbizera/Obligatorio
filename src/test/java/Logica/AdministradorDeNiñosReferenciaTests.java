package Logica;

import Dominio.RepositorioDeNiñosEnMemoria;
import Dominio.Niño;
import Dominio.RepositorioDeNiños;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class AdministradorDeNiñosReferenciaTests {

    @Test
    public void deberiaTraerUnListadoVacioSiNoHayNiñosEnElSistema() {
        //Arrange
        RepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria();
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
        Niño niño1 = new Niño();
        ArrayList<Niño> lista = new ArrayList<>();
        lista.add((niño1));
        RepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria(lista);
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
