package tiendita;

import java.util.ArrayList;


public class Compra 
{
    private static int ID = 50;
    private String fecha;
    private int idCompra;
    private ArrayList<Producto> listaProductos;

    public Compra(String fecha) 
    {
        this.idCompra = ID++;
        this.fecha = fecha;
        this.listaProductos = new ArrayList<>();
    }

    public Compra() {
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void mostrarInfoCompras() 
    {
        System.out.println("\nID de compra: " + idCompra);
        System.out.println("Fecha de compra: " + fecha);
        System.out.println("Productos comprados:");
        double totalCompra = 0.0;
        for (Producto producto : listaProductos) 
        {
            System.out.println("Número de serie: " + producto.getNumeroDeSerie());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            totalCompra += producto.getPrecio();
        }
        System.out.println("\nTotal de la compra: " + totalCompra);
    }
    
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    
    
}
