import models.homeworkList;
import models.musicPlayer;
import models.webPage;
import utils.historyUtils;
import utils.homeworkUtils;
import utils.playerUtils;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final LinkedList<homeworkList> tareas = new LinkedList<>();
    private static final playerUtils reproductor = new playerUtils();
    private static final historyUtils navegador = new historyUtils();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Administrador de Tareas");
            System.out.println("2. Reproductor de Música");
            System.out.println("3. Historial de Navegación");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    runHomeworkMenu();
                    break;
                case "2":
                    runPlayerMenu();
                    break;
                case "3":
                    runHistoryMenu();
                    break;
                case "0":
                    running = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        scanner.close();
    }

    private static void runHomeworkMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Gestor de Tareas ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Completar tarea (por descripción)");
            System.out.println("3. Mostrar tareas pendientes");
            System.out.println("4. Mostrar tareas de alta prioridad");
            System.out.println("5. Buscar tarea (por descripción)");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Título de la tarea: ");
                    String task = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String desc = scanner.nextLine();
                    System.out.print("Prioridad (alta, media, baja): ");
                    String priority = scanner.nextLine();
                    homeworkList nuevaTarea = new homeworkList(task, false, desc, priority);
                    homeworkUtils.addTask(tareas, nuevaTarea);
                    break;
                case "2":
                    System.out.print("Descripción de la tarea a completar: ");
                    String descCompleta = scanner.nextLine();
                    homeworkList tareaCompleta = homeworkUtils.getByDescription(descCompleta, tareas);
                    if (tareaCompleta != null) {
                        if (homeworkUtils.completeAndEraseTask(tareas, tareaCompleta)) {
                            System.out.println("Tarea completada y eliminada.");
                        } else {
                            System.out.println("No se pudo eliminar la tarea.");
                        }
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;
                case "3":
                    homeworkUtils.showPendentTasks(tareas);
                    break;
                case "4":
                    homeworkUtils.showPriorityTasks(tareas);
                    break;
                case "5":
                    System.out.print("Descripción de la tarea a buscar: ");
                    String descBuscar = scanner.nextLine();
                    homeworkList tareaBuscada = homeworkUtils.getByDescription(descBuscar, tareas);
                    if (tareaBuscada != null) {
                        System.out.println("Tarea encontrada: " + tareaBuscada);
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private static void runPlayerMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Reproductor de Música ---");
            System.out.println("1. Agregar canción");
            System.out.println("2. Siguiente canción");
            System.out.println("3. Canción anterior");
            System.out.println("4. Eliminar canción actual");
            System.out.println("5. Mostrar canción actual");
            System.out.println("6. Mostrar playlist completa");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Título de la canción: ");
                    String title = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artist = scanner.nextLine();
                    musicPlayer newSong = new musicPlayer(title, artist, false, false);
                    reproductor.addSong(newSong);
                    break;
                case "2":
                    reproductor.nextSong();
                    reproductor.currentSong();
                    break;
                case "3":
                    reproductor.previousSong();
                    reproductor.currentSong();
                    break;
                case "4":
                    reproductor.deleteCurrentSong();
                    break;
                case "5":
                    reproductor.currentSong();
                    break;
                case "6":
                    reproductor.showFullPlaylist();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private static void runHistoryMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Historial de Navegación ---");
            System.out.println("1. Visitar nueva página");
            System.out.println("2. Ir atrás");
            System.out.println("3. Ir adelante");
            System.out.println("4. Mostrar historial completo");
            System.out.println("5. Buscar en historial");
            System.out.println("6. Borrar historial");
            System.out.println("7. Mostrar página actual");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Título de la página: ");
                    String title = scanner.nextLine();
                    System.out.print("URL de la página: ");
                    String url = scanner.nextLine();
                    webPage newPage = new webPage(url, title);
                    navegador.visitNewPage(newPage);
                    break;
                case "2":
                    navegador.goBack();
                    break;
                case "3":
                    navegador.goForward();
                    break;
                case "4":
                    navegador.showFullHistory();
                    break;
                case "5":
                    System.out.print("Término de búsqueda: ");
                    String query = scanner.nextLine();
                    navegador.searchHistory(query);
                    break;
                case "6":
                    navegador.clearHistory();
                    break;
                case "7":
                    navegador.showCurrentPage();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}