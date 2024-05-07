import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: División por cero.");
}
try {
    int[] arreglo = new int[5];
    int valor = arreglo[10];
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Error: Índice fuera de rango.");
}
try {
    Object obj = new Integer(10);
    String str = (String) obj;
} catch (ClassCastException e) {
    System.out.println("Error: Conversión de tipos inválida.");
}
try {
    Scanner teclado = new Scanner(System.in);
    int num = teclado.nextInt();
} catch (InputMismatchException e) {
    System.out.println("Error: Entrada inválida. Debe ser un número entero.");
}
class MiExcepcion extends Exception {
    public MiExcepcion(String mensaje) {
        super(mensaje);
    }
}

try {
    throw new MiExcepcion("Esto es una excepción personalizada.");
} catch (MiExcepcion e) {
    System.out.println("Error personalizado: " + e.getMessage());
}
try {
    FileReader archivo = new FileReader("archivo.txt");
} catch (FileNotFoundException e) {
    System.out.println("Error: Archivo no encontrado.");
}
try {
    URL url = new URL("https://www.example.com");
    HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
    conexion.setConnectTimeout(5000); // 5 segundos
    conexion.connect();
} catch (SocketTimeoutException e) {
    System.out.println("Error: Tiempo de espera agotado.");
}
try {
    File archivo = new File("/ruta/restringida/archivo.txt");
    FileInputStream fis = new FileInputStream(archivo);
} catch (SecurityException e) {
    System.out.println("Error: Acceso no permitido al archivo.");
}
class NumeroNegativoException extends Exception {
    public NumeroNegativoException(String mensaje) {
        super(mensaje);
    }
}

try {
    int valor = -5;
    if (valor < 0) {
        throw new NumeroNegativoException("Número negativo no permitido.");
    }
} catch (NumeroNegativoException e) {
    System.out.println("Error personalizado: " + e.getMessage());
}

    }

    
}


