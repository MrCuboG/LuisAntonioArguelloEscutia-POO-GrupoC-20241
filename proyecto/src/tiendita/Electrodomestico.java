package tiendita;

public class Electrodomestico extends Producto
{
    private double voltaje;
    public Electrodomestico(String nombre, double precio, String fechaImportacion, int stock, double voltaje)
    {
        super( nombre, precio,fechaImportacion, stock);
        this.voltaje = voltaje;
    }

    
    public String obtenerInformacionConVoltaje()
    {
        return super.obtenerInformacion() + "\nVoltaje: " + voltaje;
    }
}
