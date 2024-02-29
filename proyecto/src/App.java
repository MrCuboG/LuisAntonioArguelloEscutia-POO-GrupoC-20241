public class App {
    public static void main(String[] args) throws Exception {
        Producto producto1 = new Producto("Chocolate", 23);
        Producto producto2 = new Producto("Papas Fritas", 18.50f, 30);

        System.out.println(producto1.getNombre());
        System.out.println(producto1.getPrecio());
        System.out.println(producto1.getStock());

        System.out.println("///////////////////////////////");
        
        System.out.println(producto2.getNombre());
        producto2.setNombre("Refresco");
        System.out.println(producto2.getNombre());

        System.out.println(producto2.getPrecio());
        producto2.setPrecio(30.20f);
        System.out.println(producto2.getPrecio());

        System.out.println(producto2.getStock());
        producto2.setStock(40);
        System.out.println(producto2.getStock());

        System.out.println("///////////////////////////////");

        System.out.println(producto1.getStock());
        producto1.aumentarStock(10);
        System.out.println(producto1.getStock());

        System.out.println(producto1.getStock());
        producto1.reducirStock(10);
        System.out.println(producto1.getStock());
    }

}
