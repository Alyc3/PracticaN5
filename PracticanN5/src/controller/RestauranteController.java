/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.ed.lista.ListaEnlazada;
import java.util.Locale;
import java.util.Random;
import modelo.Restaurante;

/**
 *
 * @author Edison
 */
public class RestauranteController {
    ListaEnlazada<Restaurante> res = new ListaEnlazada<>();
    Restaurante restaurante;

    public RestauranteController() {
       
    }

    public ListaEnlazada<Restaurante> getRes() {
        if (res == null) {
            res = new ListaEnlazada<>();
        }
        return res;
    }

    public void setRes(ListaEnlazada<Restaurante> res) {
        this.res = res;
    }
    

  
    
}
