/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Edison
 */
public class Restaurante {
    private Integer id;
    private String nombreCl;
    private String nombreP;
    private Double precioP;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getNombreCl() {
        return nombreCl;
    }

    public void setNombreCl(String nombreCl) {
        this.nombreCl = nombreCl;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public Double getPrecioP() {
        return precioP;
    }

    public void setPrecioP(Double precioP) {
        this.precioP = precioP;
    }

    @Override
    public String toString() {
        return  nombreCl +" "+ "pidio "+ " " + nombreP +" "+ "con un costo de " + precioP ;
    }
    
    
}
