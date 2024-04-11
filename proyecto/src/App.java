import productos.Producto;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        String contrasena = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserte la contraseña: ");
        while (!contrasena.equals("123")) {
            contrasena = scanner.nextLine();
            if (!contrasena.equals("123")){
                System.out.println("Contraseña incorrecta");
            }
        }
        Sistema sistema = new Sistema();
        sistema.iniciarPrograma();
        scanner.close();
        
    }
}
