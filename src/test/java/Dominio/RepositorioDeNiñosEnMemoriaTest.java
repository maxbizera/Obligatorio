package Dominio;

import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RepositorioDeNiñosEnMemoriaTest {

    @Test
    public void deberiaListarVacioSiNoPasoData() {
        //Arrange
        IRepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria();
        //Act
        ArrayList<Niño> resultadoActual = repositorio.listar();
        //Assert
        assertEquals(resultadoActual.size(), 0);
    }

    @Test
    public void deberiaPoderListarSiPasoData() {
        //Arrange
        ArrayList<Niño> resultadoEsperado = new ArrayList<>();
        IRepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria(resultadoEsperado);
        //Act
        ArrayList<Niño> resultadoActual = repositorio.listar();
        //Assert
        assertEquals(resultadoActual.size(), resultadoEsperado.size());
    }

    @Test
    public void deberiaPoderObtenerUnNiñoEspecificoSiSeEncuentraEnElRepositorio() {
        //Arrange
        Niño resultadoEsperado = new Niño();
        ArrayList<Niño> data = new ArrayList<>();
        data.add(resultadoEsperado);
        IRepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria(data);
        //Act
        Niño resultadoActual = repositorio.obtener(resultadoEsperado.getId());
        //Assert
        assertEquals(resultadoEsperado.getId(), resultadoActual.getId());
    }

    @Test
    public void deberiaRetornarNuloAlObtenerUnNiñoEspecificoSiNoSeEncuentraEnElRepositorio() {
        //Arrange
        Niño resultadoEsperado = null;

        IRepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria();
        //Act
        Niño resultadoActual = repositorio.obtener(UUID.randomUUID().toString());
        //Assert
        assertEquals(resultadoEsperado, resultadoActual);
    }

}
