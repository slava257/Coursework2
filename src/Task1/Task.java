package Task1;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task    {
    private int idGenerator;
    private String title;
    private Type type;
    private int id;
    private LocalDateTime dateTime;
    private String description;

    public Task(int idGenerator, String title, Type type, int id, LocalDateTime dateTime, String description) {
        this.idGenerator = idGenerator;
        this.title = title;
        this.type = type;
        this.id = this.id;
        this.dateTime = dateTime;
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return idGenerator == task.idGenerator && id == task.id && title.equals(task.title) && type.equals(task.type) && dateTime.equals(task.dateTime) && description.equals(task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenerator, title, type, id, dateTime, description);
    }

    public abstract boolean appearsLn(LocalDateTime dateTime);

    @Override
    public String toString() {
        return "Task{" +
                "idGenerator=" + idGenerator +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }


}