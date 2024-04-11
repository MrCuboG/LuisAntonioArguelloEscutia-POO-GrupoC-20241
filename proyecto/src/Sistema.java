import java.util.*;
import productos.Electrodomestico;
import productos.Producto;
import productos.TipoProducto;
public class Sistema {
    List <Object> productos = new ArrayList<>();
    public void iniciarPrograma() {
        Producto producto;
        boolean bandera1 = true;
        while (bandera1) {
            System.out.println("*********BIENVENIDO*********\n");
            System.out.println("1. Comprar");
            System.out.println("2. Agregar Productos");
            System.out.println("3. Agregar Cliente");
            System.out.println("4. Eliminar Datos");
            System.out.println("5. Mostrar Datos");
            System.out.println("6. Salir");
            System.out.println("Seleccione la accion a realizar:");
            Scanner scanner = new Scanner(System.in);
            int elec = scanner.nextInt();
            if (elec == 1 || elec == 2 || elec == 5) {
                boolean bandera = true;
                    while (bandera) {
                        System.out.println("1. Electrodomesticos");
                        System.out.println("2. Limpieza");
                        System.out.println("3. Belleza");
                        System.out.println("4. Alimentos");
                        System.out.println("Que tipo de producto gustaria agregar: ");
                        int elec2= scanner.nextInt();
                        if (elec == 2) {
                            productos.add(registrarProducto(elec2));
                            bandera = false;
                        }else if (elec == 5) {
                            for (int i = 0; i < productos.size(); i++){
                                
                            }
                        }else{
                            System.out.println("**LA OPCION SELECCIONADA NO EXISTE**");
                        }
                    }
            }
        }
    }

    public Object registrarProducto(int elec) {
        Scanner scanner1 = new Scanner(System.in);
        boolean band = true;
        Object objeto = new Object();
        System.out.println(
                    "Inserte el Nombre del Producto: ");
            String nom = scanner1.nextLine();
            System.out.println(
                    "Inserte el Precio del Producto: ");
            float pre = Float.parseFloat(scanner1.nextLine());
            System.out.println(
                    "Inserte el numero de serie del Producto: ");
            String num = scanner1.nextLine();
            switch (elec) {
                case 1:
                System.out.println("Inserte el tipo de electrodomestico: ");
                String tipElec = scanner1.nextLine();
                    objeto = (new Electrodomestico(nom, pre, num, tipElec, elec));
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("La opcion seleccionada no existe");
                    break;
            }
        return objeto;
    }
}
