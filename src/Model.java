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

    /**
     * Permite avanzar un coche cierta distancia y consume gasolina.
     * @param matricula Matrícula del coche
     * @param metros Distancia en metros
     * @return Mensaje de estado
     */
    public static String avanzar(String matricula, int metros) {
        Coche coche = getCoche(matricula);
        if (coche == null) return "Coche no encontrado.";
        if (coche.velocidad == 0) return "El coche debe tener velocidad mayor a 0 para avanzar.";

        double consumo = (metros / 1000.0) * (coche.velocidad / 100.0); // fórmula de consumo
        if (coche.gasolina >= consumo) {
            coche.gasolina -= consumo;
            return "El coche avanzó " + metros + " metros. Gasolina restante: " + String.format("%.2f", coche.gasolina) + " litros.";
        } else {
            return "No hay suficiente gasolina para avanzar.";
        }
    }

    /**
     * Añade gasolina a un coche.
     * @param matricula Matrícula del coche
     * @param litros Litros a añadir
     * @return Gasolina actual
     */
    public static double ponerGasolina(String matricula, int litros) {
        Coche coche = getCoche(matricula);
        if (coche != null && litros > 0) {
            coche.gasolina += litros;
            return coche.gasolina;
        }
        return -1;
    }
}
