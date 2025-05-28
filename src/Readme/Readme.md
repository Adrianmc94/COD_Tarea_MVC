model:
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
















Controller:
public static String avanzarCoche(String matricula, int metros) {
return Model.avanzar(matricula, metros);
}

    public static double ponerGasolinaCoche(String matricula, int litros) {
        return Model.ponerGasolina(matricula, litros);
    }