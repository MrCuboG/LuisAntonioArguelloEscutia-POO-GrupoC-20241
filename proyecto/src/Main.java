import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Gerente;

public class Main {
    public static void main(String[] args) {
       // System.out.println(Rol.ASISTENTE);

       Cliente cliente = new Cliente("Luis", "Arguello", "5553123109");
       System.out.println(cliente.toString());

       Asistente asistente = new Asistente("Geovanny", "Dos Santos", "5558734593", 6700.46, "GDS555");
       System.out.println(asistente.toString());

       Gerente gerente = new Gerente("Alberto", "Aguilar", "56546875456", 100, "AA0565", "JKDFHG83408");
        System.out.println(gerente.toString());
    }
    
}
