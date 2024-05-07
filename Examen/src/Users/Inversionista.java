package Users;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Inversionista extends Usuario {

    double saldo;
    String fecha;
    LocalDate localDate;

    Inversionista(String name, String user, String password, Rol rol){
        super(name, user, password, rol.INVERSIONISTA);
    }

    public void proveerFondos(/**Sucursal, cantidad**/){
        // a sucursal.banco
        // se agregan fondos al banco
        // se registra el fondo en el sistema (se guarda la fecha del momento)
        // se quitan los fondos a el inversionista,
        localDate = LocalDate.now();
        fecha = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}
