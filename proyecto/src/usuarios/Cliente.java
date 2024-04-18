package usuarios;
import usuarios.utils.Rol;
import java.time.LocalDate;

public class Cliente extends Usuario {
    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido, String telefono, String nombreUsuario, String contraseña) {
        super(nombre, apellido, telefono, Rol.CLIENTE, nombreUsuario, contraseña);
        this.fechaRegistro = LocalDate.now();
    }
    public String toString() {
        return String.format("%s, Fecha registro: %s", super.toString(), fechaRegistro);
    }
}