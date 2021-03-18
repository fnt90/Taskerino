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
    /**
     * @param taskChoice String of user input, should be a number corresponding to a task printed on console
     */
    public static int taskChoice;
    /**
     * ANSI escape codes corresponding to text formatting.
     */
    public static final String ANS_YELLOW = "[38;5;185m";
    public static final String ANS_CLEAR = "[0m";
    public static final String ANS_BOLD = "[1m";
    /**
     * Allows conversion of standard LocalDate format "YYYY-MM-DD" to a custom pattern "dd MMM".
     */
    public static DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("dd MMM")
            .parseDefaulting(ChronoField.YEAR, 2021)
            .toFormatter(Locale.US);

    /**
     * Takes user input and converts to integer. If successful, subtracts 1 to correspond to task's index in ArrayList.
     * If unsuccessful, throws NumberFormatException and prints error message to user.
     * @return user's chosen task as an index value or error value (-1)
     */
    public static int taskListSelect() {
        System.out.println("Select a task from the list by entering its number.");
        Scanner scanner = new Scanner(System.in);
        String taskSelectString = scanner.nextLine();

        try {
            taskChoice = Integer.parseInt(taskSelectString);
            taskChoice--;
            return taskChoice;
        } catch (NumberFormatException e) {
            Messages.printInvalidInput();
            taskChoice = -1;
        }
        return taskChoice;
    }

    /**
     * Takes user input, prints a repeat of user input in console, and converts to integer. If unsuccessful, throws
     * NumberFormatException and prints error message to user.
     * @return user's chosen menu item number or error value (-1)
     */
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

    /**
     * Prompts user to enter their name to save to file, in order to greet user upon starting program.
     * @return user's name as String
     */
    public static String askUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANS_YELLOW + "What's your name?" + ANS_CLEAR);
        String userNameInp = scanner.nextLine();
        return userNameInp;
    }

    /**
     * Prompts user to input task name, either when adding new task or editing task name. If user presses Enter/Return,
     * a blank string will be replaced by "**Untitled**".
     * @return new task name or "**Untitled**"
     */
    public static String askForName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type new task " + ANS_BOLD + "name" + ANS_CLEAR + ":");
        String name = scanner.nextLine();
        if (name.length()==0) {
            return "**Untitled**";
        }
        return name;
    }

    /**
     * Prompts user to input task project, either when adding new task or editing task project. If user presses
     * Enter/Return, a blank string will be saved.
     * @return new task project
     */
    public static String askForProject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type new task " + ANS_BOLD + "project" + ANS_CLEAR + ":");
        String project = scanner.nextLine();
        return project;
    }

    /**
     * Prompts user to input task due date, either when adding new task or editing task date. If user presses
     * Enter/Return or does not follow specified pattern of "dd MMM", saves due date as today's date.
     * @return new task date
     */
    public static LocalDate askForDate() {
        Scanner askDate = new Scanner(System.in);
        System.out.println("Type new task " + ANS_BOLD + "due date " + ANS_YELLOW + "(DD Mmm/04 Oct)" + ANS_CLEAR + ":");
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
