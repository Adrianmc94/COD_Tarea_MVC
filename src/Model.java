import java.util.ArrayList;

/**
 * Clase que maneja los datos (modelo) del programa.
 */
public class Model {
    static ArrayList<Coche> parking = new ArrayList<>();

    public static Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    public static Coche getCoche(String matricula){
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                return e;
            }
        }
        return null;
    }

    public static int cambiarVelocidad(String matricula, Integer v) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.velocidad = v;
            return coche.velocidad;
        }
        return -1;
    }

    public static int getVelocidad(String matricula) {
        Coche coche = getCoche(matricula);
        return (coche != null) ? coche.velocidad : -1;
    }

    public static ArrayList<Coche> getAllCoches() {
        return parking;
    }


}
