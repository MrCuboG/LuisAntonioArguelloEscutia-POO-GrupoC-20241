package Usuarios;
import Usuarios.utils.Rol;

public class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private String nombre, apellido, telefono; //Cliente, asistente y gerente
    private int id;
    private Rol rol; //es de tipo rol ya que solo aceptamos 3 roles, esto para evitar que se ingrese un rol no existente
    private String nombreUsuario;
    private String contrasena;
    private String fechaDeNacimiento;

    public Usuario(String nombre, String apellido, String telefono, String fechaDeNacimiento, Rol rol, String nombreUsuario, String contrasena) {
        this.id = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fechaDeNacimiento = fechaDeNacimiento;
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

    public String toString() {
        return String.format("ID: %d, Nombre completo: %s %s, Teléfono: %s, Fecha De Nacimiento: %s, rol: %s, Nombre de usuario: %s",
        id, nombre, apellido, telefono, rol, nombreUsuario);
    }

    public static int getCANTIDAD_USUARIOS() {
        return CANTIDAD_USUARIOS - 1;
    }



}
