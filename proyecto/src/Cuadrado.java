public class Cuadrado extends Shape{
    private double lado;
    
    Cuadrado(double lado){
        this.lado = lado;
    }

    @Override
    public double calcularArea(){
        double area = lado * lado;
        return area;
    }
    @Override
    public double calcularPerimetro(){
        double perimetro = lado * 4;
        return perimetro;
    }
}
