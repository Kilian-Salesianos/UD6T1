import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import net.salesianos.participante.Participante;
import net.salesianos.pelicula.Pelicula;
import net.salesianos.pedido.Pedido;

public class App {

    public static void main(String[] args) {
        actividad1Pedidos();

        //Esto es para que cree un espacio entre las actividades
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        actividad2Participantes();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        actividad3Peliculas();
    }

    private static void actividad1Pedidos() {
        System.out.println("ACTIVIDAD 1: GESTIÓN DE PEDIDOS\n");
        
        Queue<Pedido> colaPedidos = new LinkedList<Pedido>();
        Stack<Pedido> pilaPedidosPreparados = new Stack<Pedido>();
        
        colaPedidos.offer(new Pedido("P001", "Carla", "Café con leche", true));
        colaPedidos.offer(new Pedido("P002", "Mario", "Bocadillo de pollo", false));
        colaPedidos.offer(new Pedido("P003", "Nerea", "Zumo natural", true));
        colaPedidos.offer(new Pedido("P004", "Iván", "Tostada integral", false));
        colaPedidos.offer(new Pedido("P005", "Laura", "Té verde", true));
        
        System.out.println("Pedidos pendientes");
        for (Pedido pedido : colaPedidos) {
            System.out.println(pedido);
        }
        System.out.println();
        
        System.out.println("Primer pedido sin eliminar");
        System.out.println(colaPedidos.peek());
        System.out.println();
        
        System.out.println("Preparando tres pedidos");
        for (int i = 0; i < 3; i++) {
            Pedido pedidoPrepared = colaPedidos.poll();
            if (pedidoPrepared != null) {
                pilaPedidosPreparados.push(pedidoPrepared);
                System.out.println("Preparado: " + pedidoPrepared);
            }
        }
        System.out.println();
        
        System.out.println("Último pedido preparado");
        System.out.println(pilaPedidosPreparados.peek());
        System.out.println();
        
        System.out.println("Extrayendo pedido del historial");
        Pedido pedidoExtraido = pilaPedidosPreparados.pop();
        System.out.println("Extraído: " + pedidoExtraido);
        System.out.println();
        
        System.out.println("Pedidos pendientes: " + colaPedidos.size());
        System.out.println("¿Cola vacía? " + colaPedidos.isEmpty());
    }

    private static void actividad2Participantes() {
        System.out.println("ACTIVIDAD 2: Participantes \n");
        
        Set<Participante> participantes = new HashSet<Participante>();
        
        Participante[] datosParticipantes = {
            new Participante("J001", "Adrián", "Junior"),
            new Participante("J002", "Paula", "Junior"),
            new Participante("J003", "Samuel", "Senior"),
            new Participante("J001", "Adrián repetido", "Senior"),
            new Participante("J004", "Claudia", "Senior"),
            new Participante("J005", "Diego", "Junior"),
            new Participante("J006", "Alba", "Experto")
        };
        
        System.out.println("Participantes intentados: " + datosParticipantes.length);
        
        for (Participante p : datosParticipantes) {
            participantes.add(p);
        }
        
        System.out.println("Participantes inscritos: " + participantes.size());
        System.out.println();
        
        System.out.println("Participantes");
        for (Participante p : participantes) {
            System.out.println(p);
        }
        System.out.println();
        
        HashMap<String, Integer> categorias = new HashMap<String, Integer>();
        
        for (Participante p : participantes) {
            if (categorias.containsKey(p.getCategoria())) {
                categorias.put(p.getCategoria(), categorias.get(p.getCategoria()) + 1);
            } else {
                categorias.put(p.getCategoria(), 1);
            }
        }
        
        System.out.println("Participantes por categoría");
        for (String categoria : categorias.keySet()) {
            System.out.println(categoria + ": " + categorias.get(categoria));
        }
        System.out.println();
        
        if (categorias.containsKey("Junior")) {
            System.out.println("Participantes Junior: " + categorias.get("Junior"));
        }
        System.out.println();
        
        if (categorias.containsKey("Experto")) {
            categorias.remove("Experto");
            System.out.println("Categoría 'Experto' eliminada.");
        }
        System.out.println();
        
        System.out.println("Claves del mapa: " + categorias.keySet());
    }

    private static void actividad3Peliculas() {
        System.out.println("ACTIVIDAD 3: PELÍCULAS\n");
        
        ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
        
        try {
            Scanner lector = new Scanner(new File("src/peliculas.csv"));
            
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
                    
                    peliculas.add(new Pelicula(titulo, genero, duracion));
                }
            }
            lector.close();
            
            System.out.println("Películas cargadas");
            for (Pelicula p : peliculas) {
                System.out.println(p);
            }
            System.out.println();
            
            int totalPeliculas = peliculas.size();
            int duracionTotal = 0;
            Pelicula peliculaMasLarga = peliculas.get(0);
            
            for (Pelicula p : peliculas) {
                duracionTotal += p.getDuracionMinutos();
                if (p.getDuracionMinutos() > peliculaMasLarga.getDuracionMinutos()) {
                    peliculaMasLarga = p;
                }
            }
            
            double duracionMedia = (double) duracionTotal / totalPeliculas;
            
            System.out.println("Estadísticas");
            System.out.println("Total de películas: " + totalPeliculas);
            System.out.println("Duración total: " + duracionTotal + " minutos");
            //Lo del formato lo busque y me lo dío la ia me pareció interesante
            System.out.println("Duración media: " + String.format("%.2f", duracionMedia) + " minutos");
            System.out.println("Película más larga: " + peliculaMasLarga);
            System.out.println();
            
            generarResumen(totalPeliculas, duracionTotal, duracionMedia, peliculaMasLarga);
            System.out.println("Fichero 'resumen_peliculas.txt' generado.");
            
            generarLog("Ejecución completada: " + totalPeliculas + " películas procesadas.");
            System.out.println("Fichero 'log_peliculas.txt' actualizado.");
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: Fichero 'peliculas.csv' no encontrado.");
            generarLog("Error: Fichero no encontrado.");
        }
    }

    private static void generarResumen(int total, int duracionTotal, double duracionMedia, Pelicula masLarga) {
        try {
            FileWriter writer = new FileWriter("resumen_peliculas.txt");
            writer.write("RESUMEN DE PELÍCULAS\n\n");
            writer.write("Total de películas: " + total + "\n");
            writer.write("Duración total: " + duracionTotal + " minutos\n");
            writer.write("Duración media: " + String.format("%.2f", duracionMedia) + " minutos\n");
            writer.write("Película más larga: " + masLarga + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al generar el resumen.");
        }
    }

    private static void generarLog(String mensaje) {
        try {
            FileWriter writer = new FileWriter("log_peliculas.txt", true);
            writer.write("[" + java.time.LocalDateTime.now() + "] " + mensaje + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al generar el log.");
        }
    }
}
