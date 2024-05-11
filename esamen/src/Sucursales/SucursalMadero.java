package Sucursales;

import Sucursales.Utils.LasSucursales;
import Users.Empleados.Gerente;
import Users.utils.constantes.Rol;

public class SucursalMadero extends Sucursal{

    public SucursalMadero(String direccionSucursal, Gerente gerente) {
        super(direccionSucursal);
        this.gerente = gerente;
    }


}
