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

    //for formatting text and clearing formatting
    public static final String ANS_CLEAR = "[0m";
    public static final String ANS_BK_BLUE = "[30;44m";
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
        Task getIndexVal = taskList.get(index);
        return getIndexVal;
    }

    public void changeName(int taskListSelect) {
        Task editName = taskList.get(taskListSelect);
        editName.setName(UserInput.askForName());
        System.out.println("Task name changed to: " + ANS_BK_BLUE + editName.name + ANS_CLEAR);
    }

    public void changeProject(int taskListSelect) {
        Task editProject = taskList.get(taskListSelect);
        editProject.setProject(UserInput.askForProject());
        System.out.println("Task project changed to: " + ANS_BK_BLUE + editProject.project + ANS_CLEAR);
    }
    public void changeDate(int taskListSelect) {
        Task editDate = taskList.get(taskListSelect);
        editDate.setDate(UserInput.askForDate());
        System.out.println("Task date changed to: " + ANS_BK_BLUE + formatter.format(editDate.date) + ANS_CLEAR);
    }
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

    public void saveTaskList() {
        //print 'Saving. . .' with delayed periods to draw user attention
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

    public ArrayList<Task> loadTaskList() {
        FileHandler loaderFile = new FileHandler();
        ArrayList<Task> dataList = new ArrayList<>();
        dataList = loaderFile.readAsData();
        return dataList;
    }
}
