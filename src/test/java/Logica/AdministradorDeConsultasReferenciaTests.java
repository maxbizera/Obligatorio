/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import org.junit.jupiter.api.Test;
import Persistencia.*;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gcarrillo
 */
public class AdministradorDeConsultasReferenciaTests {

    @Test
    public void deberiaRetornarElNumeroDeConsultasAntesDeUnaDeterminadaFecha() {
        //Arrange
        int respuestaEsperada = 1;
        Persistencia.Consulta consulta = new Persistencia.Consulta(new Date());
        ArrayList< Persistencia.Consulta> consultas
                = new ArrayList< Persistencia.Consulta>();
        consultas.add(consulta);
        Niño niño1 = new Niño(consultas);
        ArrayList<Niño> lista = new ArrayList<>();
        lista.add((niño1));
        IRepositorioDeNiños repositorio = new RepositorioDeNiñosEnMemoria(lista);
        Date fecha = new Date();
        IAdministradorDeConsultas administrador = new AdministradorDeConsultasReferencia(repositorio);
        //Act
        int respuestaActual = administrador.contarHastaFecha(fecha);
        //Assert
        assertEquals(respuestaEsperada, respuestaActual);
    }
}
