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
//TaskList taskList;
    public void sorter(TaskList taskList){

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
        Collections.sort(arrayTaskList);
        int i = 0;
        while (i < arrayTaskList.size()) {
            Task printer2 = arrayTaskList.get(i);
            System.out.println((i + 1) +". " + printer2.name + ", " + printer2.project + ", " +  formatter.format(printer2.date) + ", " + printer2.boolToString());
            i++;
        }
    }
}
