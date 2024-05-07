package Libreria.libros;

import Libreria.libros.utils.constants.ClasifLibro;
import Libreria.libros.utils.constants.Genero;

public class libroAccion extends Libro{
    private ClasifLibro clasifLibro;
    public libroAccion(String titulo, String autor, String idioma, double precio, int stock, ClasifLibro clasifLibro) {
        super(titulo, autor, Genero.TERROR, idioma, precio, stock);
        this.clasifLibro = clasifLibro;
    }
}
