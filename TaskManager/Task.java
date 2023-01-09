package TaskManager;

public class Task {
    private String name;
    private String description;
    private boolean isComplete = false;

    public Task(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public String getName() {
        return this.name;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public String getDescription() {
        return description;
    }


}
