import java.util.Scanner;

public class Menus {


    public static void mainMenu() {
        //this should contain all of the main menu including logic and input
        Scanner menuSelector = new Scanner(System.in);

        Messages.mainMenuMsg();
        String inputNumString = menuSelector.nextLine();
        System.out.println("You entered: " + inputNumString);

        int inputNum = Integer.parseInt(inputNumString);
        if (inputNum == 1) {
            Messages.showTasksMenuMsg();
        } else if (inputNum == 2) {
            Messages.addTasksMenuMsg();
        } else if (inputNum == 3) {
            Messages.editTasksMenuMsg();
        } else if (inputNum == 4) {
            Messages.exitMsg();
        } else {
            Messages.invalidInputMsg();
            mainMenu();
        }
    }

}
