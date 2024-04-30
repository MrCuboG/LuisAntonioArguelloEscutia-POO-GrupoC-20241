package Usuarios;
import Usuarios.utils.Rol;

public class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private String nombre, apellido, telefono;
    private int id;
    private Rol rol;
    private String nombreUsuario;
    private String contrasena;

    public Usuario(String nombre, String apellido, String telefono, Rol rol, String nombreUsuario, String contrasena) {
        this.id = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setCANTIDAD_USUARIOS() {
        CANTIDAD_USUARIOS--;
    }

    public void setId() {
        this.id = id - 1;
    }

    public String toString() { //esto es un ejemplo para ver que se pueden sobreescribir en metodos
        return String.format("ID: %d, Nombre completo: %s %s, Teléfono: %s, rol: %s, Nombre de usuario: %s", 
        id, nombre, apellido, telefono, rol, nombreUsuario);
    }

    public static int getCANTIDAD_USUARIOS() {
        return CANTIDAD_USUARIOS - 1;
    }



}
