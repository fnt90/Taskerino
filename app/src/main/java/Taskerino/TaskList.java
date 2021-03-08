package Taskerino;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    //this should be an array list of Task objects, and the list is called taskList
    private ArrayList<Task> taskList;

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

    public Task get(int index) {
        //int index = 0;
        Task getIndexVal = taskList.get(index);
        return getIndexVal;
    }

    public static String askForName() {
        Scanner askName = new Scanner(System.in);
        System.out.println("Type task name:");
        String name = askName.nextLine();
        if (name.length()==0) {
            return "**Untitled**";
        }

        return name;
    }
    public static String askForProject() {
        Scanner askProj = new Scanner(System.in);
        System.out.println("Type task project:");
        String project = askProj.nextLine();
        return project;
    }
    public static String askForDate() {
        Scanner askDate = new Scanner(System.in);
        System.out.println("Type task due date:");
        String date = askDate.nextLine();
        return date;
    }


}
