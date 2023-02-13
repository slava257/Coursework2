package Task1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;



public class TaskService extends Task {
    private Map<Integer, Task> taskMap;
    private Collection<Task> removedTask;


    List<Task> list = new ArrayList<>();
    Task indicationOfUtilityMeters = new Task(1, "Паказание счетчиков", Type.PERSONAL, 1, LocalDateTime.now(), "передать в управляющую компанию ежемесячное сведение показание счетчиков") {
        @Override
        public boolean appearsLn(LocalDateTime dateTime) {
            return false;
        }
    };

    Task colleaguesBirthday = new Task(2, "день рождения коллег", Type.WORK, 2, LocalDateTime.of(2013, 1, 24, 0, 0), "поздравить с днём рождения") {
        @Override
        public boolean appearsLn(LocalDateTime dateTime) {
            return false;
        }
    };

    public TaskService(int idGenerator, String title, Type type, int id, LocalDateTime dateTime, String description) {
        super(idGenerator, title, type, id, dateTime, description);
    }


    public void add(Task task) {
        list.add(task);

    }


    public Task remove(int id, Task task) {
        list.remove(id);
        return task;
    }

    @Override
    public boolean appearsLn(LocalDateTime dateTime) {
        return false;
    }


    // public ArrayList<Task> getAllByDate(LocalDateTime localDate) {
   // for () {
         // System.out.println(l);
       //  }
       //  }
       //  return null;
       // }

}