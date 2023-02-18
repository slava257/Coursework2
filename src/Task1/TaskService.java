package Task1;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class TaskService {
    private final Map<Integer, Task> tasks = new HashMap<>();
    private Collection<Task> removedTask;


    public void add(Task task) {
        this.tasks.put(task.getId(), task);

    }


    public void remove(int id) throws Task1.TaskNotFoundException {
        if (this.tasks.containsKey(id)) {
            this.tasks.remove(id);
        } else {
            throw new Task1.TaskNotFoundException();
        }
    }

    public Collection<Task> getAllTasks() {
        return this.tasks.values();
    }


    public Collection<Task> getTasksForDate(LocalDate date) {
        TreeSet<Task> taskForDate = new TreeSet<>();
        for (Task task : tasks.values()) {
            if (task.appearsLn(date)) {
                taskForDate.add(task);
            }
        }
        return taskForDate;
    }


    private class TaskNotFoundException extends Exception {
    }
}

