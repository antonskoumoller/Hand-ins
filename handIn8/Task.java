/**
 * Task
 */
public class Task {
    private String description;
    private int priority;
    private int workload;
    private String priorityString;

    
    public Task(String description, int priority, int workload) {
        switch (priority) {
            case 1:
                priorityString = "very important";
                break;
            case 2:
                priorityString = "important";
                break;
            case 3:
                priorityString = "unimportant";
                break;
            case 4:
                priorityString = "after learn Portuguese";
                break;
            default:
                throw new IllegalArgumentException(description + " has invalid priority");
        }
        
        if (workload < 0) {
            throw new IllegalArgumentException(description + " has invalid workload");
        }
        
        this.description = description;
        this.priority = priority;
        this.workload = workload;

        

    }

    public String toString() {
        return description + " takes " + workload + " minutes and has priority " + priorityString;
    }

    public int getWorkload() {
        return workload;
    }

    public int getPriority() {
        return priority;
    }
}