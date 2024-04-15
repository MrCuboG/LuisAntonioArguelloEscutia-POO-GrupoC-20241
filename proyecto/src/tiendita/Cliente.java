package tiendita;

public class Cliente 
{
    private int id;
    private String nombre;
    private String direccion;
    private boolean comprable = false;

    public Cliente(int id, String nombre, String direccion)
    {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.comprable = false;
    }
    public void setComprable(boolean comprable) {
        this.comprable = comprable;
    }

    public boolean isComprable() {
        return comprable;
    }

    
   
    public int getId() {
        return id;
    }
    
    public String obtenerInformacion()
    {
        return String.format("\nId: %d \nNombre: %s \nDirección: %s", id,nombre,direccion);
    } 
}
