package clases;

public class Rectangulos {
    double ancho=1, altura=1;

    Rectangulos(double ancho, double altura){
        this.ancho=ancho;
        this.altura=altura;
    }
    double Perimetro(){
        return (ancho*2)+(altura*2);
    }
    double Area(){
        return ancho*altura;
    }
}
