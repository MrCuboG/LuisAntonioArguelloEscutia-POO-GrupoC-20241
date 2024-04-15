package tiendita;

public class Alimento extends Producto
{
    private String fCaducidad;
    
    public Alimento( String nombre, double precio, String fechaImportacion, int stock, String fCaducidad)
    {
        super(nombre, precio,fechaImportacion, stock);
        this.fCaducidad = fCaducidad;
    }
    public String obtenerInformacionConCaducidad()
    {
        return super.obtenerInformacion() + "fecha de caducidad: " + fCaducidad;
    }
}
