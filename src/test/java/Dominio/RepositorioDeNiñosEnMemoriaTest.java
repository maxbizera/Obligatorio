package Dominio;

import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RepositorioDeNiñosEnMemoriaTest {

    @Test
    public void deberiaListarVacioSiNoPasoData() {
        //Arrange
        RepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria();
        //Act
        ArrayList<Niño> resultadoActual = repositorio.listar();
        //Assert
        assertEquals(resultadoActual.size(), 0);
    }

    @Test
    public void deberiaPoderListarSiPasoData() {
        //Arrange
        ArrayList<Niño> resultadoEsperado = new ArrayList<>();
        RepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria(resultadoEsperado);
        //Act
        ArrayList<Niño> resultadoActual = repositorio.listar();
        //Assert
        assertEquals(resultadoActual.size(), resultadoEsperado.size());
    }

    @Test
    public void deberiaPoderObtenerUnNiñoEspecificoSiSeEncuentraEnElRepositorio() throws NiñoNoEncontradoException {
        //Arrange
        Niño resultadoEsperado = new Niño();
        ArrayList<Niño> data = new ArrayList<>();
        data.add(resultadoEsperado);
        RepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria(data);
        //Act
        Niño resultadoActual = repositorio.obtener(resultadoEsperado.getId());
        //Assert
        assertEquals(resultadoEsperado.getId(), resultadoActual.getId());
    }

    @Test
    public void deberiaRetornarUnaExcepcionAlObtenerUnNiñoEspecificoSiNoSeEncuentraEnElRepositorio() throws NiñoNoEncontradoException {
        //Arrange
        RepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria();
        //Act
        //Asserts
        assertThrows(NiñoNoEncontradoException.class, () -> {
            repositorio.obtener(UUID.randomUUID().toString());
        });
    }
}
