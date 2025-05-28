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












view:
case 5:
System.out.print("Matrícula del coche: ");
String mat3 = scanner.nextLine();
System.out.print("Distancia a avanzar (en metros): ");
int metros = scanner.nextInt();
scanner.nextLine();
String mensaje = Controller.avanzarCoche(mat3, metros);
System.out.println(mensaje);
break;

                case 6:
                    System.out.print("Matrícula del coche: ");
                    String mat4 = scanner.nextLine();
                    System.out.print("Litros de gasolina a añadir: ");
                    int litros = scanner.nextInt();
                    scanner.nextLine();
                    double gasActual = Controller.ponerGasolinaCoche(mat4, litros);
                    System.out.println("Gasolina actual: " + String.format("%.2f", gasActual) + " litros");
                    break;