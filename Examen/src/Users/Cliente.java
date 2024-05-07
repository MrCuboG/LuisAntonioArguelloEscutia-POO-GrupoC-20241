package Users;

public class Cliente {
    private String nombre;
    private String apellidos;
    private int añoNacimiento;
    private String ciudad;
    private String estado;
    private String rfc;
    private String curp;
    private String direccion;
    private String contraseña;
    private String sucursalRegistro;
    private String fechaRegistroStr;

    public Cliente(String nombre,String apellidos, int añoNacimiento, String curp, String ciudad, String estado,String contraseña, String direccion, String fechaRegistroStr,String sucursalRegistro) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.añoNacimiento = añoNacimiento;
        this.curp = curp;
        this.ciudad = ciudad;
        this.estado = estado;
        this.contraseña= contraseña;
        this.direccion = direccion;
        this.fechaRegistroStr = fechaRegistroStr;
        this.sucursalRegistro = sucursalRegistro;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFechaRegistroStr() {
        return fechaRegistroStr;
    }

    public void setFechaRegistroStr(String fechaRegistroStr) {
        this.fechaRegistroStr = fechaRegistroStr;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSucursalRegistro() {
        return sucursalRegistro;
    }

    public void setSucursalRegistro(String sucursalRegistro) {
        this.sucursalRegistro = sucursalRegistro;
    }

    public void generarRFC() {

    }
    public String toString() {
        return "Cliente{" +
                "apellidos='" + apellidos + '\'' +
                ", añoNacimiento=" + añoNacimiento +
                ", ciudad='" + ciudad + '\'' +
                ", estado='" + estado + '\'' +
                ", rfc='" + rfc + '\'' +
                ", curp='" + curp + '\'' +
                ", direccion='" + direccion + '\'' +
                ", sucursalRegistro='" + sucursalRegistro + '\'' +

                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
