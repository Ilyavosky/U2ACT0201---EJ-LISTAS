package utils;

import models.homeworkList;
import java.util.LinkedList;

public class homeworkUtils {

    public static void addTask(LinkedList<homeworkList> list, homeworkList task) {
        list.add(task);
        System.out.println("Tarea agregada: " + task.getTask());
    }

    public static boolean completeAndEraseTask(LinkedList<homeworkList> list, homeworkList task) {
        return list.remove(task);
    }

    public static void showPendentTasks(LinkedList<homeworkList> list) {
        System.out.println("Tareas Pendiente:");
        int count = 0;
        for (homeworkList task : list) {
            if (!task.isTaskStatus()) {
                System.out.println(task);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No hay tareas pendientes.");
        }
    }

    public static homeworkList getByDescription(String taskDescription, LinkedList<homeworkList> list) {
        for (homeworkList task : list) {
            if (task.getTaskDescription().equals(taskDescription)) {
                return task;
            }
        }
        return null;
    }

    public static void showPriorityTasks(LinkedList<homeworkList> list) {
        System.out.println("Tareas Pendientes de Alta Prioridad");
        int count = 0;
        for (homeworkList task : list) {
            if (task.getPriority().equalsIgnoreCase("alta") && !task.isTaskStatus()) {
                System.out.println(task);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No hay tareas pendientes");
        }

    }

    public static boolean isTaskCompleted(homeworkList task) {
        return task.isTaskStatus();
    }
}