import Sucursales.Sucursal;
import Sucursales.Utils.LasSucursales;
import Users.Empleados.Gerente;
//import Sucursales.SucursalMadero;
import Users.Cliente;
import Users.Usuario;
import Users.utils.constantes.Rol;

import java.time.LocalDate;
import java.util.Scanner;

public class Sistema {
    Menus menus = new Menus();
    Sucursal sucursales = new Sucursal(null, null);
    Gerente gerente1 = new Gerente("a", "a", null, null, null, null, "a", "123", Rol.GERENTE, 123, null);
    Gerente gerente2 = new Gerente("a", "a", null, null, null, null, "q", "123", Rol.GERENTE, 123, null);
    public void iniciarSistema(){

        menus.inicioSesion();
    }
    public void verificarInicioSesion(){
    }
}
