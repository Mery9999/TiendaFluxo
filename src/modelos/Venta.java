/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;
import java.util.Date;


public class Venta {
 
    private int idVenta;
    private Date fecha;

    private Cliente cliente;
    private Atc vendedor;

    private ArrayList<DetalleVenta> detalles;

    private double total;

    public Venta(int idVenta,
                 Cliente cliente,Atc vendedor) {

        this.idVenta = idVenta;
        this.cliente = cliente;
        this.vendedor = vendedor;

        fecha = new Date();

        detalles = new ArrayList<>();
    }
      public void agregarDetalle(
            DetalleVenta detalle) {

        detalles.add(detalle);

        calcularTotal();
    }

    public void calcularTotal() {

        total = 0;

        for (DetalleVenta d : detalles) {

            total += d.getSubtotal();
        }
    }

    public double getTotal() {
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public ArrayList<DetalleVenta> getDetalles() {
        return detalles;
    }

    @Override
    public String toString() {

        return "Venta N° " + idVenta +
               " Cliente: " +
               cliente.mostrarDatos() +
               " Total: S/." + total;
    }
    public int getIdVenta() {
    return idVenta;
    }
    


}
