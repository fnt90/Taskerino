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
    public static final String ANS_YELLOW = "[38;5;185m";
    public static DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("dd MMM")
            .parseDefaulting(ChronoField.YEAR, 2021)
            .toFormatter(Locale.US);

    public void printAllTasks(TaskList taskList) {
        //show all saved tasks in the order they were added
        int index = 0;
        while (index < taskList.size()) {
            Task printer = taskList.get(index);
            String taskStatus = printer.boolToString();
            System.out.print((index + 1) + ". " + printer.name + ", " + printer.project + ", " +
                    formatter.format(printer.date) + ", ");
            //if statement to print incomplete in blue, but complete in normal colour
            if (taskStatus.equals("incomplete")) {
                System.out.print(ANS_BLUE + "incomplete" + ANS_CLEAR + "\n");
            } else {
                System.out.print("complete" + "\n");
            }
            index++;
        }
    }

    public void printByStatus(TaskList taskList) {
        //show all saved tasks incomplete first, then complete
        System.out.println(ANS_YELLOW + "Here are all your saved tasks (incomplete first):" + ANS_CLEAR);
        //print all incomplete tasks
        int indexIncomplete = 0;
        int displayIndex = 1;
        while(indexIncomplete < taskList.size()) {
            Task printer = taskList.get(indexIncomplete);
            String taskStatus = printer.boolToString();
            if (taskStatus.equals("incomplete")) {
                System.out.println(displayIndex +". " + printer.name + ", " + printer.project + ", " +
                        formatter.format(printer.date) + ", " + ANS_BLUE + printer.boolToString()+ ANS_CLEAR);
                displayIndex++;
            }
            indexIncomplete++;
        }
        //print all complete tasks
        int indexComplete = 0;
        while(indexComplete < taskList.size()) {
            Task printer = taskList.get(indexComplete);
            String taskStatus = printer.boolToString();
            if (taskStatus.equals("complete")) {
                System.out.println(displayIndex+". " + printer.name + ", " + printer.project + ", " +
                        formatter.format(printer.date) + ", " + printer.boolToString());
                displayIndex++;
            }
            indexComplete++;
        }
    }

    public void sortByProj(TaskList taskList){
        //place all tasks from taskList into a List of tasks to enable sorting by comparator
        List<Task> arrayTaskList = new ArrayList<>();
        int index = 0;
        while(index < taskList.size()) {
            Task printer = taskList.get(index);
            arrayTaskList.add(printer);
            index++;
        }
        //sort by project using custom comparator
        Collections.sort(arrayTaskList, Task.taskProjComparator);
        System.out.println(ANS_YELLOW + "Here are all your saved tasks (by project A-Z):" + ANS_CLEAR);
        int i = 0;
        while (i < arrayTaskList.size()) {
            Task printer2 = arrayTaskList.get(i);
            System.out.println((i + 1) +". " + printer2.name + ", " + ANS_BLUE + printer2.project + ANS_CLEAR + ", " +
                    formatter.format(printer2.date) + ", " + printer2.boolToString());
            i++;
        }
    }
    public void sortByDate(TaskList taskList){
        //place all tasks from taskList into a List of tasks to enable sorting by comparator
        List<Task> arrayTaskList = new ArrayList<>();
        int index = 0;
        while(index < taskList.size()) {
            Task printer = taskList.get(index);
            arrayTaskList.add(printer);
            index++;
        }
        //sort by date using custom comparator
        Collections.sort(arrayTaskList, Task.taskDateComparator);
        System.out.println(ANS_YELLOW + "Here are all your saved tasks (by date):" + ANS_CLEAR);
        int i = 0;
        while (i < arrayTaskList.size()) {
            Task printer2 = arrayTaskList.get(i);
            System.out.println((i + 1) +". " + printer2.name + ", " + printer2.project  + ", " + ANS_BLUE +
                    formatter.format(printer2.date) + ANS_CLEAR + ", " + printer2.boolToString());
            i++;
        }
    }
    public void overdueTasks(TaskList taskList) {
        //show how many tasks have a due date of Today and due date of earlier than today
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

    public void makeJudgementOnTasks(TaskList taskList) {
        //count complete and incomplete tasks, print judgement message based on result
        int tasksDone = 0;
        int tasksNotDone;
        for (Task task : taskList.getTaskList()) {
            if (task.isTicked) {
                tasksDone++;
            }
        }
        //counted completed tasks, so incomplete tasks = total - completed
        tasksNotDone = taskList.size() - tasksDone;
        System.out.println("You've completed " + ANS_YELLOW + tasksDone + ANS_CLEAR + " task(s), and you've got " +
                ANS_YELLOW + tasksNotDone + ANS_CLEAR + " task(s) to go.");
        //choose which judgement message to print
        if (tasksDone > tasksNotDone) {
            Messages.printJudgementGood();
        } else if (tasksDone == tasksNotDone) {
            Messages.printJudgementNeutral();
        } else {
            Messages.printJudgementBad();
        }
    }
}
