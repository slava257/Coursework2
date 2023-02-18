package Task1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsLn(LocalDate dateTime) {
        LocalDate taskDate = this.getDateTime().toLocalDate();
        return dateTime.equals(taskDate) || dateTime.isAfter(taskDate) && dateTime.getDayOfMonth() == taskDate.getDayOfMonth();
    }

    @Override
    public Repeatability getRepeatability() {
        return Repeatability.MONTHLY;
    }
}