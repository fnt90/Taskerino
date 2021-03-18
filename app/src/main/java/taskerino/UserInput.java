package taskerino;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Scanner;
/**
 * The UserInput class takes in user input for menu choices and parse them to integers while catching
 * invalid input, and take in new data for a task's Name, Project, or Date.
 * @author Fiona Thompson
 * @version 1.0 (2021.03.18)
 */
public class UserInput {
    public static int taskChoice;
    public static final String ANS_YELLOW = "[38;5;185m";
    public static final String ANS_CLEAR = "[0m";
    public static final String ANS_BOLD = "[1m";
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
            taskChoice = Integer.parseInt(taskSelectString);
            //take integer of user input and convert to index by subtracting 1
            taskChoice--;
            return taskChoice;
        } catch (NumberFormatException e) {
            Messages.printInvalidInput();
            taskChoice = -1;
        }
        return taskChoice;
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

    public static String askForName() {
        //Prompts user to input name, either when adding new task or selecting Edit Name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type new task " + ANS_BOLD + "name" + ANS_CLEAR + ":");
        String name = scanner.nextLine();
        //If user does not type a name, replace blank with **Untitled**
        if (name.length()==0) {
            return "**Untitled**";
        }
        return name;
    }

    public static String askForProject() {
        //Prompts user to input project, either when adding new task or selecting Edit Project
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type new task " + ANS_BOLD + "project" + ANS_CLEAR + ":");
        String project = scanner.nextLine();
        return project;
    }

    public static LocalDate askForDate() {
        //Prompts user to input due date, either when adding new task or selecting Edit Date
        Scanner askDate = new Scanner(System.in);

        System.out.println("Type new task " + ANS_BOLD + "due date " + ANS_YELLOW + "(DD Mmm/04 Oct)" + ANS_CLEAR + ":");
        //try block to check if date correctly formatted, if not, automatically set to today's date
        try {
            LocalDate date = LocalDate.parse(askDate.nextLine(), formatter);
            return date;
        } catch (DateTimeException e) {
            System.out.println("Invalid date entered (or you didn't capitalize month). " + ANS_YELLOW +
                    "Setting due date to " + ANS_BOLD + "today." + ANS_CLEAR);
            LocalDate date = LocalDate.now();
            return date;
        }
    }
}
