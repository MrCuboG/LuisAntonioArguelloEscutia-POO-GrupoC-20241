public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Rectangulo");
        Rectangulo rectangulo = new Rectangulo();
        System.out.println(rectangulo.area(10, 23));
        System.out.println(rectangulo.area(10.10, 23.10));
        System.err.println(rectangulo.perimetro(10, 23));
        System.out.println(rectangulo.perimetro(10.10, 23.10));

        System.out.println("///////////////////////////////////////////////////////////////////");

        System.out.println("Empleado");
        Empleado empleado = new Empleado();
        System.out.println(empleado.calcularSalario(10000));
        System.out.println(empleado.calcularSalario(10000, 500));
        System.out.println(empleado.calcularSalario(10000, 500, 2));

        System.out.println("///////////////////////////////////////////////////////////////////");

        System.out.println("Calculadora");
        CalculadoraImpuestos calculadoraImpuestos = new CalculadoraImpuestos();
        System.out.println(calculadoraImpuestos.calcularImpuestos(12000));
        System.out.println(calculadoraImpuestos.calcularImpuestos(12000, 20));
        System.out.println(calculadoraImpuestos.calcularImpuestos(16, 1200, 8));
        System.out.println(calculadoraImpuestos.calcularImpuestos(16, 12, 23));
    }
}
