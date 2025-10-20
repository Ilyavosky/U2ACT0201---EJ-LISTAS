package utils;

import models.webPage;
import java.util.LinkedList;
import java.util.Iterator;

public class historyUtils {

    private LinkedList<webPage> backStack;
    private LinkedList<webPage> forwardStack;
    private final int MAX_HISTORY_SIZE = 10;

    public historyUtils() {
        this.backStack = new LinkedList<>();
        this.forwardStack = new LinkedList<>();
    }

    public void showCurrentPage() {
        if (this.backStack.isEmpty()) {
            System.out.println("No hay ninguna página cargada.");
            return;
        }
        webPage currentPage = this.backStack.peek();
        System.out.println("Página actual: " + currentPage.getTitle());
    }

    public void visitNewPage(webPage newPage) {
        this.backStack.push(newPage);

        if (!this.forwardStack.isEmpty()) {
            this.forwardStack.clear();
        }

        if (this.backStack.size() > MAX_HISTORY_SIZE) {
            this.backStack.removeLast();
        }

        System.out.println("Navegando a: " + newPage.getTitle());
    }

    public void goBack() {
        if (this.backStack.size() <= 1) {
            System.out.println("No hay historial hacia atrás.");
            return;
        }

        webPage pageToMove = this.backStack.pop();
        this.forwardStack.push(pageToMove);

        System.out.println("Átras");
        showCurrentPage();
    }

    public void goForward() {
        if (this.forwardStack.isEmpty()) {
            System.out.println("No hay historial hacia adelante.");
            return;
        }

        webPage pageToMove = this.forwardStack.pop();
        this.backStack.push(pageToMove);

        System.out.println("Adelante");
        showCurrentPage();
    }

    public void showFullHistory() {
        if (this.backStack.isEmpty()) {
            System.out.println("El historial está vacío.");
            return;
        }

        System.out.println("Historial de Navegación");
        Iterator<webPage> it = this.backStack.descendingIterator();
        int count = 1;
        while(it.hasNext()) {
            webPage page = it.next();
            System.out.println(count + ". " + page.getTitle() + " (" + page.getUrl() + ")");
            count++;
        }
        System.out.println("---------------------------------");
    }

    public void searchHistory(String query) {
        System.out.println("Resultados de búsqueda para: '" + query + "'");
        boolean found = false;
        String queryLower = query.toLowerCase();

        for (webPage page : this.backStack) {
            if (page.getTitle().toLowerCase().contains(queryLower) ||
                    page.getUrl().toLowerCase().contains(queryLower)) {

                System.out.println("Encontrado: " + page);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No se encontraron resultados.");
        }
    }

    public void clearHistory() {
        this.backStack.clear();
        this.forwardStack.clear();
        System.out.println("Historial borrado.");
    }
}