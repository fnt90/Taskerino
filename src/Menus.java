import java.util.Scanner;

public class Menus {


    public static void mainMenu() {
        //this should contain all of the main menu including logic and input
        Scanner menuSelector = new Scanner(System.in);

        Messages.mainMenuMsg();
        String inputNumString = menuSelector.nextLine();
        System.out.println("You entered: " + inputNumString);

        // how to disallow non int??
        try {
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
        } catch(NumberFormatException e) {
            Messages.invalidInputMsg();
            mainMenu();
        }
    }

    public static void showMenu() {
        //here to display menu for task sort
        Messages.showTasksMenuMsg();
    }

    public static void addMenu() {
        //here to display menu for task add
        Messages.addTasksMenuMsg();
    }

    public static void editMenu() {
        //here to display menu for edit
        Messages.editTasksMenuMsg();
        System.out.println("Press enter to continue, imagining you are selecting a task from the list");

        Scanner menuSelector = new Scanner(System.in);
        menuSelector.nextLine();

        editSubMenu();

    }
    public static void editSubMenu() {
        //this is the submenu for editing, after a task has been selected
        Messages.editTasksSelectMsg();

        Scanner menuSelector = new Scanner(System.in);
        String inputNumString = menuSelector.nextLine();
        System.out.println("You entered: " + inputNumString);

        try {
            int inputNum = Integer.parseInt(inputNumString);
            if (inputNum == 1) {
                //edit name
            } else if (inputNum == 2) {
                //edit due date
            } else if (inputNum == 3) {
                //edit project
            } else if (inputNum == 4) {
                //Messages.exitMsg();
            } else if (inputNum == 5) {
                //delete task
            } else if (inputNum == 6) {
                mainMenu();
            } else {
                Messages.invalidInputMsg();
                editSubMenu();
            }
        } catch (NumberFormatException e) {
            Messages.invalidInputMsg();
            editSubMenu();
        }

    }
    //This does not work as I want, inputNumString is left hanging
    //public static void textPrompt() {
       // Scanner menuSelector = new Scanner(System.in);
       // String inputNumString = menuSelector.nextLine();
       // System.out.println("You entered: " + inputNumString);
   // }
}
