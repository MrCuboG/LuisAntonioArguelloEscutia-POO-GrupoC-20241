package Users;

import Users.utils.UsuarioUtils;
import Users.utils.constantes.Rol;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;



public class Cliente extends Usuario {
    private final String fechaRegistroStr;

    //PORFA ALGUIEN AGREGUE EL ID PORQUE FALTA EN CLIENTE


    public Cliente(String nombre, String apellido, String domicilio, String nacimiento, String rfc, String curp, String user, String password, String fechaRegistroStr) {
        super(nombre, apellido, domicilio, nacimiento, rfc, curp, user, password, Rol.CLIENTE);
        this.fechaRegistroStr = fechaRegistroStr;
    }

    public void RegistarCliente() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> datos = UsuarioUtils.registarUsuarioComun();

        String nombre = datos.get(0);
        String apellido = datos.get(1);
        String domicilio = datos.get(2);
        String nacimiento = datos.get(3);
        String rfc = datos.get(4);
        String curp = datos.get(5);
        String user = datos.get(6);
        String password = datos.get(7);
        System.out.println("Fecha de registro");
        String fechaRegistro = sc.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, domicilio, nacimiento, rfc, curp, user, password, fechaRegistro);
    }

}

//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getContraseña() {
//        return contraseña;
//    }
//
//    public void setContraseña(String contraseña) {
//        this.contraseña = contraseña;
//    }
//
//    public String getFechaRegistroStr() {
//        return fechaRegistroStr;
//    }
//
//    public void setFechaRegistroStr(String fechaRegistroStr) {
//        this.fechaRegistroStr = fechaRegistroStr;
//    }
//
//    public String getApellidos() {
//        return apellidos;
//    }
//
//    public void setApellidos(String apellidos) {
//        this.apellidos = apellidos;
//    }
//
//    public int getAñoNacimiento() {
//        return añoNacimiento;
//    }
//
//    public void setAñoNacimiento(int añoNacimiento) {
//        this.añoNacimiento = añoNacimiento;
//    }
//
//    public String getCiudad() {
//        return ciudad;
//    }
//
//    public void setCiudad(String ciudad) {
//        this.ciudad = ciudad;
//    }
//
//    public String getEstado() {
//        return estado;
//    }
//
//    public void setEstado(String estado) {
//        this.estado = estado;
//    }
//
//    public String getRfc() {
//        return rfc;
//    }
//
//    public void setRfc(String rfc) {
//        this.rfc = rfc;
//    }
//
//    public String getCurp() {
//        return curp;
//    }
//
//    public void setCurp(String curp) {
//        this.curp = curp;
//    }
//
//    public String getDireccion() {
//        return direccion;
//    }
//
//    public void setDireccion(String direccion) {
//        this.direccion = direccion;
//    }
//
//    public String getSucursalRegistro() {
//        return sucursalRegistro;
//    }
//
//    public void setSucursalRegistro(String sucursalRegistro) {
//        this.sucursalRegistro = sucursalRegistro;
//    }
//
//    public void generarRFC() {
//
//    }
//    public String toString() {
//        return "Cliente{" +
//                "apellidos='" + apellidos + '\'' +
//                ", añoNacimiento=" + añoNacimiento +
//                ", ciudad='" + ciudad + '\'' +
//                ", estado='" + estado + '\'' +
//                ", rfc='" + rfc + '\'' +
//                ", curp='" + curp + '\'' +
//                ", direccion='" + direccion + '\'' +
//                ", sucursalRegistro='" + sucursalRegistro + '\'' +
//
//                ", contraseña='" + contraseña + '\'' +
//                '}';
//    }
//}
