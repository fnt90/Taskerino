package Taskerino;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    //public String name;
//public String project;
//public String date;
    public static void main(String[] args) {
        // write comment
        Scanner menuSelector = new Scanner(System.in);

        Messages.welcomeMsg();
        Messages.taskSummaryMsg();
        Menus.mainMenu();
        //System.out.println("type name");
        //String name = menuSelector.nextLine();
        //System.out.println("type project");
        //String project = menuSelector.nextLine();
        //System.out.println("type date");
        //String date = menuSelector.nextLine();
        //Task task = new Task(name, project,date);
       // System.out.println(task.name + task.project + task.date);
        //TaskList(name, project,date);

    }
}

