package Sucursales;

import Users.Empleados.Gerente;

public class SucursalMadero extends Sucursal{

    public SucursalMadero(String nombreSucursal, String direccionSucursal, Gerente gerenteMadero) {
        super(nombreSucursal, direccionSucursal, gerenteMadero);
    }

    /*GerenteSucursal gerenteMadero = new GerenteSucursal(getGerenteSucursal().getIdEmpleado(),
            "Diana", "Campos", LocalDate. of(1980, 10, 15),"PEJH801015HMNXXX", "PEJH801015MCMNXXX",
            "Calle Morelos #456", null, 50000.00, Rol.GERENTE_SUCURSAL,
            LocalDate.of(2020, 01, 01));*/

}
