import java.util.ArrayList;
import java.util.List;

public class Todo {
    List<Task> todo;
    int workDone = 0;
    
    public Todo() {
        todo = new ArrayList<>();
    }


    public void addTask(String description, int priority, int workload) throws Exception {
        try {
            Task task = new Task(description,priority,workload);
            todo.add(task);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
        

    }

    public void print() {
        if (todo.isEmpty()) {
            System.out.println("You're all done for today! #TodoZero");
            return;
        }
        
        System.out.println("Todo:\n-----");
        for (Task task : todo) {
            System.out.println(task.toString());
        }

        if (workDone > 0) {
            System.out.println(workDone + " minutes of work done!");
        }
    }

    public void completeTask(int index) {
        int workload = todo.get(index).getWorkload();
        workDone += workload;
        todo.remove(index);
    }

    public void printPriority(int limit) {
        boolean tasksPrinted = false;
        for (Task task : todo) {
            if (task.getPriority() > limit) {
                if (!tasksPrinted) System.out.println("Filtered todo:\n--------------");
                System.out.println(task.toString());
                tasksPrinted = true;
            }
        }

        if (!tasksPrinted) System.out.println("No tasks with given priority");

    }

}
