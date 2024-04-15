package tiendita;

import java.util.Scanner;

public class Sistema {

    Scanner leer = new Scanner(System.in);
    private final String CLAVE = "bruh";
    private Tienda objetoTienda = new Tienda();

    //Métodos
    public void ejecutarPrograma() {
        boolean claveValida = false;
        do {

            System.out.print("\nIngresa la contraseña para acceder al sistema: ");
            String clave = leer.nextLine();

            if (validarClave(clave)) {

//                Mostrar Menú
                claveValida = true;
                mostrarMenuSistema();

            } else {
                System.out.println("Clave inválida, intenta de nuevo");
            }
        } while (!claveValida);

    }

    private boolean validarClave(String clave) {
        return clave.equals(CLAVE);
    }

    private void mostrarMenuSistema() 
    {
        int opcion = 0;
        do {
            System.out.println("\n\t***BIENVENIDO A LA TIENDA***");
            System.out.println("\nMenú de opciones");
            System.out.println("1) Agregar cliente");
            System.out.println("2) Agregar producto");
            System.out.println("3) Agregar stock");
            System.out.println("4) Eliminar stock");
            System.out.println("5) Consultar clientes");
            System.out.println("6) Consultar todos los productos");
            System.out.println("7) Consultar productos por categoría");
            System.out.println("8) Realizar compra");
            System.out.println("9) Consultar Compras");
            System.out.println("10) Consultar total de productos y clientes");
            System.out.println("11) Eliminar clientes");
            System.out.println("12) Eliminar productos");
            System.out.println("13) Salir");

            System.out.print("\nElige una opción: ");
            opcion = leer.nextInt();

            switch (opcion) 
            {
                case 1:
                    objetoTienda.registrarCliente();
                    break;
                    
                case 2:
                    System.out.println("\nProductos disponibles");
                    System.out.println("\n1. Limpieza");
                    System.out.println("2. Electrodomestico");
                    System.out.println("3. Alimento");
                    System.out.println("4. Maquillaje");
                    System.out.print("\nIngresa el tipo de producto que deseas registrar: ");
                    
                    int opcionProducto = leer.nextInt();
                    
                    switch(opcionProducto)
                    {
                        case 1:
                            objetoTienda.registroLimpieza();
                            break;
                            
                        case 2:
                            objetoTienda.registroElectrodomestico();
                            break;
                            
                        case 3:
                            objetoTienda.registroAlimento();
                            break;
                            
                        case 4:
                            objetoTienda.registroMaquillaje();
                            break;
                            
                        default: System.out.println("\nOpción no válida");
                    }
                    break;
                    
                case 3:
                    objetoTienda.agregarStock();
                    break;
                    
                case 4:
                    objetoTienda.eliminarStock();
                    break;
                    
                case 5:
                    objetoTienda.listarClientes();
                    break;
                    
                case 6:
                    objetoTienda.consultarProductosTotales();
                    break;
                    
                case 7:
                    System.out.println("\n***Productos disponibles***");
                    System.out.println("\n1. Limpieza");
                    System.out.println("2. Electrodomestico");
                    System.out.println("3. Alimento");
                    System.out.println("4. Maquillaje");
                    System.out.print("\nIngresa el tipo de producto que deseas consultar: ");
                    
                    int opcionProducto2 = leer.nextInt();
                    
                    switch(opcionProducto2)
                    {
                        case 1:
                            objetoTienda.listarLimpieza();
                            break;
                            
                        case 2:
                            objetoTienda.listarElectrodomestico();
                            break;
                            
                        case 3:
                            objetoTienda.listarAlimento();
                            break;
                            
                        case 4:
                            objetoTienda.listarMaquillaje();
                            break;
                            
                        default: System.out.println("\nOpción no válida");
                    }
                    break;
                    
                case 8:
                    objetoTienda.realizarCompra();
                    break;
                    
                case 9:
                    objetoTienda.consultarCompra();
                    break;
                    
                case 10:
                    objetoTienda.consultarProductosYClientes();
                    break;
                    
                case 11:
                    objetoTienda.eliminarCliente();
                    
                    break;
                    
                case 12:
                    objetoTienda.eliminarProducto();
                    break;
                    
                case 13:
                    System.out.println("\nSalir");
                    break;
            }
        } while (opcion != 13);

    }
}
