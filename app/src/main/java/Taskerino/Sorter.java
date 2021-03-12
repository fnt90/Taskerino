package Taskerino;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Sorter {
    public static final String ansClear = "\u001B[0m";
    public static final String ansBlue = "\u001B[34m";

    public void sorterProj(TaskList taskList){

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("dd MMM")
                .parseDefaulting(ChronoField.YEAR, 2021)
                .toFormatter(Locale.US);

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
            System.out.println((i + 1) +". " + printer2.name + ", " + ansBlue + printer2.project + ansClear + ", " +  formatter.format(printer2.date) + ", " + printer2.boolToString());
            i++;
        }
    }
    public void sorterDate(TaskList taskList){

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("dd MMM")
                .parseDefaulting(ChronoField.YEAR, 2021)
                .toFormatter(Locale.US);

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
            System.out.println((i + 1) +". " + printer2.name + ", " + printer2.project  + ", " + ansBlue + formatter.format(printer2.date) + ansClear + ", " + printer2.boolToString());
            i++;
        }
    }
    public void overdueTasks(TaskList taskList) {
        /* count how many tasks TRUE (complete) using variable int tasksDone
         ** count how many tasks FALSE (incomplete) using variable int tasksNotDone
         ** loop for each saved task. If task.isTicked returns true (is complete), augment tasksDone by 1

        int tasksDone = 0;
        int tasksNotDone;
        for (Task task : taskList.getTaskList()) {
            if (task.isTicked) {
                tasksDone++;
            }
        }
        //counted completed tasks, so incomplete tasks = total - completed
        tasksNotDone = taskList.size() - tasksDone;
        System.out.println("You've completed " + ansYellow + tasksDone + ansClear + " tasks, and you've got " + ansYellow + tasksNotDone + ansClear + " tasks to go.");
        //choose which judgement message to print

         */
        int numOverdue = 0;
        int numDue = 0;
        //int numNotDue;

        for (Task task : taskList.getTaskList()) {
            if (task.getDate().equals(LocalDate.now())) {
                numDue++;
            } else if (task.getDate().isBefore((LocalDate.now()))){
                numOverdue++;
            }
        }
        //numNotDue = taskList.size() - numOverdue - numDue;
        System.out.println("You have " + numDue + " tasks due today, and " + numOverdue + " overdue tasks.");
    }
}