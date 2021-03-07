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
        System.out.println("1. Show all saved tasks");
        System.out.println("2. Add new task");
        System.out.println("3. Edit, delete, or tick off a task");
        System.out.println("4. Save and quit");
        System.out.println("Type your selected digit and press Enter/Return");
    }
    public static void showTasksMenuMsg() {
        //Message to let user know they entered Show menu
        System.out.println("~SHOW TASKS MENU~");
        System.out.println("How do you want to sort your tasks?");
        System.out.println("0. for testing");
        System.out.println("1. By ticked status (complete first)");
        System.out.println("2. By due date (oldest first)");
        System.out.println("3. By project (alphabetical)");
        System.out.println("4. Return to main menu");
    }
    public static void addTasksMenuMsg() {
        //Message to let user know they entered Add menu
        System.out.println("~ADD TASKS MENU~");
    }
    public static void editTasksMenuMsg() {
        //Message to let user know they entered Edit menu
        System.out.println("~EDIT MENU~");
        System.out.println("You selected Edit, delete or tick off a task.");
        System.out.println("PRINT ALL TASKS HERE WITH ITERATOR NUMBER");
        System.out.println("Type the number of the task you want to select.");
    }
    public static void editTasksSelectMsg() {
        //Message to provide edit options after selecting a task to edit
        System.out.println("~~EDIT SUBMENU");
        System.out.println("What do you want to do with this task?");
        System.out.println("1. Edit name");
        System.out.println("2. Edit due date");
        System.out.println("3. Edit project");
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
        System.out.println("Type 1 to return to main menu.");
    }

    public static void exitMsg() {
        //Message to display after Save & Quit option is selected
        System.out.println("Kthxbye!");
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

    public static void taskSummaryMsg() {
        /*Message to display summary of how many tasks are complete and how many are incomplete
         *Need to replace "X" with variable containing number of tasks complete, and "Y" with incomplete
         */
        System.out.println("You've completed " + "X" + " tasks, and you've got " + "Y" + " tasks to go.");
    }

    public static void taskAddedMsg() {
        //Message to display after a new task has been created
        System.out.println("Task has been added!");
    }

    public static void taskUpdatedMsg() {
        //Message to display after a task's Name, Date, or Project has been edited
        System.out.println("Task has been updated!");
    }

    public static void taskStatusChangeMsg() {
        /*Message to display after task has been marked complete or incomplete
         *Need to convert boolean true to string Complete, and boolean false to string Incomplete
         */
        System.out.println("This task status has been set to: " + "booleanstringhere");
    }

    public static void taskDeletedMsg() {
        System.out.println("Task has been deleted.");
    }

    public static void noTasksMsg() {
        System.out.println("You have no tasks. Huh.");
    }
}
