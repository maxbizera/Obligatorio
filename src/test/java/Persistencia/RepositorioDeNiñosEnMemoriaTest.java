/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gcarrillo
 */
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

}
