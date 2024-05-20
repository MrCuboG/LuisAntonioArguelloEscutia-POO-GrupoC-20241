package Usuarios;

import libreria.Libreria;
import libreria.util.DatosComun;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import Usuarios.utils.Rol;

import static libreria.Libreria.usuarios;

public class Cliente extends Usuario {

    private LocalDate fechaRegistro; //Este tipo de datos manejan fechas (local)
    //retorna la fecha de hoy 2024-04-09

    public Cliente(String nombre, String apellido, String telefono, String nombreUsuario, String contraseña, String fechaNacimiento) {
        super(nombre, apellido, telefono, Rol.CLIENTE, nombreUsuario, contraseña, fechaNacimiento);
        this.fechaRegistro = LocalDate.now(); //accede a la fecha actual
    }


    //toString() obtiene la direccion de memoria
    @Override//existe en la clase padre, pero la estamos sobreescribiendo en la clase hija


    public String toString() { //Aqui  lo estamos sobreescribiendogracias al override y con eso el programa toma primero en cuenta la clase hija que el metodo de la clase padre
        return String.format("%s, Fecha de registro: %s", super.toString(), this.fechaRegistro);
    }

    public static void registrarClientes() {
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.CLIENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);
        String fechaNacimiento = datosComun.get(5);

        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contraseña, fechaNacimiento);

        if (!usuarios.containsKey(Rol.CLIENTE)) {
            usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.CLIENTE).add(cliente);
        System.out.println("\n Cliente registrado exitosamente...");

    }

    public static void mostrarClientes() {
        System.out.println("\n Clientes en la Biblioteca");
        for (Usuario usuario : usuarios.get(Rol.CLIENTE)) {
            if (usuario.getRol() == Rol.CLIENTE) {
                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente.toString());
            }
        }
    }

    public static void EliminarCliente(int idCliente) {
        boolean encontrado = false;
        Iterator<Usuario> iterator = usuarios.get(Rol.CLIENTE).iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario instanceof Cliente && ((Cliente) usuario).getId() == idCliente) {
                iterator.remove();
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("\nCliente eliminado exitosamente.");
        } else {
            System.out.println("\nNo se encontró ningún cliente con ese ID.");
        }
    }

}
