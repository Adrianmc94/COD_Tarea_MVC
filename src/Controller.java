import java.util.ArrayList;

/**
 * Controlador que gestiona la lógica de la app.
 */
public class Controller {

    public static Coche crearCoche(String modelo, String matricula) {
        return Model.crearCoche(modelo, matricula);
    }

    public static int aumentarVelocidad(String matricula, int incremento) {
        Coche coche = Model.getCoche(matricula);
        if (coche != null) {
            int nuevaVel = coche.velocidad + incremento;
            return Model.cambiarVelocidad(matricula, nuevaVel);
        }
        return -1;
    }

    public static int disminuirVelocidad(String matricula, int decremento) {
        Coche coche = Model.getCoche(matricula);
        if (coche != null) {
            int nuevaVel = Math.max(0, coche.velocidad - decremento);
            return Model.cambiarVelocidad(matricula, nuevaVel);
        }
        return -1;
    }

    public static ArrayList<Coche> obtenerTodosLosCoches() {
        return Model.getAllCoches();
    }


}
