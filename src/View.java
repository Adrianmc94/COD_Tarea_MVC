import java.util.Scanner;

public class View {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1- Crear coche");
            System.out.println("2- Aumentar velocidad");
            System.out.println("3- Disminuir velocidad");
            System.out.println("4- Mostrar todos los coches");
            System.out.println("5- Avanzar: ");
            System.out.println("6- Poner gasolina: ");
            System.out.println("0- Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Matrícula: ");
                    String matricula = scanner.nextLine();
                    Coche nuevo = Controller.crearCoche(modelo, matricula);
                    System.out.println("Coche creado: " + nuevo.modelo + " [" + nuevo.matricula + "]");
                    break;

                case 2:
                    System.out.print("Matrícula del coche: ");
                    String mat1 = scanner.nextLine();
                    System.out.print("Incremento de velocidad: ");
                    int inc = scanner.nextInt();
                    int velA = Controller.aumentarVelocidad(mat1, inc);
                    System.out.println("Nueva velocidad: " + velA + " km/h");
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.print("Matrícula del coche: ");
                    String mat2 = scanner.nextLine();
                    System.out.print("Reducción de velocidad: ");
                    int dec = scanner.nextInt();
                    int velD = Controller.disminuirVelocidad(mat2, dec);
                    System.out.println("Nueva velocidad: " + velD + " km/h");
                    scanner.nextLine();
                    break;

                case 4:
                    System.out.println("\nLista de coches:");
                    for (Coche c : Controller.obtenerTodosLosCoches()) {
                        System.out.println("- " + c.modelo + " [" + c.matricula + "] - Velocidad: " + c.velocidad + " km/h - Gasolina: " + String.format("%.2f", c.gasolina) + " L");
                    }
                    break;

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

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }
    static void avisoObserver(){
        System.out.println("Observer!! Hay que repostar!");
    }
}
