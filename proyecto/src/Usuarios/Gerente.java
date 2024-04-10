package Usuarios;

import utils.Rol;

public class Gerente extends Usuario{
    private double sueldo;
    private String rfc, ine;
    
    public Gerente(String nombre, String apellido, String telefono, double sueldo, String rfc, String ine) {
        super(nombre, apellido, telefono, Rol.GERENTE);
        this.sueldo = sueldo;
        this.ine = ine;
        this.rfc = rfc;
    }

    @Override
    public String toString() {
        return String.format("%s, Sueldo: %f, RFC: %s, INE: %s",
         super.toString(), this.sueldo, this.rfc, this.ine);
    }

}
