package tiendita;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tienda {

    private Random random = new Random();
    private Scanner leer = new Scanner(System.in);
    private ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
    private ArrayList<Maquillaje> Maquillajes = new ArrayList<Maquillaje>();
    private ArrayList<Limpieza> Limpiezas = new ArrayList<Limpieza>();
    private ArrayList<Alimento> Alimentos = new ArrayList<Alimento>();
    private ArrayList<Electrodomestico> Electrodomesticos = new ArrayList<Electrodomestico>();
    private ArrayList<Producto> todosProductos = new ArrayList<Producto>();
    private ArrayList<Compra> Compras = new ArrayList<Compra>();

    // Clientes
    public void registrarCliente() {
        int id = validarId();
        System.out.println("\nTu id se genera automáticamente");
        System.out.print("Ingresa el nombre: ");
        String nombre = leer.nextLine();
        System.out.print("Ingresa la dirección del cliente: ");
        String direccion = leer.nextLine();

        Cliente objetoCliente = new Cliente(id, nombre, direccion);
        Clientes.add(objetoCliente);
        System.out.println("\n**Cliente registrado con id generado " + objetoCliente.getId() + "**");

    }

    public int validarId() {
        boolean valido = true;
        int id = random.nextInt(1000) + 1;

        do {
            for (Cliente cliente : Clientes) {
                if (id == cliente.getId()) {
                    valido = false;
                    id = random.nextInt(1000) + 1;
                }
            }
        } while (!valido);

        return id;
    }

    public ArrayList<String> registrarDatosComun() {
        ArrayList<String> datos = new ArrayList<String>();

        System.out.print("Ingrese el nombre: ");
        String nombre = leer.nextLine();
        datos.add(nombre);

        System.out.print("Ingrese el precio: ");
        double precio = leer.nextDouble();
        datos.add(String.valueOf(precio));

        leer.nextLine();
        System.out.print("Ingrese la fecha de importación(dd-mm-aaaa): ");
        String fecha = leer.nextLine();
        datos.add(fecha);

        System.out.print("Ingrese el stock del producto(dd-mm-aaaa): ");
        int stock = leer.nextInt();
        datos.add(String.valueOf(stock));

        return datos;

    }
//********************LIMPIEZA********************
    public void registroLimpieza() {
        ArrayList<String> datosUsuario = registrarDatosComun();

        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));

        String fecha = datosUsuario.get(2);

        int stock = Integer.parseInt(datosUsuario.get(3));

        leer.nextLine();

        System.out.print("Ingrese la marca: ");
        String marca = leer.nextLine();

        Limpieza objeto = new Limpieza(nombre, precio, fecha, stock, marca);
        Limpiezas.add(objeto);
        todosProductos.add(objeto);
        System.out.println("\n***PRODUCTO REGISTRADO***");
    }
//********************ELECTRODOMESTICO********************
    public void registroElectrodomestico() {
        ArrayList<String> datosUsuario = registrarDatosComun();

        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));

        String fecha = datosUsuario.get(2);

        int stock = Integer.parseInt(datosUsuario.get(3));

        leer.nextLine();

        System.out.print("Ingresa el voltaje: ");
        double voltaje = leer.nextDouble();

        Electrodomestico objeto = new Electrodomestico(nombre, precio, fecha, stock, voltaje);
        Electrodomesticos.add(objeto);
        todosProductos.add(objeto);
        System.out.println("\n***PRODUCTO REGISTRADO***");
    }
//********************ALIMENTOS********************
    public void registroAlimento() {
        ArrayList<String> datosUsuario = registrarDatosComun();

        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));

        String fecha = datosUsuario.get(2);

        int stock = Integer.parseInt(datosUsuario.get(3));

        leer.nextLine();

        System.out.print("Ingresa la fecha de caducidad: ");
        String caducidad = leer.nextLine();

        Alimento objeto = new Alimento(nombre, precio, fecha, stock, caducidad);
        Alimentos.add(objeto);
        todosProductos.add(objeto);
        System.out.println("\n***PRODUCTO REGISTRADO***");
    }
