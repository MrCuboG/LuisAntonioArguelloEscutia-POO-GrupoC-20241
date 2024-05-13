package Users;

import Users.utils.constantes.Rol;

public class Usuario {
    private String nombre, apellido, ciudad, estado, direccion, nacimiento, rfc, curp;
    private String user, password;
    Rol rol;

    public Usuario(String nombre, String apellido, String direccion, String nacimiento, String rfc, String curp, String user, String password, Rol rol){
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.estado = estado;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
        this.rfc = rfc;
        this.curp = curp;
        this.user = user;
        this.password = password;
        this.rol = rol;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
