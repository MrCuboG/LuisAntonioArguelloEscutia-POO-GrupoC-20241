package Usuarios;
import java.time.LocalDate;
import utils.Rol;

public class Cliente extends Usuario {

    private LocalDate fechaRegistro;
    
    public Cliente (String nombre, String apellido, String telefono) {
        super(nombre, apellido, telefono, Rol.CLIENTE);
        this.fechaRegistro = LocalDate.now();
    }
    
    @Override
    public String toString() {
        return String.format("%s, Fecha de registro: %s", super.toString(), this.fechaRegistro);
    }
}
