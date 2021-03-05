import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write comment
        Scanner inputSelector = new Scanner(System.in);

        Messages.welcomeMsg();
        Messages.taskSummaryMsg();
        Messages.mainMenuMsg();

        String inputNumString = inputSelector.nextLine();
        System.out.println("You entered: " + inputNumString);

        //  How to deal with non int input? try block? Look at Zuul to see how they did this
        int inputNum = Integer.parseInt(inputNumString);
        if (inputNum == 1) {
            Messages.showTasksMenuMsg();
        } else if (inputNum == 2) {
            Messages.addTasksMenuMsg();
        } else if (inputNum == 3) {
            Messages.editTasksMenuMsg();
        } else if (inputNum == 4) {
            Messages.exitMsg();
        } else
            Messages.invalidInputMsg();
            //How to ask for new input, eg try again?
    }
}
