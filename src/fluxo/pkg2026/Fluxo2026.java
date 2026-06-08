/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fluxo.pkg2026;


import gestores.GestorCliente;
import gestores.GestorInventario;
import gestores.GestorVentas;
import java.util.Scanner;
import modelos.Atc;
import modelos.Boleta;
import modelos.Cliente;
import modelos.ClienteNatural;
import modelos.Clientejuridico;
import modelos.DetalleVenta;
import modelos.Factura;
import modelos.Producto;
import modelos.Venta;


public class Fluxo2026 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GestorCliente gestorCliente = new GestorCliente();
        GestorInventario gestorInventario = new GestorInventario();
        GestorVentas gestorVentas = new GestorVentas();
        Scanner sc = new Scanner(System.in);

int opcion;

do {

    System.out.println("\n===== FLUXO =====");
    System.out.println("1. Registrar Cliente");
    System.out.println("2. Registrar Producto");
    System.out.println("3. Registrar Venta");
    System.out.println("4. Listar Clientes");
    System.out.println("5. Listar Productos");
    System.out.println("6. Listar Ventas");
    System.out.println("7. Ver Ingresos Totales");
    System.out.println("0. Salir");

    opcion = sc.nextInt();
    sc.nextLine();

    switch(opcion){

        case 1:
            System.out.println("1. Cliente Natural");
            System.out.println("2. Cliente Juridico");

            int tipo = sc.nextInt();
            sc.nextLine();

            System.out.print("ID: ");
            int idcliente = sc.nextInt();
            sc.nextLine();

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Telefono: ");
            String telefono = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            if(tipo == 1){

                System.out.print("DNI: ");
                String dni = sc.nextLine();

                ClienteNatural cn =
                    new ClienteNatural(
                        idcliente,
                        nombre,
                        telefono,
                        email,
                        dni
                    );

                gestorCliente.registrarCliente(cn);

            }else{

                System.out.print("RUC: ");
                String ruc = sc.nextLine();

                System.out.print("Razon Social: ");
                String razon = sc.nextLine();

                Clientejuridico cj =new Clientejuridico(idcliente,nombre,telefono,email,ruc,razon
                    );

                gestorCliente.registrarCliente(cj);
            }
            break;

        case 2:
            System.out.print("ID: ");
                int idProducto = sc.nextInt();
                sc.nextLine();

                System.out.print("Codigo: ");
                String codigo = sc.nextLine();

                System.out.print("Marca: ");
                String marca = sc.nextLine();

                System.out.print("Modelo: ");
                String modelo = sc.nextLine();

                System.out.print("Color: ");
                String color = sc.nextLine();

                System.out.print("Categoria: ");
                String categoria = sc.nextLine();

                System.out.print("Precio: ");
                double precio = sc.nextDouble();

                System.out.print("Stock: ");
                int stock = sc.nextInt();

                Producto p =
                    new Producto(
                        idProducto,
                        codigo,
                        marca,
                        modelo,
                        color,
                        categoria,
                        precio,
                        stock
                    );

                gestorInventario.registrarProducto(p);
            break;

        case 3:
              if(gestorCliente.getClientes().isEmpty()){
                    System.out.println("No hay clientes registrados.");
                    break;
                }

                if(gestorInventario.getProductos().isEmpty()){
                    System.out.println("No hay productos registrados.");
                    break;
                }

                System.out.println("\n=== CLIENTES ===");

                for(Cliente c : gestorCliente.getClientes()){
                    System.out.println(
                            c.getIdcliente() + " - " +
                            c.mostrarDatos()
                    );
                }

                System.out.print("Ingrese ID Cliente: ");
                int idCliente = sc.nextInt();

                Cliente clienteVenta =
                        gestorCliente.buscarCliente(idCliente);

                if(clienteVenta == null){
                    System.out.println("Cliente no encontrado.");
                    break;
                }

                Atc vendedor =
                        new Atc(
                                1,
                                "vendedor1",
                                "1234"
                        );

                Venta venta =
                        new Venta(
                                gestorVentas.cantidadVentas()+1,
                                clienteVenta,
                                vendedor
                        );

                String continuar= "";

                do{

                    System.out.println("\n=== PRODUCTOS ===");

                    for(Producto pi :gestorInventario.getProductos()){

                        System.out.println(pi.getCodigo());
                    }

                    System.out.print(
                            "Ingrese codigo producto: "
                    );

                    String codigoProducto = sc.next();

                    Producto productoVenta = gestorInventario.buscarProducto(codigoProducto);

                    if(productoVenta == null){

                        System.out.println(
                                "Producto no encontrado"
                        );

                        continue;
                    }

                    System.out.print(
                            "Cantidad: "
                    );

                    int cantidad =
                            sc.nextInt();

                    DetalleVenta detalle =
                            new DetalleVenta(
                                    productoVenta,
                                    cantidad
                            );

                    venta.agregarDetalle(detalle);

                    System.out.print(
                            "Agregar otro producto? (S/N): "
                    );

                    continuar ="N";

                }while(continuar.equalsIgnoreCase("S"));

                gestorVentas.registrarVenta(venta);

                System.out.println(
                        "\nVenta registrada correctamente."
                );

                System.out.println(
                        "Total: S/. " +
                        venta.getTotal()
                );

                System.out.println(
                        "\nTipo comprobante:"
                );

                System.out.println(
                        "1. Boleta"
                );

                System.out.println(
                        "2. Factura"
                );

                int tipoComp =
                        sc.nextInt();

                if(tipoComp == 1){

                    Boleta boleta =
                            new Boleta(
                                    "B001-" +
                                    venta.getIdVenta(),
                                    venta
                            );

                    System.out.println(
                            boleta.imprimir()
                    );

                }else{

                    Factura factura =
                            new Factura(
                                    "F001-" +
                                    venta.getIdVenta(),
                                    venta
                            );

                    System.out.println(
                            factura.imprimir()
                    );
                }

        break;

        case 4:
            gestorCliente.listarClientes();
            break;

        case 5:
            gestorInventario.listarProductos();
            break;

        case 6:
            gestorVentas.listarVentas();
            break;

        case 7:
            System.out.println(
                "Ingresos: S/. "
                + gestorVentas.calcularIngresos()
            );
            break;

    }
    

}   
while(opcion != 0);
    }
}
    
    

