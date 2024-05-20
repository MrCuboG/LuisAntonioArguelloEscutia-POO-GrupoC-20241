package Usuarios;

import Usuarios.utils.Rol;

public abstract class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private String nombre, apellido, telefono; //Cliente, asistente y gerente
    private int id;
    private Rol rol; //es de tipo rol ya que solo aceptamos 3 roles, esto para evitar que se ingrese un rol no existente
    private String nombreUsuario;
    private String contraseña;
    private String fechaNacimiento;

    public Usuario(String nombre, String apellido, String telefono, Rol rol, String nombreUsuario, String contraseña, String fechaNacimiento) {
        this.id = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getContraseña() {
        return contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getFechaNacimiento() {return fechaNacimiento;}

    public String toString() { //esto es un ejemplo para ver que se pueden sobreescribir en metodos
        return String.format("ID: %d, Nombre completo: %s %s, Teléfono: %s, rol: %s, Username: %s, Fecha de Nacimiento: %s",
                id, nombre, apellido, telefono, rol, nombreUsuario, fechaNacimiento);
    }

}
