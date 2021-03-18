package taskerino;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.*;
import java.time.LocalDate;

/**
 * The Menus class handles each of the menus, providing a map to the user so they can access their desired function. It
 * gives the user a summary of their tasks in the form of a judgement message. It also gives directions to the program
 * on when loading from file is or isn't needed.
 * @author Fiona Thompson
 * @version 1.0 (2021.03.18)
 */
public class Menus {
    TaskList taskList;
    ArrayList<Task> dataList;
    /**
     * Starts program with false value for whether or not save file has loaded this program execution.
     */
    boolean alreadyLoaded = false;
    Sorter sorter = new Sorter();
    /**
     * ANSI escape codes corresponding to text formatting.
     */
    public static final String ANS_REVERSE = "[7m";
    public static final String ANS_YELLOW = "[38;5;185m";
    public static final String ANS_CLEAR = "[0m";
    public static final String ANS_BK_BLUE = "[30;44m";
    public static final String ANS_BLUE = "[34m";
    /**
     * Allows conversion of standard LocalDate format "YYYY-MM-DD" to a custom pattern "dd MMM".
     */
    public static DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("dd MMM")
            .parseDefaulting(ChronoField.YEAR, 2021)
            .toFormatter(Locale.US);

 public Menus() {
     taskList = new TaskList();
 }

    /**
     * Loads saved file if it exists, and checks if save file has been loaded in this instance of the program execution.
     * If not loaded, assigns save data to the taskList. If already loaded, prevents overwriting.
     * Prints Main Menu options, followed by a judgement message and a summary message informing user of any tasks due
     * today and any overdue tasks. Takes in user's menu choice and directs the user to their chosen menu, or saves and
     * exits the program. Returns user to the Main Menu if user's menu choice is invalid.
     */
    public void mainMenu() {
        //load save file
        dataList = taskList.loadTaskList();
        //check if save file exists, and check if file has already been loaded
        if (dataList != null && !alreadyLoaded) {
            //first loading confirmed, set loaded info into taskList
            taskList.setTaskList(dataList);
            //check and print number tasks due today and number tasks overdue (to print only once per program execution)
            sorter.overdueTasks(taskList);
            //set alreadyLoaded to true which prevents re-loading on each call to mainMenu
            alreadyLoaded = true;
        }

        Messages.printMainMenu();
        sorter.makeJudgementOnTasks(taskList);
        System.out.println(ANS_REVERSE + "Select an option by typing a digit and pressing Enter/Return."+ ANS_CLEAR);

        int menuChoice = UserInput.menuSelect();

            if (menuChoice == 1) {
                //add task
                addMenu();
            } else if (menuChoice == 2) {
                //print tasks
                showMenu();
            } else if (menuChoice == 3) {
                //edit or delete task
                editMenu();
            } else if (menuChoice == 4) {
                //view instructions
                Messages.printInstructions();
                returnToMain();
            } else if (menuChoice == 5) {
                //save and quit
                taskList.saveTaskList();
                Messages.printExit();
            } else {
                //user input is invalid (-1), return to Main Menu
                Messages.printInvalidInput();
                mainMenu();
            }
    }

    /**
     * Checks if taskList is empty, if empty user is returned to Main Menu. Prints Show Tasks Menu options and takes in
     * user's menu choice. Prints selected sort option and prompts user to return to Main Menu.
     */
    public void showMenu() {
        if (taskList.size()==0) {
            System.out.println("You don't have any tasks to show!");
            returnToMain();
        }

        Messages.printShowTasksMenu();
        //ask user for menu choice
        int menuChoice = UserInput.menuSelect();

            if (menuChoice == 1) {
                //by ticked status
                sorter.printByStatus(taskList);
                returnToMain();
            } else if (menuChoice == 2) {
                //by due date
                sorter.sortByDate(taskList);
                returnToMain();
            } else if (menuChoice == 3) {
                //by project
                sorter.sortByProj(taskList);
                returnToMain();
            } else if (menuChoice == 5) {
                //return to main
                mainMenu();
            } else if (menuChoice == 4) {
                //print all stored tasks
                System.out.println(ANS_YELLOW + "Here are all your saved tasks:" + ANS_CLEAR);
                sorter.printAllTasks(taskList);
                returnToMain();
            } else {
                //user input invalid (-1), return to Show Tasks menu
                showMenu();
            }
    }

