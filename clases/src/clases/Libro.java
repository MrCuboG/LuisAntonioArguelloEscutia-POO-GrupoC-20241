package clases;

public class Libro {
    String titulo = "Don Quijote de la Mancha", autor="Miguel De Cervantes Saavedra";
    int añoPublicacion = 1605;
    void mostrar(){
        System.out.println(String.format("titulo: %s, autor: %s, año de Publicación: %d", titulo, autor, añoPublicacion));
    }
}
