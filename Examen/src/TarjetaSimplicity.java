import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TarjetaSimplicity extends Tarjetas {
    private static final double creditoMaximo = 60000;

    public TarjetaSimplicity(String numTarjeta, String clabeInterbancaria, double cantidad, String CVV, LocalDateTime fechaCreacion, LocalDateTime fechaDeVencimiento, LocalDateTime ultimoMovimiento) {
        super(numTarjeta, clabeInterbancaria, cantidad, CVV, fechaCreacion, fechaDeVencimiento, ultimoMovimiento);
    }

    public static TarjetaSimplicity crearTarjetaSimplicity() {
        long numeroAleatorio = (long) (Math.random() * 10000000000000000L);
        String numeroTarjeta = String.format("%016d", numeroAleatorio);

        numeroAleatorio = (long) (Math.random() * 10000000000000000L);
        String clabeInterbancaria = String.format("%016d", numeroAleatorio);

        int numAleatorio = (int) (Math.random() * 100);
        String CVV = String.format("%03d", numAleatorio);

        double cantidad = creditoMaximo;

        LocalDateTime fechaCreacion = LocalDateTime.now();
        LocalDateTime fechaDeVencimiento = fechaCreacion.plusYears(5);
        LocalDateTime ultimoMovimiento = LocalDateTime.now();

        return new TarjetaSimplicity(numeroTarjeta, clabeInterbancaria, cantidad, CVV, fechaCreacion, fechaDeVencimiento, ultimoMovimiento);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "Tarjeta de Débito:\n" +
                "Número de tarjeta: " + this.getNumTarjeta() + "\n" +
                "Clabe Interbancaria: " + super.getClabeInterbancaria() + "\n" +
                "Saldo: " + this.getCantidad() + "\n" +
                "CVV: " + this.getCVV() + "\n" +
                "Fecha de Creación: " + this.getFechaCreacion().format(formatter) + "\n" +
                "Fecha de Vencimiento: " + this.getFechaVencimiento().format(formatter) + "\n" +
                "Último Movimiento: " + this.getUltimoMovimiento().format(formatter) + "\n";
    }


    @Override
    public void agregarDinero(double cantidad) {
        super.agregarDinero(cantidad);
    }

    @Override
    public boolean retirarDinero(double cantidad) {
        return super.retirarDinero(cantidad);
    }

}
