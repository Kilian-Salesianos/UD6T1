import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import net.salesianos.pelicula.Pelicula;
import net.salesianos.pedido.Pedido;
import net.salesianos.participante.Participante;

public class App {

    public static void main(String[] args) {
        ArrayList<Pelicula> peliculas = cargarPeliculas("src/peliculas.csv");
        ArrayList<Pedido> pedidos = crearPedidos();
        ArrayList<Participante> participantes = crearParticipantes();

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            mostrarMenu();
            opcion = teclado.nextInt();
            teclado.nextLine();

            if (opcion == 1) {
                mostrarPeliculas(peliculas);
            } else if (opcion == 2) {
                mostrarResumenPeliculas(peliculas);
            } else if (opcion == 3) {
                mostrarPedidos(pedidos);
            } else if (opcion == 4) {
                mostrarParticipantes(participantes);
            } else if (opcion == 5) {
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opción no válida. Elige otra vez.");
            }
        }

        teclado.close();
    }

    private static void mostrarMenu() {
        System.out.println("Menú");
        System.out.println("1. Mostrar películas");
        System.out.println("2. Mostrar resumen de películas");
        System.out.println("3. Mostrar pedidos");
        System.out.println("4. Mostrar participantes");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
    }

    private static ArrayList<Pelicula> cargarPeliculas(String ruta) {
        ArrayList<Pelicula> lista = new ArrayList<Pelicula>();
        try {
            Scanner lector = new Scanner(new File(ruta));
            if (lector.hasNextLine()) {
                lector.nextLine();
            }
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String titulo = partes[0];
                    String genero = partes[1];
                    int duracion = Integer.parseInt(partes[2].trim());
                    lista.add(new Pelicula(titulo, genero, duracion));
                }
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero de películas.");
        }
        return lista;
    }

    private static ArrayList<Pedido> crearPedidos() {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        pedidos.add(new Pedido("P001", "Laura", "Palomitas", true));
        pedidos.add(new Pedido("P002", "Carlos", "Refresco", false));
        pedidos.add(new Pedido("P003", "Ana", "Bocadillo", true));
        return pedidos;
    }

    private static ArrayList<Participante> crearParticipantes() {
        ArrayList<Participante> participantes = new ArrayList<Participante>();
        participantes.add(new Participante("J01", "Lucía", "Junior"));
        participantes.add(new Participante("J02", "Miguel", "Senior"));
        participantes.add(new Participante("J03", "Sofía", "Elite"));
        return participantes;
    }

    private static void mostrarPeliculas(ArrayList<Pelicula> peliculas) {
        System.out.println("--- Películas disponibles ---");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
        System.out.println();
    }

    private static void mostrarResumenPeliculas(ArrayList<Pelicula> peliculas) {
        System.out.println("--- Resumen de películas ---");
        System.out.println("Total de películas: " + peliculas.size());
        if (peliculas.size() > 0) {
            Pelicula masLarga = peliculas.get(0);
            int contadorCienciaFiccion = 0;
            for (Pelicula pelicula : peliculas) {
                if (pelicula.getDuracionMinutos() > masLarga.getDuracionMinutos()) {
                    masLarga = pelicula;
                }
                if (pelicula.getGenero().equalsIgnoreCase("Ciencia ficción")) {
                    contadorCienciaFiccion++;
                }
            }
            System.out.println("Película más larga: " + masLarga);
            System.out.println("Películas de ciencia ficción: " + contadorCienciaFiccion);
        }
        System.out.println();
    }

    private static void mostrarPedidos(ArrayList<Pedido> pedidos) {
        System.out.println("--- Pedidos registrados ---");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
        System.out.println();
    }

    private static void mostrarParticipantes(ArrayList<Participante> participantes) {
        System.out.println("--- Participantes inscritos ---");
        for (Participante participante : participantes) {
            System.out.println(participante);
        }
        System.out.println();
    }
}
