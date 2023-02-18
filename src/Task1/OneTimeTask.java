package Task1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task{
    public OneTimeTask( String title, Type type, LocalDateTime dateTime, String description) {
        super( title, type,  dateTime, description);
    }

    @Override
    public boolean appearsLn(LocalDate localDate) {
        return localDate.equals(this.getDateTime().toLocalDate());
    }

    @Override
    public Repeatability getRepeatability() {
        return Repeatability.ONE_TAME;
    }
}
