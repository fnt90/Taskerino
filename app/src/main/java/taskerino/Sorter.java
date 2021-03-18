package taskerino;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * The Sorter class handles methods for displaying and sorting Task objects. This includes printing all tasks,
 * printing sorted tasks, and counting tasks using parameters such as tick status or due date.
 * @author Fiona Thompson
 * @version 1.0 (2021.03.18)
 */
public class Sorter {
    /**
     * ANSI escape codes corresponding to text formatting.
     */
    public static final String ANS_CLEAR = "[0m";
    public static final String ANS_BLUE = "[34m";
    public static final String ANS_YELLOW = "[38;5;185m";
    /**
     * Allows conversion of standard LocalDate format "YYYY-MM-DD" to a custom pattern "dd MMM".
     */
    public static DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("dd MMM")
            .parseDefaulting(ChronoField.YEAR, 2021)
            .toFormatter(Locale.US);

    /**
     * Prints all saved tasks in the order they were added. Formats stored date to custom format for readability.
     * Identifies incomplete tasks to print "incomplete" in blue text, but "complete" in plain text.
     * @param taskList ArrayList of user's saved to-do tasks
     */
    public void printAllTasks(TaskList taskList) {
        int index = 0;
        while (index < taskList.size()) {
            Task printer = taskList.get(index);
            String taskStatus = printer.boolToString();
            System.out.print((index + 1) + ". " + printer.name + ", " + printer.project + ", " +
                    formatter.format(printer.date) + ", ");
            if (taskStatus.equals("incomplete")) {
                System.out.print(ANS_BLUE + "incomplete" + ANS_CLEAR + "\n");
            } else {
                System.out.print("complete" + "\n");
            }
            index++;
        }
    }

    /**
     * Prints all tasks with "incomplete" status first, with "incomplete" in blue text. Next, prints all tasks with
     * "complete" status. Assigns a display index to number each printed task. Formats stored date to custom format
     * "dd MMM" for readability.
     * @param taskList ArrayList of user's saved to-do tasks
     */
    public void printByStatus(TaskList taskList) {
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

    /**
     * Prints all tasks by the alphabetical sorting of their project value. Assigns a display index to number each
     * printed task. Formats stored date to custom format "dd MMM" for readability. Formats project in blue text to
     * highlight sorted status.
     * @param taskList ArrayList of user's saved to-do tasks
     */
    public void sortByProj(TaskList taskList){
        //place all tasks from taskList into a List of tasks to enable sorting by comparator
        List<Task> arrayTaskList = new ArrayList<>();
        int index = 0;
        while(index < taskList.size()) {
            Task taskBeforeSort = taskList.get(index);
            arrayTaskList.add(taskBeforeSort);
            index++;
        }
        //sort by project using custom comparator
        Collections.sort(arrayTaskList, Task.taskProjComparator);
        System.out.println(ANS_YELLOW + "Here are all your saved tasks (by project A-Z):" + ANS_CLEAR);
        int indexList = 0;
        while (indexList < arrayTaskList.size()) {
            Task taskSorted = arrayTaskList.get(indexList);
            System.out.println((indexList + 1) +". " + taskSorted.name + ", " + ANS_BLUE + taskSorted.project + ANS_CLEAR + ", " +
                    formatter.format(taskSorted.date) + ", " + taskSorted.boolToString());
            indexList++;
        }
    }

    /**
     * Prints all tasks by oldest past date to farthest future date. Assigns a display index to number each
     * printed task. Formats stored date to custom format "dd MMM" for readability. Formats date in blue text to
     * highlight sorted status.
     * @param taskList ArrayList of user's saved to-do tasks
     */
    public void sortByDate(TaskList taskList){
        //place all tasks from taskList into a List of tasks to enable sorting by comparator
        List<Task> arrayTaskList = new ArrayList<>();
        int index = 0;
        while(index < taskList.size()) {
            Task taskBeforeSort = taskList.get(index);
            arrayTaskList.add(taskBeforeSort);
            index++;
        }
        //sort by date using custom comparator
        Collections.sort(arrayTaskList, Task.taskDateComparator);
        System.out.println(ANS_YELLOW + "Here are all your saved tasks (by date):" + ANS_CLEAR);
        int indexList = 0;
        while (indexList < arrayTaskList.size()) {
            Task taskSorted = arrayTaskList.get(indexList);
            System.out.println((indexList + 1) +". " + taskSorted.name + ", " + taskSorted.project  + ", " + ANS_BLUE +
                    formatter.format(taskSorted.date) + ANS_CLEAR + ", " + taskSorted.boolToString());
            indexList++;
        }
    }

    /**
     * Counts all saved tasks with today's date as due date, counts all saved tasks with due date before today. Prints
     * to notify user of number of tasks due today, and number tasks overdue.
     * @param taskList ArrayList of user's saved to-do tasks
     */
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

    /**
     * Counts all tasks by ticked status. If user has more incomplete tasks, prints negative judgement message. If
     * user has more complete tasks, prints positive judgement message. If user has equal number of incomplete and
     * complete tasks (or no saved tasks, as 0 is equal to 0), prints neutral judgement message.
     * @param taskList ArrayList of user's saved to-do tasks
     */
    public void makeJudgementOnTasks(TaskList taskList) {
        //count complete tasks
        int tasksDone = 0;
        int tasksNotDone;
        for (Task task : taskList.getTaskList()) {
            if (task.isTicked) {
                tasksDone++;
            }
        }
        //incomplete tasks = total tasks - completed tasks
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
