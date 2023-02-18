package Task1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.Scanner;

import static Task1.Main.LOCAL_DATE;

public abstract class Task implements Comparable<Task> {
    private int counter = 0;
    private int idGenerator;
    private String title;
    private Type type;
    private int id;
    private LocalDateTime dateTime;
    private String description;
    private Repeatability repeatability;

    public Task(String title, Type type, LocalDateTime dateTime, String description) {

        this.title = title;
        this.type = type;
        this.id = counter++;
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

    public abstract Repeatability getRepeatability();


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

    public abstract boolean appearsLn(LocalDate localDate);

    @Override
    public int compareTo(Task otherTask) {
        if (otherTask == null) {
            return 1;
        }
        return this.dateTime.toLocalDate().compareTo(otherTask.dateTime.toLocalDate());
    }

    @Override
    public String toString() {
        return "Task{" + "idGenerator=" + idGenerator + ", title='" + title + '\'' + ", type=" + type + ", id=" + id + ", dateTime=" + dateTime + ", description='" + description + '\'' + '}';
    }
}