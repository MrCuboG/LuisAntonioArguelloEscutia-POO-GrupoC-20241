package productos;

import java.time.LocalDate;
import java.util.Scanner;

public class Producto {
    private String nombre;
    private float precio;
    private int stock;
    public LocalDate fechaRegistro;
    private String numeroDeSerie;
    Scanner scanner = new Scanner(System.in);

    public Producto(String nombre, float precio, String numeroDeSerie) {
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegistro = LocalDate.now();
        this.numeroDeSerie = numeroDeSerie;
    }

    public void agregarStock(int stockExtra) {
        this.stock += stockExtra;
    }

    public void quitarStock(int stockMenos) {
        this.stock -= stockMenos;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public int getStock() {
        return stock;
    }

    public String datos(){
        return String.format("Nombre: %s, Precio: %f, Fecha De Registro: %s, Numero De Serie: %s, Stock: %d",
        nombre, precio, fechaRegistro, numeroDeSerie, stock);
    }

}
