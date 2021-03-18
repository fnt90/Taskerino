package taskerino;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Scanner;

public class UserInput {
    public static int taskSelect;
    //public int menuChoice;
    TaskList taskList;
    public static final String ANS_CLEAR = "[0m";
    public static final String ANS_BK_BLUE = "[30;44m";
    public static DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("dd MMM")
            .parseDefaulting(ChronoField.YEAR, 2021)
            .toFormatter(Locale.US);

    public static int taskListSelect() {
        System.out.println("Select a task from the list by entering its number.");
        //this will take input from user, convert to integer, and then should subtract 1 to make index
        Scanner scanner = new Scanner(System.in);
        //here, taking user input and storing it as string
        String taskSelectString = scanner.nextLine();

        try {
            //take user string and converting to integer
            taskSelect = Integer.parseInt(taskSelectString);
            //take integer of user input and convert to index by subtracting 1
            taskSelect--;
            return taskSelect;
        } catch (NumberFormatException e) {
            Messages.printInvalidInput();
            taskSelect = -1;
        }
        return taskSelect;
    }

    public static int menuSelect() {
        int menuChoice;
        Scanner scanner = new Scanner(System.in);
        String menuChoiceString = scanner.nextLine();
        System.out.println("You entered: " + menuChoiceString);
        try{
            menuChoice = Integer.parseInt(menuChoiceString);
        }catch(NumberFormatException e){
            Messages.printInvalidInput();
            menuChoice=-1;
        }

        return menuChoice;
    }
}
