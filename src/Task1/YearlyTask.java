package Task1;

import java.time.LocalDateTime;

public class YearlyTask extends Task {
    public YearlyTask(int idGenerator, String title, Type type, int id, LocalDateTime dateTime, String description) {
        super(idGenerator, title, type, id, dateTime, description);
    }
    @Override
    public boolean appearsLn(LocalDateTime dateTime) {
        return false;
    }
}
