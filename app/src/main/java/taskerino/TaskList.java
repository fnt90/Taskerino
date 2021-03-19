package taskerino;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.ArrayList;

/**
 * The TaskList class should create an ArrayList of Tasks which can be added to, deleted from, edited, displayed,
 * and saved to file.
 * @author Fiona Thompson
 * @version 1.0 (2021.03.18)
 */
public class TaskList {
    private ArrayList<Task> taskList;
    /**
     * ANSI escape codes corresponding to text formatting.
     */
    public static final String ANS_CLEAR = "[0m";
    public static final String ANS_BK_BLUE = "[30;44m";
    /**
     * Allows conversion of standard LocalDate format "YYYY-MM-DD" to a custom pattern "dd MMM".
     */
    public static DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("dd MMM")
            .parseDefaulting(ChronoField.YEAR, 2021)
            .toFormatter(Locale.US);

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void deleteTask(Task task) {
        taskList.remove(task);
    }

    public int size() {
        return taskList.size();
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public Task get(int index) {
        Task taskAtIndex = taskList.get(index);
        return taskAtIndex;
    }

    /**
     * Allows saving a new task name to an existing task object. Prints confirmation to user.
     * @param taskListSelect integer corresponding to the index within TaskList of user's selected task
     */
    public void changeName(int taskListSelect) {
        Task editName = taskList.get(taskListSelect);
        editName.setName(UserInput.askForName());
        System.out.println("Task name changed to: " + ANS_BK_BLUE + editName.name + ANS_CLEAR);
    }

    /**
     * Allows saving a new task project to an existing task object. Prints confirmation to user.
     * @param taskListSelect integer corresponding to the index within TaskList of user's selected task
     */
    public void changeProject(int taskListSelect) {
        Task editProject = taskList.get(taskListSelect);
        editProject.setProject(UserInput.askForProject());
        System.out.println("Task project changed to: " + ANS_BK_BLUE + editProject.project + ANS_CLEAR);
    }

    /**
     * Allows saving a new task date to an existing task object. Prints confirmation to user.
     * @param taskListSelect integer corresponding to the index within TaskList of user's selected task
     */
    public void changeDate(int taskListSelect) {
        Task editDate = taskList.get(taskListSelect);
        editDate.setDate(UserInput.askForDate());
        System.out.println("Task date changed to: " + ANS_BK_BLUE + formatter.format(editDate.date) + ANS_CLEAR);
    }

    /**
     * Allows flipping boolean value of ticked status from true to false, or from false to true.  Prints confirmation
     * to user in String form as "complete" or "incomplete".
     * @param taskListSelect integer corresponding to the index within TaskList of user's selected task
     */
    public void changeTicked(int taskListSelect) {
        Task editTickStatus = taskList.get(taskListSelect);
        if (!editTickStatus.getTickStatus()) {
            editTickStatus.setTicked(true);
        } else {
            editTickStatus.setTicked(false);
        }
        System.out.println("Task is now marked as: " + ANS_BK_BLUE + editTickStatus.boolToString() + ANS_CLEAR);
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    /**
     * Executes user choice to "Save & Quit" by saving taskList ArrayList. Prints 'Saving. . .' with delayed periods
     * to draw user attention, and throws InterruptedException in case of failure of Thread.sleep method.
     */
    public void saveTaskList() {
        try {
            System.out.print("Saving");
            Thread.sleep(500);
            System.out.print(" .");
            Thread.sleep(500);
            System.out.print(" .");
            Thread.sleep(500);
            System.out.println(" .");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Saving");
        }
        FileHandler saverFile = new FileHandler();
        saverFile.writeAsData(taskList);
    }

    /**
     * Executes loading of save file. Defines new ArrayList of Tasks for storage of saved tasks.
     * @return new ArrayList containing tasks loaded from save file
     */
    public ArrayList<Task> loadTaskList() {
        FileHandler loaderFile = new FileHandler();
        ArrayList<Task> dataList = new ArrayList<>();
        dataList = loaderFile.readAsData();
        return dataList;
    }
}