//********************MAQUILLAJE********************
    public void registroMaquillaje() {
        System.out.println("\nElegiste registrar un producto de la categoría maquillaje");

        ArrayList<String> datosUsuario = registrarDatosComun();

        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));

        String fecha = datosUsuario.get(2);

        int stock = Integer.parseInt(datosUsuario.get(3));

        leer.nextLine();

        System.out.print("Ingresa el color: ");
        String color = leer.nextLine();

        Maquillaje objeto = new Maquillaje(nombre, precio, fecha, stock, color);
        Maquillajes.add(objeto);
        todosProductos.add(objeto);
        System.out.println("\n***PRODUCTO REGISTRADO***");
    }

    //**************************************Listas*****************************************************
    //Consulta de clientes
    public void listarClientes() {
        System.out.println("\n***CLIENTES***");
        if (Clientes.isEmpty()) {
            System.out.println("\n**No hay clientes registrados**");
        }
        for (Cliente cliente : Clientes) {
            System.out.println(cliente.obtenerInformacion());
        }
    }

    public void listarLimpieza() {
        System.out.println("\n***PRODUCTOS LIMPIEZA***");

        if (Limpiezas.isEmpty()) {
            System.out.println("\n**No hay productos registrados");
        } else {
            for (Limpieza producto : Limpiezas) {
                System.out.println(producto.obtenerInformacionConMarca());
            }
        }

    }

    public void listarElectrodomestico() {
        System.out.println("\n***PRODUCTOS ELECTRODOMESTICOS***");
        if (Electrodomesticos.isEmpty()) {
            System.out.println("\n**No hay productos registrados**");
        } else {
            for (Electrodomestico producto : Electrodomesticos) {
                System.out.println(producto.obtenerInformacionConVoltaje());
            }
        }

    }

    public void listarAlimento() {
        System.out.println("\n***PRODUCTOS ALIMENTO***");
        if (Alimentos.isEmpty()) {
            System.out.println("\n**No hay productos registrados**");
        } else {
            for (Alimento producto : Alimentos) {
                System.out.println(producto.obtenerInformacionConCaducidad());
            }
        }

    }

    public void listarMaquillaje() {
        System.out.println("\n***PRODUCTOS MAQUILLAJE***");
        if (Maquillajes.isEmpty()) {
            System.out.println("\n**No hay productos registrados***");
        }
        for (Maquillaje producto : Maquillajes) {
            System.out.println(producto.obtenerInformacionConColor());
        }
    }

    public void consultarProductosTotales() {
        System.out.println("\n***PRODUCTOS TOTALES REGIISTRADOS***");

        for (Limpieza producto : Limpiezas) {
            System.out.println(producto.obtenerInformacionConMarca());
        }

        for (Electrodomestico producto : Electrodomesticos) {
            System.out.println(producto.obtenerInformacionConVoltaje());
        }

        for (Alimento producto : Alimentos) {
            System.out.println(producto.obtenerInformacionConCaducidad());
        }

        for (Maquillaje producto : Maquillajes) {
            System.out.println(producto.obtenerInformacionConColor());
        }
    }

