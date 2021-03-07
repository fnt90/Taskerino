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

    public String askForName() {
        Scanner askName = new Scanner(System.in);
        System.out.println("Type task name:");
        String name = askName.nextLine();
        return name;
    }
    public String askForProject() {
        Scanner askProj = new Scanner(System.in);
        System.out.println("Type task project:");
        String project = askProj.nextLine();
        return project;
    }
    public String askForDate() {
        Scanner askDate = new Scanner(System.in);
        System.out.println("Type task due date:");
        String date = askDate.nextLine();
        return date;
    }

    //public void addTask() {
        //Task task = new Task(this.name, this.project, this.date);
   // }
}
