import java.util.*;
public class Libreria {
    private ArrayList <Libro> libros = new ArrayList<>();
    private ArrayList <Libro> librosNoRentados = new ArrayList<>();
    private ArrayList <Libro> librosRentados = new ArrayList<>();
    private ArrayList <Usuario> usuarios = new ArrayList<>();

    public void registrarLibro(String titulo, String autor){
        librosNoRentados.add(new Libro(titulo, autor));
        libros.add(new Libro(titulo, autor));
    }
    public void registrarUsuario(String nombre){
        usuarios.add(new Usuario(nombre));
    }



    public void rentarLibro(Usuario usuario, Libro libro){
        usuario.rentarLibro(libro);
        librosRentados.add(libro);
        librosNoRentados.remove(libro);
    }
    public void devolverLibro(Usuario usuario, Libro libro){
        libros.add(libro);
        usuario.devolverLibro(libro);
        usuarios.remove(usuario);
    }



    public void comprarLibro(Usuario usuario, Libro libro){
        usuario.comprarLibro(libro);
        librosNoRentados.remove(libro);
    }



    public void mostrarLibros(){
        for (int i = 0; i < libros.size(); i++) {
            System.out.println(libros.get(i));
        }
    }
    public void mostrarUsuarios(){
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i));
        }
    }



    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public ArrayList<Libro> getLibros() {
        return libros;
    }
    public ArrayList<Libro> getLibrosNoRentados() {
        return librosNoRentados;
    }
    public ArrayList<Libro> getLibrosRentados() {
        return librosRentados;
    }
}
