package taskerino;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Sorter {
    public static final String ANS_CLEAR = "[0m";
    public static final String ANS_BLUE = "[34m";
    public static DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("dd MMM")
            .parseDefaulting(ChronoField.YEAR, 2021)
            .toFormatter(Locale.US);

    public void sorterProj(TaskList taskList){

        /*DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("dd MMM")
                .parseDefaulting(ChronoField.YEAR, 2021)
                .toFormatter(Locale.US);
*/
        List<Task> arrayTaskList = new ArrayList<Task>();
        int index = 0;
        while(index < taskList.size()) {
            Task printer = taskList.get(index);
            arrayTaskList.add(printer);
            index++;

        }
        Collections.sort(arrayTaskList, Task.taskProjComparator);
        int i = 0;
        while (i < arrayTaskList.size()) {
            Task printer2 = arrayTaskList.get(i);
            System.out.println((i + 1) +". " + printer2.name + ", " + ANS_BLUE + printer2.project + ANS_CLEAR + ", " +
                    formatter.format(printer2.date) + ", " + printer2.boolToString());
            i++;
        }
    }
    public void sorterDate(TaskList taskList){

        /*DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("dd MMM")
                .parseDefaulting(ChronoField.YEAR, 2021)
                .toFormatter(Locale.US);
*/
        List<Task> arrayTaskList = new ArrayList<Task>();
        int index = 0;
        while(index < taskList.size()) {
            Task printer = taskList.get(index);
            arrayTaskList.add(printer);
            index++;

        }
        Collections.sort(arrayTaskList, Task.taskDateComparator);
        int i = 0;
        while (i < arrayTaskList.size()) {
            Task printer2 = arrayTaskList.get(i);
            System.out.println((i + 1) +". " + printer2.name + ", " + printer2.project  + ", " + ANS_BLUE +
                    formatter.format(printer2.date) + ANS_CLEAR + ", " + printer2.boolToString());
            i++;
        }
    }
    public void overdueTasks(TaskList taskList) {

        int numOverdue = 0;
        int numDue = 0;

        for (Task task : taskList.getTaskList()) {
            if (task.getDate().equals(LocalDate.now())) {
                numDue++;
            } else if (task.getDate().isBefore((LocalDate.now()))){
                numOverdue++;
            }
        }

        System.out.println("You have " + numDue + " tasks due today, and " + numOverdue + " overdue tasks.");
    }
}
