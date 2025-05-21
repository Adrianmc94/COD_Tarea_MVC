import java.util.Scanner; // Importa la clase Scanner para leer entrada del usuario por consola
// Clase que muestra el menú principal de la aplicación
public class View {
    public static void menu() {
        Scanner scanner = new Scanner(System.in); // Se crea un objeto Scanner para capturar entrada del usuario
        int opcion; // Variable para almacenar la opción elegida por el usuario

        // Bucle principal del menú
        do {
            // Se muestra el menú con las distintas opciones disponibles
            System.out.println("\n--- MENÚ ---");
            System.out.println("1- Crear coche");
            System.out.println("2- Aumentar velocidad");
            System.out.println("3- Disminuir velocidad");
            System.out.println("4- Mostrar todos los coches");
            System.out.println("0- Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt(); // Se lee la opción como número entero
            scanner.nextLine(); // Limpia el buffer para evitar errores con scanner.nextLine()

            switch (opcion) {
                case 1:
                    // Opción para crear un coche nuevo
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine(); // Lee el modelo del coche
                    System.out.print("Matrícula: ");
                    String matricula = scanner.nextLine(); // Lee la matrícula del coche
                    Coche nuevo = Controller.crearCoche(modelo, matricula); // Llama al controlador para crear el coche
                    System.out.println("Coche creado: " + nuevo.modelo + " [" + nuevo.matricula + "]");
                    break;

                case 2:
                    // Opción para aumentar la velocidad de un coche
                    System.out.print("Matrícula del coche: ");
                    String mat1 = scanner.nextLine(); // Lee la matrícula
                    System.out.print("Incremento de velocidad: ");
                    int inc = scanner.nextInt(); // Lee la cantidad de velocidad a aumentar
                    int velA = Controller.aumentarVelocidad(mat1, inc); // Llama al controlador
                    System.out.println("Nueva velocidad: " + velA + " km/h");
                    break;

                case 3:
                    // Opción para disminuir la velocidad de un coche
                    System.out.print("Matrícula del coche: ");
                    String mat2 = scanner.nextLine(); // Lee la matrícula
                    System.out.print("Reducción de velocidad: ");
                    int dec = scanner.nextInt(); // Lee la cantidad de velocidad a disminuir
                    int velD = Controller.disminuirVelocidad(mat2, dec); // Llama al controlador
                    System.out.println("Nueva velocidad: " + velD + " km/h");
                    break;

                case 4:
                    // Opción para mostrar todos los coches registrados
                    System.out.println("\nLista de coches:");
                    for (Coche c : Controller.obtenerTodosLosCoches()) {
                        System.out.println("- " + c.modelo + " [" + c.matricula + "] - Velocidad: " + c.velocidad + " km/h");
                    }
                    break;

                case 0:
                    // Salida del programa
                    System.out.println("Saliendo...");
                    break;

                default:
                    // Opción inválida
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 0); // El menú se repite hasta que el usuario elija salir

        scanner.close(); // Se cierra el Scanner al terminar
    }
}

