package Usuarios;
import utils.Rol;

public class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private String nombre, apellido, telefono;
    private int id;
    private Rol rol;

    public Usuario(String nombre, String apellido, String telefono, Rol rol) {
        this.id = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
        CANTIDAD_USUARIOS++;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getId() {
        return id;
    }

    public Rol getRol() {
        return rol;
    }

    public String toString() { //esto es un ejemplo para ver que se pueden sobreescribir en metodos
        return String.format("ID: %d, Nombre completo: %s %s, Teléfono: %s, rol: %s", 
        id, nombre, apellido, telefono, rol);
    }

    /*public String mostrarInfo() {
        return String.format("ID: %d, Nombre completo: %s %s, Teléfono: %s, rol: %s", 
        id, nombre, apellido, telefono, rol);
    }*/

}
