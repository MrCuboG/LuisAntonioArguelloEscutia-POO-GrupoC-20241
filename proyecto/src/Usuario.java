import java.util.*;
public class Usuario {
    private String nombre;
    ArrayList <Libro> librosRentados = new ArrayList<>();
    ArrayList <Libro> librosComprados = new ArrayList<>();
    
    Usuario(String nombre){
        this.nombre = nombre;
    }

    public void rentarLibro(Libro libro){
        librosRentados.add(libro);
    }
    public void devolverLibro(Libro libro){
        librosRentados.remove(libro);
    }
    public void comprarLibro(Libro libro){
        librosComprados.add(libro);
    }

    public String getNombre() {
        return nombre;
    }
    public ArrayList<Libro> getLibrosRentados() {
        return librosRentados;
    }
    public ArrayList<Libro> getLibrosComprados() {
        return librosComprados;
    }
}
