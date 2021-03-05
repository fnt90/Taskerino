import java.util.Scanner;

public class Menus {


    public static void mainMenu() {
        //this should contain all of the main menu including logic and input
        Scanner menuSelector = new Scanner(System.in);

        Messages.mainMenuMsg();
        String inputNumString = menuSelector.nextLine();
        System.out.println("You entered: " + inputNumString);

        // how to disallow non int??
        int inputNum = Integer.parseInt(inputNumString);
        if (inputNum == 1) {
            showMenu();
        } else if (inputNum == 2) {
            addMenu();
        } else if (inputNum == 3) {
            editMenu();
        } else if (inputNum == 4) {
            Messages.exitMsg();
        } else {
            Messages.invalidInputMsg();
            mainMenu();
        }
    }

    public static void showMenu() {
        //here to display menu for task sort
        Messages.showTasksMenuMsg();
    }

    public static void addMenu() {
        Messages.addTasksMenuMsg();
    }

    public static void editMenu() {
        //here to display menu for edit
        Messages.editTasksMenuMsg();
    }
    public static void
}
