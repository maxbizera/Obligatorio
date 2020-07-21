/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.ArrayList;

/**
 *
 * @author gcarrillo
 */
public interface IRepositorioDeNiños {

    public ArrayList<Niño> listar();

    public Niño obtener(String id);
    
}
