package Sucursales;

import Users.Empleados.Gerente;
import Users.Usuario;
import Users.utils.constantes.Rol;
import java.util.ArrayList;
import java.util.HashMap;

public class Sucursal {
    protected String nombreSucursal;
    protected String direccionSucursal;
    protected Gerente gerenteSucursal= null;

    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
    private static Usuario usuarioEnSesion;

    public Sucursal(String nombreSucursal, String direccionSucursal, Gerente gerenteSucursal) {
        this.nombreSucursal = nombreSucursal;
        this.direccionSucursal = direccionSucursal;
        this.gerenteSucursal = gerenteSucursal;
    }
    public Sucursal(String nombreSucursal, String direccionSucursal) {
        this.nombreSucursal = nombreSucursal;
        this.direccionSucursal = direccionSucursal;
    }

    public static Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getUser().equals(nombreUsuario) && usuario.getPassword().equals(contrasena)) {
                    usuarioEnSesion = usuario;
                    return usuario;
                }
            }
        }
        return null;
    }

//    public String getNombreSucursal() {
//        return nombreSucursal;
//    }
//
//    public void setNombreSucursal(String nombreSucursal) {
//        this.nombreSucursal = nombreSucursal;
//    }
//
//    public String getDireccionSucursal() {
//        return direccionSucursal;
//    }
//
//    public void setDireccionSucursal(String direccionSucursal) {
//        this.direccionSucursal = direccionSucursal;
//    }
//
//    public Gerente getGerenteSucursal() {
//        return gerenteSucursal;
//    }
//
//    public void setGerenteSucursal(Gerente gerenteSucursal) {
//        this.gerenteSucursal = gerenteSucursal;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Sucursal{" +
//                ", nombreSucursal='" + nombreSucursal + '\'' +
//                ", direccionSucursal='" + direccionSucursal + '\'' +
//                ", gerenteSucursal=" + gerenteSucursal +
//                '}';
//    }
}
