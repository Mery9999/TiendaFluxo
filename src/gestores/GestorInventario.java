/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestores;

import java.util.ArrayList;
import modelos.Producto;


public class GestorInventario {
    
     private ArrayList<Producto> productos;

    public GestorInventario() {

        productos = new ArrayList<>();
    }

    public void registrarProducto(
            Producto producto) {

        productos.add(producto);
    }

    public Producto buscarProducto(
            String codigo) {

        for (Producto p : productos) {

            if (p.getCodigo()
                    .equalsIgnoreCase(codigo)) {

                return p;
            }
        }
    return null;
    }

    public void listarProductos() {

        for (Producto p : productos) {

            System.out.println(p);
        }
    }

    public int cantidadProductos() {

        return productos.size();
    }
    public ArrayList<Producto> getProductos() {
    return productos;
}
}
