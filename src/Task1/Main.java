package Task1;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.Scanner;


public class Main {
    private static final TaskService TASK_SERVICE = new TaskService();

    protected static final DateTimeFormatter LOCAL_DATE = DateTimeFormatter.ofPattern("d.MM.yyyy");
    private static final DateTimeFormatter LOCAL_TIME = DateTimeFormatter.ofPattern("HH:mm");


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TASK_SERVICE.add(new OneTimeTask("OneTimeTest ", Type.WORK, LocalDateTime.now().plusHours(7), "Test"));
        TASK_SERVICE.add(new DailyTask(" рождения коллег", Type.WORK, LocalDateTime.now().plusHours(2), "поздравить с днём рождения"));
        TASK_SERVICE.add(new MonthlyTask("Паказание счетчиков", Type.PERSONAL, LocalDateTime.now().plusHours(4), "передать в управляющую компанию ежемесячное сведение показание счетчиков"));
        TASK_SERVICE.add(new YearlyTask("день рождения коллег", Type.WORK, LocalDateTime.now().plusHours(5), "поздравить с днём рождения"));
        add(scanner);
        printAllByDate(scanner);
        localizeResume(scanner);
        removeTasks(scanner);
    }

    private static void add(Scanner scanner) {
        String title = exceptionString("название задачи ", scanner);
        Type type = exceptionType(scanner);
        LocalDateTime dateTime = exceptionDateTime(scanner);
        String description = exceptionString("напиши описание", scanner);
        Repeatability repeatability = exceptionRepeatability(scanner);
        Task task = switch (repeatability) {
            case YEARLY -> new YearlyTask(title, type, dateTime, description);
            case WEEKLY -> new WeeklyTask(title, type, dateTime, description);
            case ONE_TAME -> new OneTimeTask(title, type, dateTime, description);
            case MONTHLY -> new MonthlyTask(title, type, dateTime, description);
            case DAILY -> new DailyTask(title, type, dateTime, description);
            default -> throw new IllegalArgumentException();
        };
        TASK_SERVICE.add(task);
    }

    public static String exceptionString(String message, Scanner scanner) {
        while (true) {

            System.out.println(message);
            String exceptionString = scanner.nextLine();
            if (exceptionString == null || exceptionString.isBlank()) {
                System.out.println("неверное значение ");
            } else {
                return exceptionString;
            }

        }
    }


    private static LocalDateTime exceptionDateTime(Scanner scanner) {
        LocalDate localDate = exceptionDate(scanner);
        LocalTime localTime = exceptionTime(scanner);
        return localDate.atTime(localTime);
    }

    private static void printAllByDate(Scanner scanner) {
        LocalDate localDate = exceptionDate(scanner);
        Collection<Task> tasksForDate = TASK_SERVICE.getTasksForDate(localDate);
        System.out.println("Задачи на " + localDate.format(LOCAL_DATE));
        for (Task task : tasksForDate) {
            System.out.printf("[%s]%s:%s (%s)%n", task.getTitle(), localizeType(task.getType()), task.getDateTime().format(LOCAL_TIME), task.getDescription());
        }

    }


    private static LocalDate exceptionDate(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Введите дату в формате d.MM.yyyy");
                String dateLine = scanner.nextLine();
                return LocalDate.parse(dateLine, LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("не верный формат");
            }
        }
    }

    private static LocalTime exceptionTime(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Введите дату в формате HH:mm");
                String dateLine = scanner.nextLine();
                return LocalTime.parse(dateLine, LOCAL_TIME);
            } catch (DateTimeParseException e) {
                System.out.println("не верный формат");
            }
        }
    }

    private static void removeTasks(Scanner scanner) {
        System.out.println("Все задачи");
        for (Task task : TASK_SERVICE.getAllTasks()) {
            System.out.printf(task.getTitle(), localizeType(task.getType()), task.getDateTime(), task.getDescription(), localizeRepeatability(task.getRepeatability()));
        }
        while (true) {
            try {
                System.out.println("Выберети задачу для удаления");
                String idLine = scanner.nextLine();
                int id = Integer.parseInt(idLine);
                TASK_SERVICE.remove(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("введено не верное значение");
            } catch (Task1.TaskNotFoundException е) {
                System.out.println("задача для удаления не найдено");
            }
        }
    }

    private static Repeatability exceptionRepeatability(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Выберети тип повторяймости задач");
                for (Repeatability repeatability : Repeatability.values()) {
                    System.out.println(repeatability.ordinal() + " " + localizeRepeatability(repeatability));
                }
                System.out.println("Введите тип");
                String ordinalLine = scanner.nextLine();
                int ordinal = Integer.parseInt(ordinalLine);
                return Repeatability.values()[ordinal];
            } catch (NumberFormatException e) {
                System.out.println("Введен неверный тип задачи");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Теп задач не найден");
            }
        }
    }

    private static Type exceptionType(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Выберети тип задачи");
                for (Type type : Type.values()) {
                    System.out.println(type.ordinal() + " " + localizeType(type));
                }
                System.out.println("Введите тип");
                String ordinalLain = scanner.nextLine();
                int ordinal = Integer.parseInt(ordinalLain);
                return Type.values()[ordinal];
            } catch (NumberFormatException e) {
                System.out.println("Веден не верный номер тип задач");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Тип задач не найден");
            }
        }
    }

    private static String localizeType(Type type) {
        return switch (type) {
            case WORK -> "Рабочая задача";
            case PERSONAL -> "Персональная задача";
        };
    }

    private static String localizeRepeatability(Repeatability repeatability) {
        return switch (repeatability) {
            case YEARLY -> "Ежегодная";
            case WEEKLY -> "Ежинедельная";
            case ONE_TAME -> "Разовая";
            case MONTHLY -> "Ежемесячная";
            case DAILY -> "Ежедневная";

        };
    }

    private static Resume resume(Scanner scanner) {
        while (true) {
            try {
                System.out.println("продолжить работу ?");
                for (Resume resume : Resume.values()) {
                    System.out.println(resume.ordinal() + " " + localizeResume1(resume));
                }
                System.out.println("Введите команду");
                String ordinalLain = scanner.nextLine();
                int ordinal = Integer.parseInt(ordinalLain);
                return Resume.values()[ordinal];
            } catch (NumberFormatException e) {
                System.out.println("Веден не верная команда");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Команда не найден");
            }
        }
    }

    private static String localizeResume1(Resume resume) {
        return switch (resume) {
            case RESUME -> "Продолжить";
            case DELETE_A_TASK -> "Удалить задачу";
            case EXIT -> "Завершить";
        };
    }

    private static void localizeResume(Scanner scanner) {
        while (true) {
            System.out.println("Введите команду");
            switch (resume(scanner)) {
                case RESUME -> add(scanner);
                case DELETE_A_TASK -> removeTasks(scanner);
                default -> throw new IllegalArgumentException("пока");
            }
        }
    }
}