
package examen.u3;

import java.time.LocalDate;

public class  SucursalMadero extends Sucursal {    
    private static int contadorIdEmpleado = 1;
    int idGerente = 1;
    
    GerenteSucursal gerenteMadero = new GerenteSucursal(idGerente,"Diana", "Campos", LocalDate. of(1980, 10, 15),"PEJH801015HMNXXX",
                "PEJH801015MCMNXXX","Calle Morelos #456", this, 50000.00,"Gerente",LocalDate.of(2020, 01, 01));
    
    
    public SucursalMadero(String nombreSucursal, String direccionSucursal) {      
        super( "Madero","Av. Madero #123");
    }
   
    public SucursalMadero(String nombreSucursal, String direccionSucursal,GerenteSucursal gerenteSucursal) {      
        super( "Madero","Av. Madero #123", gerenteSucursal);
        this.gerenteMadero = gerenteSucursal;
    }
    
    
     @Override
    public String toString() {
        String gerenteInfo = "";
        if (gerenteSucursal != null) {
            gerenteInfo = "Gerente: " + gerenteSucursal.getNombre() + " " + gerenteSucursal.getApellidos();
        } else {
            gerenteInfo = "La sucursal no tiene un gerente asignado.";
        }
        return "Sucursal{" +
                ", nombreSucursal='" + nombreSucursal + '\'' +
                ", direccionSucursal='" + direccionSucursal + '\'' +
                ", " + gerenteInfo +
                '}';
    }
}
