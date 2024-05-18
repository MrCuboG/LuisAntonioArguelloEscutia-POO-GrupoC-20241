package Proyecto.Users;

import Proyecto.Materia;

import java.util.List;

public class Profesor extends Usuario {
    private String CURP;  // If CURP also belongs to Proyecto.Users.Profesor
    private String RFC;
    private List<Materia> materiasImparte;
    private float sueldo;
    private String numeroControl;
    // other unique attributes of Proyecto.Users.Profesor
}
