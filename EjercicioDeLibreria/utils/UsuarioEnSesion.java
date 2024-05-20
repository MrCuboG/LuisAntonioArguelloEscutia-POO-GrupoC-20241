package utils;

import Usuarios.Usuario;

/*
Proceso 1:
    Iniciar Sesion
        Validamos sus datos
           1. Si todo sale correcto
                 Mandamos a llamar a UsuarioEnSesion
                 UsuarioEnSesion. setUsuarioActual(usuario)

           2. Sino, devolvemos un error

    Editar datos
        usuario = UsuarioEnSesion.obtenerIntancia()
     Login
 */

public class UsuarioEnSesion {

    private static UsuarioEnSesion instancia;
    private Usuario UsuarioActual;

    private UsuarioEnSesion() {
    }

    public static UsuarioEnSesion obtenerInstancia() {
        if (instancia == null) {
            instancia = new UsuarioEnSesion();

        }
        return instancia;
    }

    public Usuario getUsuarioActual() {
        return UsuarioActual;
    }

    public void setUsuarioActual(Usuario UsuarioActual) {
        this.UsuarioActual = UsuarioActual;
    }

    public boolean hayUsuarioEnSesion(){
        return UsuarioActual != null;
    }

    public void cerrarSesion(){
        instancia = null;
        UsuarioActual = null;
    }


}
