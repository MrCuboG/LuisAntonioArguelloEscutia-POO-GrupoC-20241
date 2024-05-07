package Libreria.libros;

import Libreria.libros.utils.constants.Genero;

public class libroComedia extends Libro {

    public libroComedia(String titulo, String autor, String idioma, double precio, int stock) {
        super(titulo, autor, Genero.COMEDIA, idioma, precio, stock);
    }
    
}
