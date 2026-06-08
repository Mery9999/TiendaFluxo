/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestores;

import java.util.ArrayList;
import modelos.Cliente;


public class GestorCliente {
    
    private ArrayList<Cliente> clientes;
    
    public ArrayList<Cliente> getClientes() {
    return clientes;
    }

    public GestorCliente() {
        clientes = new ArrayList<>();
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarCliente(int id) {

        for (Cliente c : clientes) {

            if (c.getIdcliente() == id) {
                return c;
            }
        }

        return null;
    }

    public void listarClientes() {

        for (Cliente c : clientes) {

            System.out.println(
                c.mostrarDatos()
            );
        }
    }
        public int cantidadClientes() {
        return clientes.size();
    }
}
