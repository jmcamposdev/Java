package TaskManager;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> taskArrayList;

    public TaskList(){
        taskArrayList = new ArrayList<>();
    }

    public void addTask(Task task){
        taskArrayList.add(task);
    }

    public boolean removeTask(int removeIndex){
        boolean isRemoved = false;
        if (!taskArrayList.isEmpty() && removeIndex >= 0 && removeIndex <= taskArrayList.size()){
            taskArrayList.remove(removeIndex);
            isRemoved = true;
        }
        return isRemoved;
    }

    public boolean modifyTask(int index){
        boolean isModify = false;
        if (!taskArrayList.isEmpty() && index >= 0 && index <= taskArrayList.size()){
            taskArrayList.get(index).setComplete(!taskArrayList.get(index).isComplete());
            isModify = true;
        }
        return isModify;
    }

    public void showTasks(){
        System.out.println("\n-------------------------");
        int indice = 1;
        for (Task task : taskArrayList) {
            if (task.isComplete()){
                System.out.println(indice++ +") "+"\033[0;32m"+task.getName()+"\033[0m"+": "+task.getDescription());
            } else {
                System.out.println(indice++ +") "+task.getName()+": "+task.getDescription());
            }
        }
    }
    public void showTasksSimple(){
        System.out.println("\n-------------------------");
        int indice = 1;
        for (Task task : taskArrayList) {
            if (task.isComplete()){
                System.out.println(indice++ +") "+"\033[0;32m"+task.getName()+"\033[0m");
            } else {
                System.out.println(indice++ +") "+task.getName());
            }
        }
        System.out.println("-------------------------");
    }

    public int getSize(){
        return taskArrayList.size();
    }
}
