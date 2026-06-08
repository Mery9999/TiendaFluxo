/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestores;

import java.util.ArrayList;
import modelos.Venta;


public class GestorVentas {
        private ArrayList<Venta> ventas;

    public GestorVentas() {

        ventas = new ArrayList<>();
    }

    public void registrarVenta(
            Venta venta) {

        ventas.add(venta);
    }

    public Venta buscarVenta(int id) {

        for (Venta v : ventas) {

            if (v.getIdVenta() == id) {

                return v;
            }
        }

        return null;
    }
     public double calcularIngresos() {

        double total = 0;

        for (Venta v : ventas) {

            total += v.getTotal();
        }

        return total;
    }

    public void listarVentas() {

        for (Venta v : ventas) {

            System.out.println(v);
        }
    }

    public int cantidadVentas() {

        return ventas.size();
    }
}
