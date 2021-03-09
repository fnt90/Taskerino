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
        System.out.println("Type new task name:");
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
        System.out.println("Type new task project:");
        String project = askProj.nextLine();
        return project;
    }
    public static String askForDate() {
        //Prompts user to input due date, either when adding new task or selecting Edit Date
        Scanner askDate = new Scanner(System.in);
        System.out.println("Type new task due date:");
        String date = askDate.nextLine();
        return date;
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
}
