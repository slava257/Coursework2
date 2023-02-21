package Task1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    public WeeklyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsLn(LocalDate localDate) {
        LocalDate taskDate = this.getDateTime().toLocalDate();
        return localDate.equals(taskDate) || localDate.isAfter(taskDate) && localDate.getDayOfWeek().equals(localDate.getDayOfWeek());
    }

    @Override
    public Repeatability getRepeatability() {
        return Repeatability.WEEKLY;
    }
}