    /**
     * Prints Add Task Menu message and prompts user to input name, project, and due date. Sets ticked status to false
     * ("incomplete") for all new tasks. Adds new task to taskList, and prints confirmation for the user.
     */
    public void addMenu() {
        Messages.printAddTasksMenu();
        String newName = UserInput.askForName();
        String newProject = UserInput.askForProject();
        LocalDate newDate = UserInput.askForDate();

        Task newTask = new Task(newName,newProject,newDate, false);

        System.out.println("NEW TASK \nName: "+ ANS_BLUE + newTask.name + ANS_CLEAR + "\nProject: " + ANS_BLUE +
                newTask.project + ANS_CLEAR + "\nDate: " + ANS_BLUE + formatter.format(newTask.date) + ANS_CLEAR);
        taskList.addTask(newTask);
        System.out.println("Your new task is saved.");
        returnToMain();
    }

    /**
     * Checks if taskList is empty, if empty user is returned to Main Menu. Prints Edit Menu message followed by a list
     * of all saved tasks. Takes in user's selected task and prints task details for confirmation of selection. Prints
     * list of actions available for editing task, takes in user's selection and allows user to perform the desired
     * function. Upon completion of function, directs user back to Main Menu.
     */
    public void editMenu() {
        if (taskList.size()==0) {
            System.out.println("You don't have any tasks to edit!");
            returnToMain();
        }
        Messages.printEditTasksMenu();
        //show all saved tasks to allow user to choose one
        sorter.printAllTasks(taskList);
        //user selects task
        int taskChoice = UserInput.taskListSelect();
        if (taskChoice == -1) {
            //user input is invalid
            editMenu();
        }
        //user input is valid, print details of selected task
        Task taskToEdit = taskList.get(taskChoice);
        System.out.println("You selected: " + ANS_BK_BLUE + (taskChoice + 1) + ". " + taskToEdit.name + ", " +
                taskToEdit.project + ", " + formatter.format(taskToEdit.date) + ", " + taskToEdit.boolToString() + ANS_CLEAR);

        Messages.printEditTaskActions();

        int menuChoice = UserInput.menuSelect();

            if (menuChoice == 1) {
                //edit name
                taskList.changeName(taskChoice);
                returnToMain();
            } else if (menuChoice == 2) {
                //edit project
                taskList.changeProject(taskChoice);
                returnToMain();
            } else if (menuChoice == 3) {
                //edit date
                taskList.changeDate(taskChoice);
                returnToMain();
            } else if (menuChoice == 4) {
                //tick or untick: set Complete to Incomplete, or Incomplete to Complete
                taskList.changeTicked(taskChoice);
                returnToMain();
            } else if (menuChoice == 5) {
                //delete task
                taskList.deleteTask(taskList.get(taskChoice));
                System.out.println("Task deleted.");
                returnToMain();
            } else if (menuChoice == 6) {
                //main menu
                mainMenu();
            } else {
                //user input is invalid (-1), return to Edit Tasks menu
                editMenu();
            }
    }

    /**
     * Prints prompt for user to return to the Main Menu. This prompt lets the user know their previous function is
     * complete (adding, editing, or printing). Allows the user to finish reading the information printed in the
     * console, and only returns to Main Menu when the user is ready to proceed.
     * Takes in user input and returns user to Main menu, or reprints prompt.
     */
    public void returnToMain() {
        Messages.printReturnToMain();
        int menuChoice = UserInput.menuSelect();

        if (menuChoice == 1) {
            //user input is valid
            mainMenu();
        } else {
            //user input is invalid
            returnToMain();
        }
    }
}


