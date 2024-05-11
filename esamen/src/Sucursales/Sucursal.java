package Sucursales;

import Sucursales.Utils.LasSucursales;
import Users.Empleados.Gerente;
import Users.Usuario;
import Users.utils.constantes.Rol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sucursal {
    protected String direccionSucursal;
    Gerente gerente;
    public static final HashMap<LasSucursales, HashMap<Rol, ArrayList<Usuario>>> usuarioPorSucursalYRol
            = new HashMap<LasSucursales, HashMap<Rol, ArrayList<Usuario>>>();


    public Sucursal(String direccionSucursal, Gerente gerente) {
        this.direccionSucursal = direccionSucursal;
        this.gerente = gerente;
    }

    public static Usuario obtenerUsuarioPorNombreYContrasena(String nombreUsuario, String contrasena) {
        for (HashMap<Rol, ArrayList<Usuario>> usuarioPorRol : usuarioPorSucursalYRol.values()) {

            for (ArrayList<Usuario> usuarios : usuarioPorRol.values()) {

                for (Usuario usuario : usuarios) {
                    if (usuario.getUser().equals(nombreUsuario) && usuario.getPassword().equals(contrasena)) {
                        return usuario;
                    }
                }
            }
        }
        return null;
    }

    public HashMap<LasSucursales, HashMap<Rol, ArrayList<Usuario>>> getHashMap() {
        return this.usuarioPorSucursalYRol;
    }
    public HashMap<Rol, ArrayList<Usuario>> getHashMapDelHashMap(LasSucursales sucursal) {
        return this.usuarioPorSucursalYRol.get(sucursal);
    }
    public ArrayList<Usuario> getArrayList(LasSucursales sucursal, Rol rol) {
        return this.usuarioPorSucursalYRol.get(sucursal).get(rol);
    }
    public void addGerente(Gerente gerente) {
        this.gerente = gerente;
    }


}

//    @Override
//    public String toString() {
//        return "Sucursal{" +
//                ", nombreSucursal='" + nombreSucursal + '\'' +
//                ", direccionSucursal='" + direccionSucursal + '\'' +
//                ", gerenteSucursal=" + gerenteSucursal +
//                '}';
//    }