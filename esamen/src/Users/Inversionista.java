package Users;

import Users.utils.constants.Rol;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Inversionista extends Usuario {
    double saldo;

    LocalDate localDate;

    Inversionista(String nombre, String apellido, String ciudad,
                  String estado, String direccion, String nacimiento,
                  String rfc, String curp, String user, String password,
                  double saldo){
        super(nombre, apellido, ciudad, estado, direccion, nacimiento, rfc, curp, user, password, Rol.INVERSIONISTA);
        this.saldo = saldo;
    }

    public void proveerFondos(/**Sucursal, cantidad**/){
        // a sucursal.banco
        // se agregan fondos al banco
        // se registra el fondo en el sistema (se guarda la fecha del momento)
        // se quitan los fondos a el inversionista,
        localDate = LocalDate.now();
        String fecha = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}
