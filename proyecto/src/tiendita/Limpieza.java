package tiendita;

public class Limpieza extends Producto
{
    private String marca;
    public Limpieza( String nombre, double precio, String fechaImportacion, int stock, String marca){
        super( nombre, precio, fechaImportacion, stock);
        this.marca = marca;
    }
    
    public Limpieza() {
        super("", 0.0, "", 0); 
        this.marca = ""; 
 
    }

    
    public String obtenerInformacionConMarca(){
        return super.obtenerInformacion() + "\nMarca: " + marca;
    }
}
