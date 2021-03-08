package Taskerino;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write comment

        Messages.welcomeMsg();
        //Messages.taskSummaryMsg();
        Menus menu = new Menus();
        menu.mainMenu();


    }
}

