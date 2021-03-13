package Taskerino;

public class Messages {

    //for formatting text and clearing formatting
    public static final String ansBold = "\u001b[1m";
    public static final String ansYellow = "\u001B[33m";
    public static final String ansReverse = "\u001b[7m";
    public static final String ansPurple = "\u001B[35m";
    public static final String ansRed = "\u001B[31m";
    public static final String ansGreen = "\u001B[32m";
    public static final String ansClear = "\u001B[0m";


    public static void welcomeMsg() {
        //A happy welcoming message to be printed only upon starting up the program
        System.out.println(ansYellow + "Welcome to " + ansBold + "Taskerino!" + ansClear);
    }

    public static void mainMenuMsg() {
        //Display all main menu options
        System.out.println(ansPurple + ansBold + "~~~MAIN MENU~~~" + ansClear);
        System.out.println("What do you want to do?");
        System.out.println("1. Add new task");
        System.out.println("2. Show all saved tasks");
        System.out.println("3. Edit, delete, or tick off a task");
        System.out.println("4. View instructions");
        System.out.println("5. Save and quit");

    }
    public static void showTasksMenuMsg() {
        //Display all Show menu options
        System.out.println(ansPurple + "~SHOW TASKS MENU~" + ansClear);
        System.out.println("How do you want to sort your tasks?");
        System.out.println("1. By ticked status (complete first)");
        System.out.println("2. By due date (oldest first)");
        System.out.println("3. By project (alphabetical)");
        System.out.println("4. In the order you added them");
        System.out.println("5. Return to main menu");
    }
    public static void addTasksMenuMsg() {
        //welcome user to Add tasks menu
        System.out.println(ansPurple + "~ADD TASKS MENU~" + ansClear);
        System.out.println("Enter a new task with a Name, Project, and Date.");
    }
    public static void editTasksMenuMsg() {
        //welcome user to Edit menu
        System.out.println(ansPurple + "~EDIT MENU~" + ansClear);
        System.out.println("You selected Edit, delete or tick off a task.");
    }
    public static void editTasksSelectMsg() {
        //Display all Edit menu options after selecting which task to edit
        System.out.println(ansPurple + "~~EDIT SUBMENU" + ansClear);
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
        System.out.println(ansReverse + "Enter 1 to return to main menu." + ansClear);
    }

    public static void exitMsg() {
        //Display after Save & Quit option is selected
        System.out.println(ansYellow + "Thanks for using Taskerino! See you again soon!" + ansClear);
    }

    public static void judgementMsgGood() {
        //Message to display if user has more tasks completed than incomplete
        System.out.println(ansGreen + "Excellent work, you're a star!" + ansClear);
    }

    public static void judgementMsgBad() {
        //Message to display if user has more tasks incomplete than complete
        System.out.println(ansRed + "Terrible. Better get on it." + ansClear);
    }

    public static void judgementMsgNeutral() {
        //Message to display if user has equal number of tasks complete and incomplete
        System.out.println(ansYellow + "Lots to do today! You can do it!" + ansClear);
    }
    public static void instructionsMsg() {
        //Provide some basic info about the program to user, upon request
        System.out.println(ansPurple + "~INSTRUCTIONS~" + ansClear);
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
