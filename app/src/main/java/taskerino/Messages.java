package taskerino;
/**
 * The Messages class contains all multi-line text blocks, as well as some frequently re-used text and formatting.
 * @author Fiona Thompson
 * @version 1.0 (2021.03.18)
 */
public class Messages {
    //for formatting text and clearing formatting
    public static final String ANS_BOLD = "[1m";
    public static final String ANS_YELLOW = "[38;5;185m";
    public static final String ANS_GREEN = "[38;5;112m";
    public static final String ANS_RED = "[38;5;166m";
    public static final String ANS_REVERSE = "[7m";
    public static final String ANS_PURPLE = "[35m";
    public static final String ANS_CLEAR = "[0m";
    //for rainbow print of Taskerino title
    public static final String TASKERINO = "[38;5;212m" + "T"+"[38;5;217m" + "a"+ "[38;5;222m" + "s" +
            "[38;5;229m" + "k" + "[38;5;192m" + "e" + "[38;5;159m" + "r" + "[38;5;117m" + "i" +
            "[38;5;141m" + "n" + "[38;5;135m" + "o";

    public static void printWelcome() {
        //A happy welcoming message to be printed only upon starting up the program
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(ANS_YELLOW + " Welcome to "  + TASKERINO + ANS_CLEAR);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void printMainMenu() {
        //Display all main menu options
        System.out.println(ANS_PURPLE + ANS_BOLD + "~~~MAIN MENU~~~" + ANS_CLEAR);
        System.out.println("What do you want to do?\n" +
                "1. Add new task\n" +
                "2. Show all saved tasks\n" +
                "3. Edit, delete, or tick off a task\n" +
                "4. View instructions\n" +
                "5. Save and quit");

    }
    public static void printShowTasksMenu() {
        //Display all Show menu options
        System.out.println(ANS_PURPLE + "~SHOW TASKS MENU~" + ANS_CLEAR);
        System.out.println("How do you want to sort your tasks?\n" +
                "1. By ticked status (complete first)\n" +
                "2. By due date (oldest first)\n" +
                "3. By project (alphabetical)\n" +
                "4. In the order you added them\n" +
                "5. Return to main menu");
    }
    public static void printAddTasksMenu() {
        //welcome user to Add tasks menu
        System.out.println(ANS_PURPLE + "~ADD TASKS MENU~" + ANS_CLEAR);
        System.out.println("Enter a new task with a Name, Project, and Date.");
    }
    public static void printEditTasksMenu() {
        //welcome user to Edit menu
        System.out.println(ANS_PURPLE + "~EDIT MENU~" + ANS_CLEAR);
        System.out.println("You selected Edit, delete or tick off a task.");
    }
    public static void printEditTaskActions() {
        //Display all Edit menu options after selecting which task to edit
        System.out.println(ANS_PURPLE + "~~EDIT SUBMENU" + ANS_CLEAR);
        System.out.println("What do you want to do with this task?\n" +
                "1. Edit name\n" +
                "2. Edit project\n" +
                "3. Edit due date\n" +
                "4. Tick off (or un-tick) task\n" +
                "5. Delete task\n" +
                "6. Cancel (return to main menu)");
    }
    public static void printInvalidInput() {
        //tell user they typed a value that was not a menu choice
        System.out.println("Please enter a valid digit.");
    }

    public static void printReturnToMain() {
        //Prompt to user to return to main menu after Adding, Editing, or Showing (sorted list)
        //This is used mostly to avoid automatically returning to main menu and clogging screen
        System.out.println(ANS_REVERSE + "Enter 1 to return to main menu." + ANS_CLEAR);
    }

    public static void printExit() {
        //Display after Save & Quit option is selected
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(ANS_YELLOW + "Thanks for using "+TASKERINO+ ANS_YELLOW +"! See you again soon!" + ANS_CLEAR);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void printJudgementGood() {
        //Message to display if user has more tasks completed than incomplete
        System.out.println(ANS_GREEN + "Excellent work, you're a star!" + ANS_CLEAR);
    }

    public static void printJudgementBad() {
        //Message to display if user has more tasks incomplete than complete
        System.out.println(ANS_RED + "Terrible. Better get on it." + ANS_CLEAR);
    }

    public static void printJudgementNeutral() {
        //Message to display if user has equal number of tasks complete and incomplete
        System.out.println(ANS_YELLOW + "Lots to do today, but you've made a start!" + ANS_CLEAR);
    }
    public static void printInstructions() {
        //Provide some basic info about the program to user, upon request
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
