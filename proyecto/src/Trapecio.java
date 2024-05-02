public class Trapecio extends Shape{
    private double baseMayor, baseMenor, altura, ladoInclinado;
    Trapecio(double baseMayor, double baseMenor, double altura, double ladoInclinado){
        this.baseMayor = baseMayor;
        this.baseMenor = baseMenor;
        this.altura = altura;
        this.ladoInclinado= ladoInclinado;
    }
    @Override
    public double calcularArea(){
        double area = ((baseMayor + baseMenor)*altura)/2;
        return area;
    }

    @Override
    public double calcularPerimetro() {
        double perimetro = baseMayor +baseMenor+ ladoInclinado*2;
        return perimetro;
    }
}
