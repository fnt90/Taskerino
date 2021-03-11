package Taskerino;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TaskList {
    //this should be an array list of Task objects, and the list is called taskList
    private ArrayList<Task> taskList;

    //for formatting text and clearing formatting
    public static final String ansBold = "\u001b[1m";
    public static final String ansClear = "\u001B[0m";
    public static final String ansYellow = "\u001B[33m";

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

    public static String askForName() {
        //Prompts user to input name, either when adding new task or selecting Edit Name
        Scanner askName = new Scanner(System.in);
        System.out.println("Type new task " + ansBold + "name" + ansClear + ":");
        String name = askName.nextLine();
        //If user does not type a name, replace blank with **Untitled**
        if (name.length()==0) {
            return "**Untitled**";
        }

        return name;
    }
    public static String askForProject() {
        //Prompts user to input project, either when adding new task or selecting Edit Project
        Scanner askProj = new Scanner(System.in);
        System.out.println("Type new task " + ansBold + "project" + ansClear + ":");
        String project = askProj.nextLine();
        return project;
    }
    public static LocalDate askForDate() {
        //Prompts user to input due date, either when adding new task or selecting Edit Date
        Scanner askDate = new Scanner(System.in);

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("dd MMM")
                .parseDefaulting(ChronoField.YEAR, 2021)
                .toFormatter(Locale.US);

        System.out.println("Type new task " + ansBold + "due date " + ansYellow + "(DD Mmm/04 Oct)" + ansClear + ":");
        //try block to check if date correctly formatted, if not, automatically set to today's date
        try {
            LocalDate date = LocalDate.parse(askDate.nextLine(), formatter);
            return date;
        } catch (DateTimeException e) {
            System.out.println("Invalid date entered (or you didn't capitalize month). " + ansYellow + "Setting due date to " + ansBold + "today." + ansClear);
            LocalDate date = LocalDate.now();
            return date;
        }
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public void saveMethod() {
        FileHandlerObj saverFile = new FileHandlerObj();
        saverFile.writeAsObject(taskList);
    }

    public ArrayList<Task> loadMethod() {
        FileHandlerObj loaderFile = new FileHandlerObj();
        ArrayList<Task> objList = new ArrayList<>();
        objList = loaderFile.readAsObject();
        return objList;
    }

    //public void sort(Comparator<Task> taskProjComparator) {
    //}
}
