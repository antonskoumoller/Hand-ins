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

    public void printPrioritized() {
        // Fix the sorting with workload, then it's done.
        List<Task> sortedTasks = new ArrayList<>();
        System.out.println("Prioritized todo:\n-----------------");
        sortedTasks = todo;
        int i = 1;
        while(i < todo.size()) {
            if(todo.get(i-1).getPriority() > todo.get(i).getPriority()) {
                Task temp = sortedTasks.remove(i);
                sortedTasks.add(i-1, temp);
                if (i != 1) {
                    i--;
                }
            } else {
                i++;
            }
        }
        i = 1;
        while (i < sortedTasks.size()) {
            if (sortedTasks.get(i).getPriority() == sortedTasks.get(i-1).getPriority() && sortedTasks.get(i).getWorkload() < sortedTasks.get(i-1).getWorkload()) {
                Task temp = sortedTasks.remove(i-1);
                sortedTasks.add(i, temp);
                if (i != 1) i--;
            } else {
                i++;
            }
        }

        for (Task task : sortedTasks) {
            System.out.println(task.toString());  
        }
    }


}
