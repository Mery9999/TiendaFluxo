/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;


public class Producto {
    private int idProducto;
    private String codigo;
    private String marca;
    private String modelo;
    private String color;
    private String categoria;
    private double precio;
    private int stock;

    public Producto(int idProducto,
                    String codigo,
                    String marca,
                    String modelo,
                    String color,
                    String categoria,
                    double precio,
                    int stock) {

        this.idProducto = idProducto;
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public void actualizarStock(int cantidad) {
        stock += cantidad;
    }

    @Override
    public String toString() {
        return codigo + " - " + marca +
               " " + modelo;
    }
    public String getCodigo() 
    {
    return codigo;
    }
    public double getPrecio() 
    {
    return precio;
    }
}
