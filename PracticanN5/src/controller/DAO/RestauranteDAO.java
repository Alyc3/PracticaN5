/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DAO;

import controller.ed.lista.ListaEnlazada;
import controller.ed.lista.exception.PosicionException;
import controller.ed.lista.exception.VacioException;
import java.io.IOException;
import modelo.Restaurante;

/**
 *
 * @author Edison
 */
public class RestauranteDAO extends AdaptadorDAO<Restaurante> {

    private Restaurante restaurante;

    public RestauranteDAO() {
        super(Restaurante.class);
    }

    public Restaurante getRestaurante() {
        if (this.restaurante == null) {
            this.restaurante = new Restaurante();
        }
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public void guardar() throws IOException {
        restaurante.setId(generateID());
        this.guardar(restaurante);
    }

    public void modificar(Integer pos) throws VacioException, PosicionException, IOException {
        this.modificar(restaurante, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }

    public ListaEnlazada<Restaurante> busBinaria(ListaEnlazada<Restaurante> lista, String dato) {
        Restaurante[] arreglo = lista.toArray();
        int inicio = 0;
        int fin = arreglo.length - 1;
        int pos;

        while (inicio <= fin) {
            pos = (inicio + fin) / 2;
            if (arreglo[pos].getNombreCl().toLowerCase().equals(dato.toLowerCase())) {
                ListaEnlazada<Restaurante> res = new ListaEnlazada<>();

                res.insertar(arreglo[pos]);
                return res;
            }
            if (arreglo[pos].getNombreCl().compareToIgnoreCase(dato) < 0) {
                inicio = pos + 1;
            } else {
                fin = pos - 1;
            }
        }
        return lista;
    }

    public ListaEnlazada<Restaurante> buscarNombreCliente(String dato) {
        ListaEnlazada<Restaurante> lista = listar();
        quicksortAs(lista);

        return busBinaria(lista, dato);
    }

    public ListaEnlazada<Restaurante> busBinariaPl(ListaEnlazada<Restaurante> lista, String dato) {
        Restaurante[] arreglo = lista.toArray();
        int inicio = 0;
        int fin = arreglo.length - 1;
        int pos;

        while (inicio <= fin) {
            pos = (inicio + fin) / 2;
            if (arreglo[pos].getNombreP().toLowerCase().equals(dato.toLowerCase())) {
                ListaEnlazada<Restaurante> res = new ListaEnlazada<>();

                res.insertar(arreglo[pos]);
                return res;
            }
            if (arreglo[pos].getNombreP().compareToIgnoreCase(dato) < 0) {
                inicio = pos + 1;
            } else {
                fin = pos - 1;
            }
        }
        return lista;
    }

    public ListaEnlazada<Restaurante> buscarNombrePlatos(String dato) {
        ListaEnlazada<Restaurante> lista = listar();
        quicksortAsPlato(lista);
        System.out.println("JUMAAAA");
        return busBinariaPl(lista, dato);
    }

    public ListaEnlazada<Restaurante> busBinariaPre(ListaEnlazada<Restaurante> lista, Double dato) {
        Restaurante[] arreglo = lista.toArray();
        int inicio = 0;
        int fin = arreglo.length - 1;
        int pos;

        while (inicio <= fin) {
            pos = (inicio + fin) / 2;
            if (arreglo[pos].getPrecioP().equals(dato)) {
                ListaEnlazada<Restaurante> res = new ListaEnlazada<>();

                res.insertar(arreglo[pos]);
                return res;
            }
            if (arreglo[pos].getPrecioP().compareTo(dato) < 0) {
                inicio = pos + 1;
            } else {
                fin = pos - 1;
            }
        }
        return lista;
    }

    public ListaEnlazada<Restaurante> buscarNombrePrecio(Double dato) {
        ListaEnlazada<Restaurante> lista = listar();
        quicksortAsPrecio(lista);
        System.out.println("JUMAAAA");
        return busBinariaPre(lista, dato);
    }

    public static ListaEnlazada<Restaurante> busquedasecuencial(ListaEnlazada<Restaurante> lista, String dato) {
        Restaurante[] aux = lista.toArray();
        for (int i = 0; i < aux.length; i++) {
            if (aux[i].equals(dato)) {
                return lista;
            }
        }
        return lista;
    }

    public ListaEnlazada<Restaurante> quicksortAs(ListaEnlazada<Restaurante> lista) {
        if (lista == null || lista.size() == 0) {
            return lista;
        }
        Restaurante[] arreglo = lista.toArray();
        ordenarAs(arreglo, 0, arreglo.length - 1);
        return lista.toList(arreglo);
    }

    private static void ordenarAs(Restaurante[] lista, int bajo, int alto) {
        if (bajo < alto) {
            int particionIndex = particionAs(lista, bajo, alto);
            ordenarAs(lista, bajo, particionIndex - 1);
            ordenarAs(lista, particionIndex + 1, alto);
        }
    }

    private static int particionAs(Restaurante[] lista, int bajo, int alto) {
        Restaurante pivot = lista[alto];
        int i = bajo - 1;
        for (int j = bajo; j < alto; j++) {
            if (lista[j].getNombreCl().toLowerCase().compareToIgnoreCase(pivot.getNombreCl().toLowerCase()) < 0) {
                i++;
                swapAs(lista, i, j);
            }
        }
        swapAs(lista, i + 1, alto);
        return i + 1;
    }

    private static void swapAs(Restaurante[] lista, int i, int j) {
        Restaurante temp = lista[i];
        lista[i] = lista[j];
        lista[j] = temp;
    }

    public ListaEnlazada<Restaurante> quicksortAsPlato(ListaEnlazada<Restaurante> lista) {
        if (lista == null || lista.size() == 0) {
            return lista;
        }
        Restaurante[] arreglo = lista.toArray();
        ordenarAsPlato(arreglo, 0, arreglo.length - 1);
        return lista.toList(arreglo);
    }

    private static void ordenarAsPlato(Restaurante[] lista, int bajo, int alto) {
        if (bajo < alto) {
            int particionIndex = particionAsPlato(lista, bajo, alto);
            ordenarAsPlato(lista, bajo, particionIndex - 1);
            ordenarAsPlato(lista, particionIndex + 1, alto);
        }
    }

    private static int particionAsPlato(Restaurante[] lista, int bajo, int alto) {
        Restaurante pivot = lista[alto];
        int i = bajo - 1;
        for (int j = bajo; j < alto; j++) {
            if (lista[j].getNombreP().toLowerCase().compareToIgnoreCase(pivot.getNombreP().toLowerCase()) < 0) {
                i++;
                swapAs(lista, i, j);
            }
        }
        swapAs(lista, i + 1, alto);
        return i + 1;
    }

    public ListaEnlazada<Restaurante> quicksortAsPrecio(ListaEnlazada<Restaurante> lista) {
        if (lista == null || lista.size() == 0) {
            return lista;
        }
        Restaurante[] arreglo = lista.toArray();
        ordenarAsPrecio(arreglo, 0, arreglo.length - 1);
        return lista.toList(arreglo);
    }

    private static void ordenarAsPrecio(Restaurante[] lista, int bajo, int alto) {
        if (bajo < alto) {//si bajo es menor a alto
            int particionIndex = particionAsPrecio(lista, bajo, alto);
            //se ordena la sublista para los elementos menores
            ordenarAsPrecio(lista, bajo, particionIndex - 1);
            //se ordena la sublista para los elementos mayores
            ordenarAsPrecio(lista, particionIndex + 1, alto);
        }
    }

    private static int particionAsPrecio(Restaurante[] lista, int bajo, int alto) {
        // se selecciona un elemento pivote de la lista
        Restaurante pivot = lista[alto];
        int i = bajo - 1;
        for (int j = bajo; j < alto; j++) {
            //se empieza a ordenar de manera ascendente haciendo la comparacion
            if (lista[j].getPrecioP() < pivot.getPrecioP()) {
                //si el arreglo lista en la posicion j es menor a la poblacion del pivot
                i++;
                //se aumenta
                swapAs(lista, i, j);
            }
        }
        swapAs(lista, i + 1, alto);
        //se devuelve la posicion del pivote despues de la particion
        return i + 1;
    }

    public static ListaEnlazada<Restaurante> busquedaBinariaSecuencial(ListaEnlazada<Restaurante> lista, String dato) {
        ListaEnlazada<Restaurante> res = new ListaEnlazada<>();
        Restaurante[] arreglo = lista.toArray();
        int inicio = 0;
        int fin = arreglo.length - 1;

        while (inicio <= fin) {
            int pos = (inicio + fin) / 2;
            if (arreglo[pos].getNombreCl().toLowerCase().equals(dato.toLowerCase())) {
               
                
                break;
            }
            if (arreglo[pos].getNombreCl().compareToIgnoreCase(dato) < 0) {
                inicio = pos + 1;
            } else {
                fin = pos - 1;
            }
        }

        for (Restaurante restaurante : arreglo) {
            if (restaurante.getNombreCl().toLowerCase().equals(dato.toLowerCase())) {
               
                res.insertar(restaurante);
                
            }else if(restaurante.getNombreCl().toLowerCase().compareTo(dato.toLowerCase())>0) {
                break;
            }
        }

        return res.toList(arreglo);
    }
    
     public ListaEnlazada<Restaurante> buscarBBNombreCl(String dato) {
        ListaEnlazada<Restaurante> lista = listar();
        quicksortAs(lista);
        return busquedaBinariaSecuencial(lista, dato);
    }

}
