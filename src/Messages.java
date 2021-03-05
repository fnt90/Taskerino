

public class Messages {
    public static void welcomeMsg() {
        //A happy welcoming message to be printed only upon starting up the program
        System.out.println("Welcome to Taskerino!");
    }

    public static void mainMenuMsg() {
        //Message to display menu options
        System.out.println("What do you want to do?");
        System.out.println("1. here");
        System.out.println("2. here");
        System.out.println("3. here");
        System.out.println("4. here");
        System.out.println("Type your selected digit and press Enter/Return");
    }

    public static void invalidInputMsg() {
        /*Message to display when user inputs unexpected value as a menu choice.
        *e.g. input "Q" or "99" when menu options are 1,2,3,4
         */
        System.out.println("Please enter a valid digit.");
    }

    public static void returnToMenuMsg() {
        //Message to instruct user how to return to menu options after print, edit, delete, or add
        System.out.println("Enter 1 to return to main menu.");
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
