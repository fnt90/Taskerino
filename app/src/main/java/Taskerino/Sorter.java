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
}
