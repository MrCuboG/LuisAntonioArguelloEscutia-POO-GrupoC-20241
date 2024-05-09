package Users;

import Users.utils.constants.Rol;

public class Usuario {
    private String nombre, apellido, ciudad, estado, direccion, nacimiento, rfc, curp;
    private String user, password;
    Rol rol;

    public Usuario(String nombre, String apellido, String ciudad, String estado, String direccion, String nacimiento, String rfc, String curp, String user, String password, Rol rol){
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
}
