package models;
/*
Ejercicio 1: Lista de Tareas Pendientes
Desarrolla una aplicación para gestionar tareas pendientes donde cada tarea tiene una descripción y una prioridad (alta,
                                                                                                                   media, baja). La aplicación debe permitir:
1.-Agregar tareas nuevas
2.-Marcar tareas como completadas (eliminándolas de la lista)
3.-Mostrar todas las tareas pendientes
4.-Buscar una tarea específica por su descripción
5.-Mostrar solo las tareas de alta prioridad
Reto adicional: Implementa un método que ordene las tareas por prioridad automáticamente al insertar.
*/

public class homeworkList {
    private String task;
    private boolean taskStatus;
    private String taskDescription;
    private String priority;

    public homeworkList(){}

    public homeworkList(String task, boolean taskStatus, String taskDescription, String priority) {
        this.task = task;
        this.taskStatus = taskStatus;
        this.taskDescription = taskDescription;
        this.priority = priority;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "homeworkList{" +
                "task='" + task + '\'' +
                ", taskStatus=" + taskStatus +
                ", taskDescription='" + taskDescription + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }


}
