import java.util.HashMap;
import java.util.Map;

/**
 * Task
 */
public class Task {
    private String description;
    private int priority;
    private int workload;

    Map<Integer,String> priorityMap;

    
    public Task(String description, int priority, int workload) throws Exception {
        if (priority < 1 || priority > 4) {
            throw new InvalidInputException(description + " has invalid priority");
        }
        if (workload < 0) {
            throw new InvalidInputException(description + " has invalid workload");
        }
        
        this.description = description;
        this.priority = priority;
        this.workload = workload;
        priorityMap = new HashMap<>();
        priorityMap.put(1,"very important");
        priorityMap.put(2,"important");
        priorityMap.put(3,"unimportant");
        priorityMap.put(4,"after learn Portuguese");
        

    }

    public String toString() {
        return description + " takes " + workload + " and has priority " + priorityMap.get(priority);
    }

    public int getWorkload() {
        return workload;
    }

    public int getPriority() {
        return priority;
    }
}