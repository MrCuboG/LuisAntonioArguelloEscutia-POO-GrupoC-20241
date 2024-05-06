package src.Users;

public class Usuario {
    private String name;
    private String user, password;
    private Rol rol;

    public Usuario(String name, String user, String password, Rol rol) {
        this.name = name;
        this.user = user;
        this.password = password;
        this.rol = rol;
    }
}
