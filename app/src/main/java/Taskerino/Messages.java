package Taskerino;

public class Messages {

    //for formatting text and clearing formatting
    public static final String ANS_BOLD = "[1m";
    public static final String ANS_YELLOW = "[38;5;185m";
    public static final String ANS_REVERSE = "[7m";
    public static final String ANS_PURPLE = "[35m";
    public static final String ANS_CLEAR = "[0m";
    public static final String TASKERINO = "[38;5;212m" + "T"+"[38;5;217m" + "a"+ "[38;5;222m" + "s" +
            "[38;5;229m" + "k" + "[38;5;192m" + "e" + "[38;5;159m" + "r" + "[38;5;117m" + "i" +
            "[38;5;141m" + "n" + "[38;5;135m" + "o";


    public static void welcomeMsg() {
        //A happy welcoming message to be printed only upon starting up the program
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(ANS_YELLOW + " Welcome to "  + TASKERINO + ANS_CLEAR);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void mainMenuMsg() {
        //Display all main menu options
        System.out.println(ANS_PURPLE + ANS_BOLD + "~~~MAIN MENU~~~" + ANS_CLEAR);
        System.out.println("What do you want to do?");
        System.out.println("1. Add new task");
        System.out.println("2. Show all saved tasks");
        System.out.println("3. Edit, delete, or tick off a task");
        System.out.println("4. View instructions");
        System.out.println("5. Save and quit");

    }
    public static void showTasksMenuMsg() {
        //Display all Show menu options
        System.out.println(ANS_PURPLE + "~SHOW TASKS MENU~" + ANS_CLEAR);
        System.out.println("How do you want to sort your tasks?");
        System.out.println("1. By ticked status (complete first)");
        System.out.println("2. By due date (oldest first)");
        System.out.println("3. By project (alphabetical)");
        System.out.println("4. In the order you added them");
        System.out.println("5. Return to main menu");
    }
    public static void addTasksMenuMsg() {
        //welcome user to Add tasks menu
        System.out.println(ANS_PURPLE + "~ADD TASKS MENU~" + ANS_CLEAR);
        System.out.println("Enter a new task with a Name, Project, and Date.");
    }
    public static void editTasksMenuMsg() {
        //welcome user to Edit menu
        System.out.println(ANS_PURPLE + "~EDIT MENU~" + ANS_CLEAR);
        System.out.println("You selected Edit, delete or tick off a task.");
    }
    public static void editTasksSelectMsg() {
        //Display all Edit menu options after selecting which task to edit
        System.out.println(ANS_PURPLE + "~~EDIT SUBMENU" + ANS_CLEAR);
        System.out.println("What do you want to do with this task?");
        System.out.println("1. Edit name");
        System.out.println("2. Edit project");
        System.out.println("3. Edit due date");
        System.out.println("4. Tick off (or un-tick) this task");
        System.out.println("5. Delete this task");
        System.out.println("6. Return to main menu");
    }
    public static void invalidInputMsg() {
        //tell user they typed a value that was not a menu choice
        System.out.println("Please enter a valid digit.");
    }

    public static void returnToMenuMsg() {
        //Prompt to user to return to main menu after Adding, Editing, or Showing (sorted list)
        //This is used mostly to avoid automatically returning to main menu and clogging screen
        System.out.println(ANS_REVERSE + "Enter 1 to return to main menu." + ANS_CLEAR);
    }

    public static void exitMsg() {
        //Display after Save & Quit option is selected
        System.out.println(ANS_YELLOW + "Thanks for using "+TASKERINO+ ANS_YELLOW +"! See you again soon!" + ANS_CLEAR);
    }

    public static void judgementMsgGood() {
        //Message to display if user has more tasks completed than incomplete
        System.out.println("[38;5;112m" + "Excellent work, you're a star!" + ANS_CLEAR);
    }

    public static void judgementMsgBad() {
        //Message to display if user has more tasks incomplete than complete
        System.out.println("[38;5;166m" + "Terrible. Better get on it." + ANS_CLEAR);
    }

    public static void judgementMsgNeutral() {
        //Message to display if user has equal number of tasks complete and incomplete
        System.out.println(ANS_YELLOW + "Lots to do today! You can do it!" + ANS_CLEAR);
    }
    public static void instructionsMsg() {
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
