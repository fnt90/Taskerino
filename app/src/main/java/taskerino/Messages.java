package taskerino;
/**
 * The Messages class contains all multi-line text blocks, as well as some frequently re-used text and formatting.
 * @author Fiona Thompson
 * @version 1.0 (2021.03.18)
 */
public class Messages {
    /**
     * ANSI escape codes corresponding to text formatting.
     */
    public static final String ANS_BOLD = "[1m";
    public static final String ANS_YELLOW = "[38;5;185m";
    public static final String ANS_GREEN = "[38;5;112m";
    public static final String ANS_RED = "[38;5;166m";
    public static final String ANS_REVERSE = "[7m";
    public static final String ANS_PURPLE = "[35m";
    public static final String ANS_CLEAR = "[0m";
    /**
     * ANSI escape codes corresponding to rainbow colours, to print program title.
     */
    public static final String TASKERINO = "[38;5;212m" + "T"+"[38;5;217m" + "a"+ "[38;5;222m" + "s" +
            "[38;5;229m" + "k" + "[38;5;192m" + "e" + "[38;5;159m" + "r" + "[38;5;117m" + "i" +
            "[38;5;141m" + "n" + "[38;5;135m" + "o";

    /**
     * Prints colourful welcome message to user when starting the program.
     */
    public static void printWelcome() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(ANS_YELLOW + " Welcome to "  + TASKERINO + ANS_CLEAR);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * Prints menu options for the Main Menu.
     */
    public static void printMainMenu() {
        System.out.println(ANS_PURPLE + ANS_BOLD + "~~~MAIN MENU~~~" + ANS_CLEAR);
        System.out.println("What do you want to do?\n" +
                "1. Add new task\n" +
                "2. Show all saved tasks\n" +
                "3. Edit, delete, or tick off a task\n" +
                "4. View instructions\n" +
                "5. Save and quit");
    }
    /**
     * Prints menu options for the Show Tasks Menu.
     */
    public static void printShowTasksMenu() {
        System.out.println(ANS_PURPLE + "~SHOW TASKS MENU~" + ANS_CLEAR);
        System.out.println("How do you want to sort your tasks?\n" +
                "1. By ticked status (complete first)\n" +
                "2. By due date (oldest first)\n" +
                "3. By project (alphabetical)\n" +
                "4. In the order you added them\n" +
                "5. Return to main menu");
    }
    /**
     * Prints menu title for the Add Tasks Menu, and provides basic user instructions on task fields.
     */
    public static void printAddTasksMenu() {
        System.out.println(ANS_PURPLE + "~ADD TASKS MENU~" + ANS_CLEAR);
        System.out.println("Enter a new task with a Name, Project, and Date.");
    }

    /**
     * Prints menu title for the Edit Tasks Menu before all tasks are printed.
     */
    public static void printEditTasksMenu() {
        System.out.println(ANS_PURPLE + "~EDIT MENU~" + ANS_CLEAR);
        System.out.println("You selected Edit, delete or tick off a task.");
    }
    /**
     * Prints menu options for the Edit Tasks Menu once the user has selected which task to edit.
     */
    public static void printEditTaskActions() {
        System.out.println(ANS_PURPLE + "~~EDIT SUBMENU" + ANS_CLEAR);
        System.out.println("What do you want to do with this task?\n" +
                "1. Edit name\n" +
                "2. Edit project\n" +
                "3. Edit due date\n" +
                "4. Tick off (or un-tick) task\n" +
                "5. Delete task\n" +
                "6. Cancel (return to main menu)");
    }
    /**
     * Prints error message and prompts user to enter a digit that corresponds to one of the menu choices.
     */
    public static void printInvalidInput() {
        System.out.println("Please enter a valid digit.");
    }

    /**
     * Prints prompt for user to return to the Main Menu. This prompt lets the user know their previous function is
     * complete (adding, editing, or printing). Allows the user to finish reading the information printed in the
     * console, and only prints the Main Menu when the user is ready to proceed.
     */
    public static void printReturnToMain() {
        System.out.println(ANS_REVERSE + "Enter 1 to return to main menu." + ANS_CLEAR);
    }
    /**
     * Prints farewell message after user selects "Save & Quit" menu option.
     */
    public static void printExit() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(ANS_YELLOW + "Thanks for using "+TASKERINO+ ANS_YELLOW +"! See you again soon!" + ANS_CLEAR);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    /**
     * Prints a congratulatory message if user has more tasks complete than incomplete.
     */
    public static void printJudgementGood() {
        System.out.println(ANS_GREEN + "Excellent work, you're a star!" + ANS_CLEAR);
    }
    /**
     * Prints an uncomplimentary message if user has more tasks incomplete than complete.
     */
    public static void printJudgementBad() {
        System.out.println(ANS_RED + "Terrible. Better get on it." + ANS_CLEAR);
    }
    /**
     * Prints an encouraging message if user has an equal number of completed and incomplete tasks (or no tasks).
     */
    public static void printJudgementNeutral() {
        System.out.println(ANS_YELLOW + "Lots to do today, but you've made a start!" + ANS_CLEAR);
    }
    /**
     * Prints an informational text block containing basic user instructions for a user who may not otherwise read
     * a README file.
     */
    public static void printInstructions() {
        System.out.println(ANS_PURPLE + "~INSTRUCTIONS~" + ANS_CLEAR);
        System.out.println("Thanks for checking out my To-Do List project! This program \n" +
                "will store tasks for you to help you remember what you need \n" +
                "to get done. Taskerino will also look at how many tasks you \n" +
                "have completed, and give you a suitable judgement (hehe). It \n" +
                "saves to a .txt file, and will load your saved tasks the next\n" +
                "time you start. A task's name and project fields can hold any\n" +
                "text you want, but please don't use two commas in a row (,,)\n" +
                "as your save file won't load correctly if you do. Leaving a\n" +
                "task Name blank will result in **Untitled**, but leaving a task\n" +
                "Project blank will save as blank/empty. The date field can hold\n" +
                "any correctly formatted date (dd Mmm) and will automatically\n" +
                "set date to today if left blank or incorrectly formatted.  \n" +
                "You can find more information (and GIFs) in the README.\n");
    }
}
