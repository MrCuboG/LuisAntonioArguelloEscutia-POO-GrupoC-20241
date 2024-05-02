import Libreria.Menu;
import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Usuario;
import Usuarios.Gerente;
import Usuarios.utils.Rol;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.iniciarSesion();
    }
}
