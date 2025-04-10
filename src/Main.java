import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ColaEnteros cola = new ColaEnteros();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Encolar número entero");
            System.out.println("2. Desencolar");
            System.out.println("3. Ver frente");
            System.out.println("4. Mostrar cola");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Debes ingresar una opción numérica del menú.");
                scanner.next(); // limpiar
                System.out.print("Elige una opción: ");
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa un número entero: ");
                    if (scanner.hasNextInt()) {
                        int numero = scanner.nextInt();
                        scanner.nextLine(); // limpiar buffer
                        cola.encolar(numero);
                        System.out.println("Número agregado a la cola.");
                        cola.imprimirCola(); // Mostrar la cola
                    } else {
                        System.out.println("❌ Error: Solo se permiten números enteros.");
                        scanner.nextLine(); // descartar entrada inválida
                    }
                    break;

                case 2:
                    try {
                        int eliminado = cola.desencolar();
                        System.out.println("Elemento eliminado: " + eliminado);
                        cola.imprimirCola();
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Elemento al frente: " + cola.verFrente());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    cola.imprimirCola();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
