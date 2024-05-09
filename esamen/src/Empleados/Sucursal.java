package Empleados;
import java.time.LocalDate;
import Users.utils.constants.Rol;

public class Sucursal {
    private String nombreSucursal;
    private String direccionSucursal;
    private GerenteSucursal gerenteSucursal;

    public Sucursal(String nombreSucursal, String direccionSucursal, GerenteSucursal gerenteSucursal) {
        this.nombreSucursal = nombreSucursal;
        this.direccionSucursal = direccionSucursal;
        this.gerenteSucursal = gerenteSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getDireccionSucursal() {
        return direccionSucursal;
    }

    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
    }

    public GerenteSucursal getGerenteSucursal() {
        return gerenteSucursal;
    }

    public void setGerenteSucursal(GerenteSucursal gerenteSucursal) {
        this.gerenteSucursal = gerenteSucursal;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                ", nombreSucursal='" + nombreSucursal + '\'' +
                ", direccionSucursal='" + direccionSucursal + '\'' +
                ", gerenteSucursal=" + gerenteSucursal +
                '}';
    }

    GerenteSucursal gerenteMadero = new GerenteSucursal(getGerenteSucursal().getIdEmpleado(),
            "Diana", "Campos", LocalDate.of(1980, 10, 15), "PEJH801015HMNXXX", "PEJH801015MCMNXXX",
            "Calle Morelos #456", null, 50000.00, Rol.GERENTE_SUCURSAL,
            LocalDate.of(2020, 01, 01));

    SucursalMadero sucursalMadero = new SucursalMadero("Madero", "Av. Madero #123", gerenteMadero);

}
