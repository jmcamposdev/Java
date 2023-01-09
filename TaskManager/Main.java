package TaskManager;
import Funciones.GetData;

public class Main {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        int optionSelected = 0;
        System.out.println("Bienvenido al Gestor de Tareas.");
        System.out.println("-------------------------------");
        while (optionSelected != 6){
            System.out.println("\u001B[34m");
            System.out.println("1) Crear Tarea");
            System.out.println("2) Eliminar Tarea");
            System.out.println("3) Modificar Tarea");
            System.out.println("4) Mostrar Tareas Simple");
            System.out.println("5) Mostrar Tareas Detallada");
            System.out.println("6) Salir"+"\u001B[0m");
            optionSelected = GetData.getInt("\u001B[32m"+"Ingrese una opción: "+"\u001B[0m",1,6);
            System.out.print("");
            switch (optionSelected){
                case 1 -> {
                    String name = GetData.getString("\u001B[36m"+"Ingrese el nombre de la tarea: "+"\u001B[0m");
                    String description = GetData.getString("\u001B[36m"+"Ingrese la descripción de la tarea: "+"\u001B[0m");
                    Task task = new Task(name,description);
                    taskList.addTask(task);
                }
                case 2 -> {
                    if (taskList.getSize() == 0){
                        System.out.println("No existen tareas");
                    } else {
                        taskList.showTasksSimple();
                        int index = GetData.getInt("\n\u001B[36m"+"Ingrese el número de la tarea a eliminar: "+"\u001B[0m",1,taskList.getSize());
                        boolean isRemoved = taskList.removeTask(--index);
                        if (isRemoved){
                            System.out.println("Se ha eliminado con éxito");
                        } else {
                            System.out.println("No se ha podido encontrar la tarea");
                        }
                    }

                }
                case 3 ->{
                    if (taskList.getSize() == 0){
                        System.out.println("No existen tareas");
                    } else {
                        taskList.showTasksSimple();
                        int index = GetData.getInt("\n\u001B[36m"+"Ingrese el número de la tarea a completar: "+"\u001B[0m",1,taskList.getSize());
                        boolean isModify = taskList.modifyTask(--index);
                        if (isModify){
                            System.out.println("Se ha modificado con éxito");
                        } else {
                            System.out.println("No se ha podido encontrar la tarea");
                        }
                    }

                }
                case 4 -> {
                    if (taskList.getSize() == 0){
                        System.out.println("No existen tareas");
                    } else {
                        taskList.showTasksSimple();
                    }
                }
                case 5 -> {
                    if (taskList.getSize() == 0){
                        System.out.println("No existen tareas");
                    } else {
                        taskList.showTasks();
                    }
                }
            }
        }
    }
}
