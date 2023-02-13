package Task1;

import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(int idGenerator, String title, Type type, int id, LocalDateTime dateTime, String description) {
        super(idGenerator, title, type, id, dateTime, description);
    }

    @Override
    public boolean appearsLn(LocalDateTime dateTime) {
       return true;
        }
}
