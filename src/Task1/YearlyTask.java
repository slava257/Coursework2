package Task1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {
    public YearlyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsLn(LocalDate date) {
        LocalDate taskDate = this.getDateTime().toLocalDate();
        return date.equals(taskDate) || date.isAfter(taskDate) && date.getDayOfMonth() == date.getDayOfMonth() &&
                date.getMonth().equals(taskDate.getMonth());
    }

    @Override
    public Repeatability getRepeatability() {
        return Repeatability.YEARLY;
    }
}