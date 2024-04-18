package usuarios.utils;
/*
Patrones de diseño
Singleton: Singleton es un patrón de diseño creacional que nos permite asegurarnos de 
que una clase tenga una única instancia, a la vez que proporciona un punto de 
acceso global a dicha instancia.

1. Garantizar que una clase tenga una única instancia.
2. Proporcionar un punto de acceso global a dicha instancia.

Ejemplo de uso
* Proceso 1:
  Iniciar sesion
        validamos sus datos
            1. Si todo sale correcto 
               Mandar llamar a UsuarioEnSesion
               UsuarioEnSesion.setUsuarioActual(usuario)
               
            2. Si no, devolvemos null

    clase Editar datos
        usuario = UsuarioEnSesion.ObtenerInstancia()

    Login
        como ya hay una instancia, ya no crea una nueva, retorna la que ya está creada
 */

import usuarios.Usuario;

public class UsuarioEnSesion 
{
    private static UsuarioEnSesion instancia;
    private Usuario usuarioActual;
    
    //constructor privado
    private UsuarioEnSesion(){
        
    }
    
    //estático para no tener que crear un nuevo objeto cada que usemos esta clase
    public static UsuarioEnSesion obtenerInstancia()
    {
        if(instancia == null)
        {
            instancia = new UsuarioEnSesion();
        }
        return instancia;
    }
    
    public Usuario getUsuarioActual()
    {
        return usuarioActual;
    }
    
    public void setUsuarioActual(Usuario usuarioActual)
    {
        this.usuarioActual = usuarioActual;
    }
    
    public boolean hayUsuarioEnSesion()
    {
        return usuarioActual != null;
    }
    
    public void cerrarSesion()
    {
        instancia = null;
        usuarioActual = null;
    }
}