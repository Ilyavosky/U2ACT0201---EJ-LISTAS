package utils;
import java.util.ArrayList;
import java.util.LinkedList;

public class HomeworkListUtils {

    LinkedList<String> homeworkList = new LinkedList<>();

    public static String addTask(LinkedList<String> homeworkList, String task) {
        if (homeworkList.isEmpty()) {
            System.out.println("La lista de tareas se encuentra vacía");
        }
        homeworkList.add(task);
        return task;
        }
    }

    public static boolean isCompleted(boolean taskStatus) {
        if (taskStatus == true) {
            return true;
        }else  {
            return false;
        }
    }

}
