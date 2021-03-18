package taskerino;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.*;
import java.time.LocalDate;


public class Menus {
    TaskList taskList;
    ArrayList<Task> dataList;
    boolean alreadyLoaded = false;
    Sorter sorter = new Sorter();

    //for formatting text and clearing formatting
    public static final String ANS_REVERSE = "[7m";
    public static final String ANS_YELLOW = "[38;5;185m";
    public static final String ANS_CLEAR = "[0m";
    public static final String ANS_BK_BLUE = "[30;44m";
    public static final String ANS_BLUE = "[34m";
    public static DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("dd MMM")
            .parseDefaulting(ChronoField.YEAR, 2021)
            .toFormatter(Locale.US);

 public Menus() {
     taskList = new TaskList();
 }

    public void mainMenu() {
        //load save file
        dataList = taskList.loadMethod();
        //check if save file exists, and check if file has already been loaded
        if (dataList != null && !alreadyLoaded) {
            //first loading confirmed, set loaded info into taskList
            taskList.setTaskList(dataList);
            //check and print number tasks due today and number tasks overdue (to print only once per program execution)
            sorter.overdueTasks(taskList);
            //set alreadyLoaded to true which prevents re-loading on each call to mainMenu
            alreadyLoaded = true;
            //System.out.println("Loaded saved tasks from file.");
        }
        //show all main menu options
        Messages.printMainMenu();
        //read how many tasks the user has marked Done and Not done, and print a message to correspond
        sorter.makeJudgementOnTasks(taskList);
        System.out.println(ANS_REVERSE + "Select an option by typing a digit and pressing Enter/Return."+ ANS_CLEAR);
        //ask user to choose menu option
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
                taskList.saveMethod();
                Messages.printExit();
               //quit should happen here even without System.exit(0);
            } else {
                Messages.printInvalidInput();
                mainMenu();
            }
    }

    public void showMenu() {
        //check if the list is empty, if so, return to main menu
        if (taskList.size()==0) {
            System.out.println("You don't have any tasks to show!");
            returnToMain();
        }
        //print menu for options how to show list of tasks
        Messages.printShowTasksMenu();
        //ask user for menu choice
        int menuSelect = UserInput.menuSelect();

            if (menuSelect == 1) {
                //by ticked status
                sorter.printByStatus(taskList);
                returnToMain();
            } else if (menuSelect == 2) {
                //by due date
                sorter.sortByDate(taskList);
                returnToMain();
            } else if (menuSelect == 3) {
                //by project
                sorter.sortByProj(taskList);
                returnToMain();
            } else if (menuSelect == 5) {
                //return to main
                mainMenu();
            } else if (menuSelect == 4) {
                //print all stored tasks
                System.out.println(ANS_YELLOW + "Here are all your saved tasks:" + ANS_CLEAR);
                sorter.printAllTasks(taskList);
                returnToMain();
            } else {
                //user input invalid, return to Show Tasks menu
                showMenu();
            }
    }

    public void addMenu() {
        //display menu for adding new task, get user input for Name/Project/Date
        Messages.printAddTasksMenu();
        String newTsName = TaskList.askName();
        String newTsProj = TaskList.askProj();
        LocalDate newTsDate = TaskList.askDate();
        //creating a new task, user input for name, project, date, and setting default Ticked status to false
        Task newTask = new Task(newTsName,newTsProj,newTsDate, false);

        System.out.println("NEW TASK \nName: "+ ANS_BLUE + newTask.name + ANS_CLEAR + "\nProject: " + ANS_BLUE +
                newTask.project + ANS_CLEAR + "\nDate: " + ANS_BLUE + formatter.format(newTask.date) + ANS_CLEAR);
        taskList.addTask(newTask);
        System.out.println("Your new task is saved.");
        returnToMain();
    }

    public void editMenu() {
        // check if there are any tasks in your list, if not send to main menu
        if (taskList.size()==0) {
            System.out.println("You don't have any tasks to edit!");
            returnToMain();
        }
        //display menu for edit options
        Messages.printEditTasksMenu();
        //show all saved tasks to allow user to choose one
        sorter.printAllTasks(taskList);
        //user selects task
        int taskSelect = UserInput.taskListSelect();
        if (taskSelect == -1) {
            //user input is invalid
            editMenu();
        }
        //user input is valid, print details of selected task
        Task editor = taskList.get(taskSelect);
        System.out.println("You selected: " + ANS_BK_BLUE + (taskSelect + 1) + ". " + editor.name + ", " +
                editor.project + ", " + formatter.format(editor.date) + ", " + editor.boolToString() + ANS_CLEAR);

        Messages.printEditTaskActions();

        int menuChoice = UserInput.menuSelect();

            if (menuChoice == 1) {
                //edit name
                taskList.changeName(taskSelect);
                returnToMain();
            } else if (menuChoice == 2) {
                //edit project
                taskList.changeProj(taskSelect);
                returnToMain();
            } else if (menuChoice == 3) {
                //edit date
                taskList.changeDate(taskSelect);
                returnToMain();
            } else if (menuChoice == 4) {
                //tick or untick: set Complete to Incomplete, or Incomplete to Complete
                taskList.changeTicked(taskSelect);
                returnToMain();
            } else if (menuChoice == 5) {
                //delete task
                taskList.deleteTask(taskList.get(taskSelect));
                System.out.println("Task deleted.");
                returnToMain();
            } else if (menuChoice == 6) {
                //main menu
                mainMenu();
            } else {
                //user input was invalid, return to Edit Tasks menu
                editMenu();
            }
    }

    public void returnToMain() {
        //take the user back to the main menu after adding/editing/printing
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


