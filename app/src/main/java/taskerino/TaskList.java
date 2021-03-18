package taskerino;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    //this should be an array list of Task objects, and the list is called taskList
    private ArrayList<Task> taskList;
    //int taskSelect;
    //for formatting text and clearing formatting
    public static final String ANS_YELLOW = "[38;5;185m";
    public static final String ANS_CLEAR = "[0m";
    public static final String ANS_BOLD = "[1m";
    public static final String ANS_BK_BLUE = "[30;44m";
    public static DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("dd MMM")
            .parseDefaulting(ChronoField.YEAR, 2021)
            .toFormatter(Locale.US);

    //Menus menus = new Menus();


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

    public static String askName() {
        //Prompts user to input name, either when adding new task or selecting Edit Name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type new task " + ANS_BOLD + "name" + ANS_CLEAR + ":");
        String name = scanner.nextLine();
        //If user does not type a name, replace blank with **Untitled**
        if (name.length()==0) {
            return "**Untitled**";
        }

        return name;
    }
    public static String askProj() {
        //Prompts user to input project, either when adding new task or selecting Edit Project
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type new task " + ANS_BOLD + "project" + ANS_CLEAR + ":");
        String project = scanner.nextLine();
        return project;
    }
    public static LocalDate askDate() {
        //Prompts user to input due date, either when adding new task or selecting Edit Date
        Scanner askDate = new Scanner(System.in);

        /*DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("dd MMM")
                .parseDefaulting(ChronoField.YEAR, 2021)
                .toFormatter(Locale.US);
*/
        System.out.println("Type new task " + ANS_BOLD + "due date " + ANS_YELLOW + "(DD Mmm/04 Oct)" + ANS_CLEAR + ":");
        //try block to check if date correctly formatted, if not, automatically set to today's date
        try {
            LocalDate date = LocalDate.parse(askDate.nextLine(), formatter);
            return date;
        } catch (DateTimeException e) {
            System.out.println("Invalid date entered (or you didn't capitalize month). " + ANS_YELLOW +
                    "Setting due date to " + ANS_BOLD + "today." + ANS_CLEAR);
            LocalDate date = LocalDate.now();
            return date;
        }
    }

    public void changeName(int taskListSelect) {
        Task editableName = taskList.get(taskListSelect); //this is NOT working
        editableName.setName(askName());
        System.out.println("Task name changed to: " + ANS_BK_BLUE + editableName.name + ANS_CLEAR);
    }

    public void changeProj(int taskListSelect) {
        Task editableProj = taskList.get(taskListSelect);
        editableProj.setProject(askProj());
        System.out.println("Task project changed to: " + ANS_BK_BLUE + editableProj.project + ANS_CLEAR);
    }
    public void changeDate(int taskListSelect) {
        Task editableDate = taskList.get(taskListSelect);
        editableDate.setDate(askDate());
        System.out.println("Task date changed to: " + ANS_BK_BLUE + formatter.format(editableDate.date) + ANS_CLEAR);
    }
    public void changeTicked(int taskListSelect) {
        Task editableTick = taskList.get(taskListSelect);
        if (editableTick.getTickStatus() == false) {
            editableTick.setTicked(true);
        } else {
            editableTick.setTicked(false);
        }
        System.out.println("Task is now marked as: " + ANS_BK_BLUE + editableTick.boolToString() + ANS_CLEAR);
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public void saveMethod() {
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

    public ArrayList<Task> loadMethod() {
        FileHandler loaderFile = new FileHandler();
        ArrayList<Task> dataList = new ArrayList<>();
        dataList = loaderFile.readAsData();
        return dataList;
    }

}
