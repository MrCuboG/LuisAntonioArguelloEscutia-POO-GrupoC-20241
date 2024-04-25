public class Rectangulo extends Shape{
    private double base, altura;

    Rectangulo(double base, double altura){
        this.base = base;
        this.altura =altura;
    }

    @Override
    public double calcularArea(){
        double area = base * altura;
        return area;
    }
    @Override
    public double calcularPerimetro(){
        double perimetro = (base * 2) + (altura * 2);
        return perimetro;
    }
}
