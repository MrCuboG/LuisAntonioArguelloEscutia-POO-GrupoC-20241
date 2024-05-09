package examen.u3;

public class Sucursal {
    protected String nombreSucursal;
    protected String direccionSucursal;
    protected GerenteSucursal gerenteSucursal= null;;

    public Sucursal(String nombreSucursal, String direccionSucursal, GerenteSucursal gerenteSucursal) {
        this.nombreSucursal = nombreSucursal;
        this.direccionSucursal = direccionSucursal;
        this.gerenteSucursal = gerenteSucursal;
    }
    public Sucursal(String nombreSucursal, String direccionSucursal) {
        this.nombreSucursal = nombreSucursal;
        this.direccionSucursal = direccionSucursal;
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
}
