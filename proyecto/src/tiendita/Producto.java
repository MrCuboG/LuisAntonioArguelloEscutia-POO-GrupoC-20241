package tiendita;

public class Producto 
{
    public boolean estaEnCompra = false;
    public static int CANTIDAD_PRODUCTOS = 0;
    private String nombre;
    private double precio;
    private String fechaDeImportacion;
    private int numeroDeSerie;
    private int stock;
    
    
    //Constructor
    public Producto( String nombre, double precio, String fechaDeImportacion, int stock) 
    {
        this.nombre = nombre;
        this.precio = precio;
        this.fechaDeImportacion = fechaDeImportacion;
        this.stock = stock;
        this.numeroDeSerie = CANTIDAD_PRODUCTOS += 1;
        CANTIDAD_PRODUCTOS = CANTIDAD_PRODUCTOS ++;
        this.estaEnCompra = false;
    }

    public int getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isEstaEnCompra() {
        return estaEnCompra;
    }

    public void setEstaEnCompra(boolean estaEnCompra) {
        this.estaEnCompra = estaEnCompra;
    }

    public void agregarStock(int cantidad)
    {
       this.stock  += cantidad;
    }
    
    public void eliminarStock(int cantidad)
    {
        if(validarStock())
        {
            System.out.println("\nNo es posible eliminar del stock, ya que el producto no tiene articulos");
        }
        else
        {
            this.stock  -= cantidad;
            System.out.println("\nStock disminuido con éxito");
        }
       
    }
    private boolean validarStock(){
        return stock == 0 ? true : false;
    }
    
    public String obtenerInformacion(){
        return String.format("\nNombre: %s \nPrecio: %.4f \nFecha de importación: %s \nStock: %d \nNúmero de serie: %d", nombre, precio, fechaDeImportacion, stock, numeroDeSerie);
    }
    
    
    
}
