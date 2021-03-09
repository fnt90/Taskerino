package Taskerino;

public class Messages {
    public static void welcomeMsg() {
        //A happy welcoming message to be printed only upon starting up the program
        System.out.println("Welcome to Taskerino!");
    }

    public static void mainMenuMsg() {
        //Message to display menu options
        System.out.println("~~~MAIN MENU~~~");
        System.out.println("What do you want to do?");
        System.out.println("1. Add new task");
        System.out.println("2. Show all saved tasks");
        System.out.println("3. Edit, delete, or tick off a task");
        System.out.println("4. View instructions");
        System.out.println("5. Save and quit");

    }
    public static void showTasksMenuMsg() {
        //Message to let user know they entered Show menu
        System.out.println("~SHOW TASKS MENU~");
        System.out.println("How do you want to sort your tasks?");
        System.out.println("0. Show all tasks");
        System.out.println("INACTIVE 1. By ticked status (complete first)");
        System.out.println("INACTIVE 2. By due date (oldest first)");
        System.out.println("INACTIVE 3. By project (alphabetical)");
        System.out.println("4. Return to main menu");
    }
    public static void addTasksMenuMsg() {
        //Message to let user know they entered Add menu
        System.out.println("~ADD TASKS MENU~");
        System.out.println("Enter a new task with a Name, Project, and Date.");
    }
    public static void editTasksMenuMsg() {
        //Message to let user know they entered Edit menu
        System.out.println("~EDIT MENU~");
        System.out.println("You selected Edit, delete or tick off a task.");
    }
    public static void editTasksSelectMsg() {
        //Message to provide edit options after selecting a task to edit
        System.out.println("~~EDIT SUBMENU");
        System.out.println("What do you want to do with this task?");
        System.out.println("1. Edit name");
        System.out.println("2. Edit project");
        System.out.println("3. Edit due date");
        System.out.println("4. Tick off (or un-tick) this task");
        System.out.println("5. Delete this task");
        System.out.println("6. Return to main menu");
    }
    public static void invalidInputMsg() {
        /*Message to display when user inputs unexpected value as a menu choice.
         *e.g. input "5" or "ghjkf" when menu options are 1,2,3,4
         */
        System.out.println("Please enter a valid digit.");
    }

    public static void returnToMenuMsg() {
        //Message to instruct user how to return to main menu after Adding, Editing, or Showing (sorted list)
        System.out.println("Enter 1 to return to main menu.");
    }

    public static void exitMsg() {
        //Message to display after Save & Quit option is selected
        System.out.println("Thanks for using Taskerino! See you again soon!");
    }

    public static void judgementMsgGood() {
        //Message to display if user has more tasks completed than incomplete
        System.out.println("Excellent work, you're a star!");
    }

    public static void judgementMsgBad() {
        //Message to display if user has more tasks incomplete than complete
        System.out.println("Terrible. Better get on it.");
    }

    public static void judgementMsgNeutral() {
        //Message to display if user has equal number of tasks complete and incomplete
        System.out.println("Lots to do today! You can do it!");
    }
    public static void instructionsMsg() {
        System.out.println("~INSTRUCTIONS~");
        System.out.println("Thanks for checking out my To-Do List project! This program \n" +
                "will store tasks for you to help you remember what you need \n" +
                "to get done. Taskerino will also look at how many tasks you \n" +
                "have completed, and give you a suitable judgement (hehe). It \n" +
                "saves to a .txt file, and will load your saved tasks the \n" +
                "next time you start. A task's name and project fields can \n" +
                "hold any text you want, but please don't use two commas in \n" +
                "a row (,,) as your save file won't load correctly if you do.\n" +
                "Currently, the date field can hold any text, but this will \n" +
                "change eventually (read: very soon as it’s due in a week).\n" +
                "You can find more information in the README.\n");
    }
}
