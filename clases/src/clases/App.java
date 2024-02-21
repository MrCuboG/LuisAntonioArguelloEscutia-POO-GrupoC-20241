package clases;

public class App {
    public static void main(String[] args) throws Exception {
        //personas
        Persona persona1 = new Persona("Lizeth", 18, "mujer");
        Persona persona2 = new Persona("Eduardo", 18, "hombre");
        Persona persona3 = new Persona("Alfredo", 20, "hombre");
        Persona persona4 = new Persona("Mariana", 17, "mujer");
        persona1.mostrar();
        persona2.mostrar();
        persona3.mostrar();
        persona4.mostrar();

        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////");
        //libros
        Libro libro1 = new Libro();
        libro1.mostrar();
        Libro libro2 = new Libro();
        libro2.autor="Jeff Kiney";
        libro2.titulo="Diary of a Wimpy Kid";
        libro2.añoPublicacion= 2007;
        libro2.mostrar();
        Libro libro3 = new Libro();
        libro3.autor="Ana Frank";
        libro3.titulo="Diario de Ana Frank";
        libro3.añoPublicacion= 1947;
        libro3.mostrar();
        Libro libro4 = new Libro();
        libro4.autor="H.P. Lovecraft";
        libro4.titulo="La llamada de Cthulhu";
        libro4.añoPublicacion= 1928;
        libro4.mostrar();

        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////");
        //Rectangulos
        Rectangulos rectangulo1 = new Rectangulos(10, 20);
        System.out.println("Rectangulo 1 ; Perimetro: "+rectangulo1.Perimetro() + ", Area: " + rectangulo1.Area());
        Rectangulos rectangulo2 = new Rectangulos(43.544, 46.234);
        System.out.println("Rectangulo 2 ; Perimetro: "+rectangulo2.Perimetro() + ", Area: " + rectangulo2.Area());
        Rectangulos rectangulo3 = new Rectangulos(345, 4.54);
        System.out.println("Rectangulo 3 ; Perimetro: "+rectangulo3.Perimetro() + ", Area: " + rectangulo3.Area());
        Rectangulos rectangulo4 = new Rectangulos(35.34, 454.234);
        System.out.println("Rectangulo 4 ; Perimetro: "+rectangulo4.Perimetro() + ", Area: " + rectangulo4.Area());
    }
}
