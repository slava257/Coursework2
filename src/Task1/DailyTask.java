package Task1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {
    public DailyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsLn(LocalDate dateTime) {
        LocalDate date = this.getDateTime().toLocalDate();
        return dateTime.equals(date) || dateTime.isAfter(date);
    }

    @Override
    public Repeatability getRepeatability() {
        return Repeatability.DAILY;
    }
}