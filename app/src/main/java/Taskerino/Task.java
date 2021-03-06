package Taskerino;
import java.util.Scanner;

public class Task {
    //this gives instructions on how an object Task should look like
    public String name;
    public String project;
    public String date;
    //public boolean isTicked;


    public Task(String name, String project, String date) {
        this.name = name;
        this.project = project;
        this.date = date;
        //isTicked = true;
    }

    public static void askForName() {
        Scanner askName = new Scanner(System.in);
        System.out.println("Type task name:");
        String name = askName.nextLine();
    }
    public static void askForProject() {
        Scanner askProj = new Scanner(System.in);
        System.out.println("Type task project:");
        String project = askProj.nextLine();
    }
    public static void askForDate() {
        Scanner askDate = new Scanner(System.in);
        System.out.println("Type task due date:");
        String date = askDate.nextLine();
    }

    public void addTask() {
        Task task = new Task(this.name, this.project, this.date);
    }
    //setName
    //getName
    //setProject
    //getProject
    //setDate
    //getDate
    //setTicked
    //getTicked
}