//********************----------STOCK----------********************
    public void agregarStock() {
        System.out.println("\nAgregar stock de productos");

        System.out.println("\n***Productos disponibles***");
        System.out.println("\n1. Limpieza");
        System.out.println("2. Electrodomestico");
        System.out.println("3. Alimento");
        System.out.println("4. Maquillaje");

        System.out.print("\nIngresa el tipo al que deseas agregar stock: ");
        int opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("\nIngrese el número de serie del producto: ");
                int id = leer.nextInt();

                for (Limpieza producto : Limpiezas) {
                    if (producto.getNumeroDeSerie() == id) {
                        System.out.print("Ingresa la cantidad a agregar: ");
                        int cantidad = leer.nextInt();

                        producto.agregarStock(cantidad);
                        System.out.println("**Stock aumentada con éxito**");
                    } else {
                        System.out.println("\n**El número de serie no existe**");
                    }
                }

                break;

            case 2:

                System.out.print("\nIngrese el número de serie del producto: ");
                id = leer.nextInt();

                for (Electrodomestico producto : Electrodomesticos) {
                    if (producto.getNumeroDeSerie() == id) {
                        System.out.print("Ingresa la cantidad a agregar: ");
                        int cantidad = leer.nextInt();

                        producto.agregarStock(cantidad);
                        System.out.println("**Stock aumentada con éxito**");
                    } else {
                        System.out.println("\n**El número de serie no existe**");
                    }
                }

                break;

            case 3:
                System.out.print("\nIngrese el número de serie del producto: ");
                id = leer.nextInt();

                for (Alimento producto : Alimentos) {
                    if (producto.getNumeroDeSerie() == id) {
                        System.out.print("Ingresa la cantidad a agregar: ");
                        int cantidad = leer.nextInt();

                        producto.agregarStock(cantidad);
                        System.out.println("**Stock aumentada con éxito**");
                    } else {
                        System.out.println("\n**El número de serie no existe**");
                    }
                }

                break;

            case 4:
                System.out.print("\nIngrese el número de serie del producto: ");
                id = leer.nextInt();

                for (Maquillaje producto : Maquillajes) {
                    if (producto.getNumeroDeSerie() == id) {
                        System.out.print("Ingresa la cantidad a agregar: ");
                        int cantidad = leer.nextInt();

                        producto.agregarStock(cantidad);
                        System.out.println("**Stock aumentada con éxito**");
                    } else {
                        System.out.println("\n**El número de serie no existe**");
                    }
                }

                break;

            default:
                System.out.println("\nOpción no válida");
        }

    }

    public void eliminarStock() {
        System.out.println("\nEliminar stock de productos");

        System.out.println("\n***Productos disponibles***");
        System.out.println("\n1. Limpieza");
        System.out.println("2. Electrodomestico");
        System.out.println("3. Alimento");
        System.out.println("4. Maquillaje");

        System.out.print("\nIngresa el tipo al que deseas eliminar stock: ");
        int opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("\nIngrese el número de serie del producto: ");
                int id = leer.nextInt();

                for (Limpieza buscarLimpieza : Limpiezas) {
                    if (buscarLimpieza.getNumeroDeSerie() == id) {
                        System.out.print("Ingresa la cantidad a eliminar: ");
                        int cantidad = leer.nextInt();

                        buscarLimpieza.eliminarStock(cantidad);
                    } else {
                        System.out.println("\n**El número de serie no existe**");
                    }
                }

                break;

            case 2:

                System.out.print("\nIngrese el número de serie del producto: ");
                id = leer.nextInt();

                for (Electrodomestico buscarElectro : Electrodomesticos) {
                    if (buscarElectro.getNumeroDeSerie() == id) {
                        System.out.print("Ingresa la cantidad a eliminar: ");
                        int cantidad = leer.nextInt();

                        buscarElectro.eliminarStock(cantidad);
                    } else {
                        System.out.println("\n**El número de serie no existe**");
                    }
                }

                break;

            case 3:
                System.out.print("\nIngrese el número de serie del producto: ");
                id = leer.nextInt();

                for (Alimento buscarAlimento : Alimentos) {
                    if (buscarAlimento.getNumeroDeSerie() == id) {
                        System.out.print("Ingresa la cantidad a eliminar: ");
                        int cantidad = leer.nextInt();

                        buscarAlimento.eliminarStock(cantidad);
                    } else {
                        System.out.println("\n**El número de serie no existe**");
                    }
                }

                break;

            case 4:
                System.out.print("\nIngrese el número de serie del producto: ");
                id = leer.nextInt();

                for (Maquillaje buscarMaquillaje : Maquillajes) {
                    if (buscarMaquillaje.getNumeroDeSerie() == id) {
                        System.out.print("Ingresa la cantidad a eliminar: ");
                        int cantidad = leer.nextInt();

                        buscarMaquillaje.eliminarStock(cantidad);
                    } else {
                        System.out.println("\n**El número de serie no existe**");
                    }
                }

                break;

            default:
                System.out.println("\nOpción no válida");
        }

    }

    public void consultarProductosYClientes() {
        System.out.println("\n***TOTALES");
        System.out.println("\nCantidad de clientes registrados: " + Clientes.size());

        int totalProductos = Limpiezas.size() + Electrodomesticos.size() + Alimentos.size() + Maquillajes.size();
        System.out.println("El total de productos registradoS: " + totalProductos);
    }

    ///////////-------------------------COMPRAS--------------------///////////
    public void realizarCompra() {
        System.out.println("\n***Realizar compra***");

        System.out.print("\nIngrese el id de un cliente: ");
        int id = leer.nextInt();

        int bandera = 0;
        Cliente cliente = obtenerClientePorId(id);
        if (cliente != null) {
            do {
                System.out.println("\n***Productos disponibles***");
                System.out.println("\nLimpieza");
                System.out.println("Electrodomestico");
                System.out.println("Alimento");
                System.out.println("Maquillaje");

                System.out.print("\nIngrese el id del producto que desea comprar: ");
                int idProducto = leer.nextInt();

                if (esProducto(idProducto)) {
                    leer.nextLine();

                    System.out.print("\nEscriba la fecha de compra: ");
                    String fecha = leer.nextLine();
                    
                    Compra compra = new Compra(fecha);
                    
                    cliente.setComprable(true);
                    
                    Producto productoComprado = obtenerProductoPorId(idProducto);
                    compra.agregarProducto(productoComprado);
                    productoComprado.setEstaEnCompra(true);
                    
                    Compras.add(compra);

                    System.out.println("\n***Compra realizada con el id " + compra.getIdCompra());

                } else {
                    System.out.println("\nEl producto no existe");
                }

                System.out.println("\nDesea seguir comprando? \n1.Si \n2.No");
                System.out.print("\nSeleccione una opcion: ");
                bandera = leer.nextInt();
            } while (bandera != 2);

        } else {
            System.out.println("\nEl cliente no está registrado");
        }
    }

    public ArrayList<Compra> getCompras() {
        return Compras;
    }

    public Cliente obtenerClientePorId(int id) {
        for (Cliente cliente : Clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public boolean esProducto(int idProducto) {
        for (Producto producto : todosProductos) {
            if (producto.getNumeroDeSerie() == idProducto) {
                return true;
            }
        }
        return false;
    }

    public Producto obtenerProductoPorId(int idProducto) {
        for (Producto producto : todosProductos) {
            if (producto.getNumeroDeSerie() == idProducto) {
                return producto;
            }
        }
        return null;
    }

    //**************************************Consulta de compra***********************************************
    public void consultarCompra() {
        System.out.println("\n***Consulta de compras***");
        for (Compra compra : Compras) {
            compra.mostrarInfoCompras();
        }
    }

    //*******************************Eliminación**************************************************************
    public void eliminarCliente() {
        System.out.println("\n**Eliminación de cliente**");
        System.out.print("\nIngresa el id del cliente a eliminar: ");
        int id = leer.nextInt();

        Cliente cliente = obtenerClientePorId(id);
        if (cliente != null && !cliente.isComprable()) {
            Clientes.remove(cliente);
            System.out.println("\n**Cliente eliminado exitosamente***");
        } else {
            System.out.println("\nEl cliente no está registrado o está asociado a una compra");
        }
    }

    public void eliminarProducto() 
    {
        System.out.println("\n**Eliminación de producto**");
        System.out.print("\nIngresa el id del producto a eliminar: ");
        int id = leer.nextInt();

        Producto producto = obtenerProductoPorId(id);
        if (producto != null && !producto.isEstaEnCompra())
        {
            producto.setEstaEnCompra(false);
            todosProductos.remove(producto);
            Limpiezas.remove(producto);
            Electrodomesticos.remove(producto);
            Alimentos.remove(producto);
            Maquillajes.remove(producto);
            
            
            System.out.println("\n**Producto eliminado exitosamente***");
        } else {
            System.out.println("\nEl producto no está registrado o está asociado a una compra");
        }
        
    }
}
