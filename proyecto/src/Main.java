import java.util.*;
public class Main {
    public static void main(String[] args) {
        boolean bandera = true;
        double elec, elec1;
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Que figura desea calcular el area o perimetro?");
            System.out.println("1.Rectangulo\n2.Cuadrado\n3.Triangulo\n4.Trapecio\n5.Salir");
            elec = scanner.nextDouble();
            if ((int)elec == 5) {
                break;
            }
            System.out.println("Desea hacer el area o el perimetro?");
            System.out.println("1.Area\n2.Perimetro");
            elec1 = scanner.nextDouble();
            switch ((int) elec) {
                case 1:
                    System.out.println("inserte la base y la altura");
                    double a = scanner.nextDouble(), b = scanner.nextDouble();
                    Rectangulo rectangulo = new Rectangulo(a, b);
                    if (elec1 == 1) {
                        System.out.println(rectangulo.calcularArea());
                    } else {
                        System.out.println(rectangulo.calcularPerimetro());
                    }
                    break;
                case 2:
                    System.out.println("inserte el lado");
                    double c = scanner.nextDouble();
                    Cuadrado cuadrado = new Cuadrado(c);
                    if (elec1 == 1) {
                        System.out.println(cuadrado.calcularArea());
                    } else {
                        System.out.println(cuadrado.calcularPerimetro());
                    }
                    break;
                case 3:
                    System.out.println("inserte la base, la altura, el lado1, el lado 2 y el lado 3");
                    double d = scanner.nextDouble(), e = scanner.nextDouble(), f = scanner.nextDouble(), g = scanner.nextDouble(), h = scanner.nextDouble();
                    Triangulo triangulo = new Triangulo(d, e, f, g, h);
                    if (elec1 == 1) {
                        System.out.println(triangulo.calcularArea());
                    } else {
                        System.out.println(triangulo.calcularPerimetro());
                    }
                    break;
                case 4:
                    System.out.println("inserte la base Mayor, la base Menor, la altura y el lado Inclinado");
                    double i = scanner.nextDouble(), j = scanner.nextDouble(), k = scanner.nextDouble(), l = scanner.nextDouble();
                    Trapecio trapecio = new Trapecio(i, j, k, l);
                    if (elec1 == 1) {
                        System.out.println(trapecio.calcularArea());
                    } else {
                        System.out.println(trapecio.calcularPerimetro());
                    }
                    break;
                default:
                    break;

            }


        }
    }
}