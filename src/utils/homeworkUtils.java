package utils;

import java.util.LinkedList;

public class homeworkUtils {
    LinkedList<String> homeworkList = new LinkedList<>();

    public static String addTask(LinkedList<String> homeworkList, String task) {
        if (homeworkList.isEmpty()) {
            System.out.println("La lista de tareas se encuentra vacía");
        }
        homeworkList.add(task);
        return task;
    }

    public static boolean isCompleted(boolean taskStatus) {
        return taskStatus;
    }

    public static boolean eraseTask(LinkedList<String> homeworkList, String task, boolean taskStatus) {
        if (taskStatus == true){
            homeworkList.remove(task);
        }
        return true;
    }

    public static boolean pendentTask(LinkedList<String> homeworkList, String task, boolean taskStatus) {
        if (taskStatus == false){
            System.out.println(homeworkList);
        }else{
            System.out.println("No hay tareas pendientes");
        }
        return taskStatus;
    }

    public static String getByDescription( String taskDescription, LinkedList<String> homeworkList){
        String actual = homeworkList.getFirst();
        while (actual != null){
            if (actual.getDescription.equals(taskDescription)){
                taskDescription = actual;
                break;
            }
            actual = homeworkList.getNext(actual);
        }
    }


}
