/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import controller.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Restaurante;

/**
 *
 * @author Edison
 */
public class ModeloTablaRestaurante extends AbstractTableModel{
    private ListaEnlazada<Restaurante> datos = new ListaEnlazada<>();

    public ListaEnlazada<Restaurante> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Restaurante> datos) {
        this.datos = datos;
    }
    
    
@Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int i) {
        
        switch(i) {
            case 0: return "Nombre Cliente";   
            case 1: return "Nombre Plato";
            case 2: return "Precios";
 
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Restaurante s = null;
        try {
            s = datos.get(i);
        } catch (Exception e) {
        }
        switch(i1) {
            
            case 0: return (s != null)? s.getNombreCl():"NO DEFINIDO";
            case 1: return (s != null)? s.getNombreP():"NO DEFINIDO";
            case 2: return (s != null)? s.getPrecioP():"0.0";
           
            default: return null;
        }
    }
    
}
