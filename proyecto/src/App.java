import productos.Electrodomestico;
import java.time.LocalDate;
public class App {
    public static void main(String[] args) throws Exception {
        Electrodomestico electrodomestico = new Electrodomestico("Refri", 1232, null, "sdfsfd");
        electrodomestico.agregarStock(23); 
    }
}
