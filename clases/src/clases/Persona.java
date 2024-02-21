package clases;

public class Persona {
    String nombre;
    int edad;
    String genero;
    Persona(String nombre, int edad, String genero){
        this.nombre=nombre;
        this.edad=edad;
        this.genero=genero;
    }
    void mostrar(){
        System.out.println(String.format("Nombre: %s, Edad: %d, Su genero es: %s", nombre, edad, genero));
    }
}
