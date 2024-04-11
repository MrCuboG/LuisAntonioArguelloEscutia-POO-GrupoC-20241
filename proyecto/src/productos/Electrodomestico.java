package productos;

public class Electrodomestico extends Producto{
    private String tipoElectrodomestico;
    private int stock;
    TipoProducto tipoProducto = TipoProducto.ELECTRODOMESTICO;

    public Electrodomestico(String nombre, float precio, String numeroDeSerie, String tipoElectrodomestico, int stock) {
        super(nombre, precio, numeroDeSerie);
        this.stock =stock;
        this.fechaRegistro = super.fechaRegistro;
        this.tipoElectrodomestico = tipoElectrodomestico;
    }

    @Override
    public void agregarStock(int stockExtra){
        this.stock += stockExtra;
    }
    @Override
    public void quitarStock(int stockMenos){
        this.stock -= stockMenos;
    }

    @Override
    public String datos(){
        String extra = String.format("Tipo De Electrodomestico: %s",
        this.tipoElectrodomestico);
        return super.datos() + extra;
    }
    public Electrodomestico comprar(String nom, float pre, String num){
        System.out.print("Inserte el Tipo De Electrodomestico: %s");
        String tip = scanner.nextLine();
        return (new Electrodomestico(nom, pre, num, this.tipoElectrodomestico, this.stock));

    }

}
