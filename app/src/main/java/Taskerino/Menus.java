package Taskerino;

import java.util.ArrayList;
import java.util.Scanner;


public class Menus {
 TaskList taskList;
 ArrayList<Task> objList;
 int taskSelect;
 boolean alreadyLoaded = false;

 //for formatting text and clearing formatting
 public static final String ansReverse = "\u001b[7m";
 public static final String ansYellow = "\u001B[33m";
 public static final String ansClear = "\u001B[0m";
 public static final String ansBkBlue = "\u001b[30;44m";
 public static final String ansBlue = "\u001B[34m";

 public Menus() {
     taskList = new TaskList();
 }

    public void mainMenu() {
        //this should contain all of the main menu including logic and input
        Scanner menuSelector = new Scanner(System.in);
        //load save file
        objList = taskList.loadMethod();
        //check if save file has already been loaded to avoid re-loading old data which prevents editing
        if (objList != null && !alreadyLoaded) {

            taskList.setTaskList(objList);
            alreadyLoaded = true;
            //System.out.println("Loaded saved tasks from file.");
        }
        //show all main menu options
        Messages.mainMenuMsg();
        //read how many tasks the user has marked Done and Not done, and print a message to correspond
        makeJudgement();
        System.out.println(ansReverse + "Select an option by typing a digit and pressing Enter/Return."+ ansClear);
        String inputNumString = menuSelector.nextLine();
        System.out.println("You entered: " + inputNumString + "\n");

        // to disallow non-integer inputs or values outside of 1-5
        try {
            int inputNum = Integer.parseInt(inputNumString);
            if (inputNum == 1) {
                //add task
                addMenu();
            } else if (inputNum == 2) {
                //print tasks
                showMenu();
            } else if (inputNum == 3) {
                //edit or delete task
                editMenu();
            } else if (inputNum == 4) {
                //view instructions
                Messages.instructionsMsg();
                returnToMain();
            } else if (inputNum == 5) {
                //save and quit
                System.out.println("Saving...");
                taskList.saveMethod();
                Messages.exitMsg();
                System.exit(0);
            } else {
                Messages.invalidInputMsg();
                mainMenu();
            }
        } catch(NumberFormatException e) {
            Messages.invalidInputMsg();
            mainMenu();
        }
    }

    public void showMenu() {

        //check if the list is empty, if so, return to main menu
        if (taskList.size()==0) {
            System.out.println("You don't have any tasks to show!");
            returnToMain();
        }
        //display menu for options how to show list of tasks
        Messages.showTasksMenuMsg();
        Scanner menuSelector = new Scanner(System.in);
        String inputNumString = menuSelector.nextLine();
        System.out.println("You entered: " + inputNumString + "\n");

        //to disallow non integer inputs or values outside of 1-4
        try {
            int inputNum = Integer.parseInt(inputNumString);
            if (inputNum == 1) {
                //by ticked status
                System.out.println("You can't sort by ticked yet, sorry.");
                returnToMain();
            } else if (inputNum == 2) {
                //by due date
                System.out.println("You can't sort by date yet, sorry.");
                returnToMain();
            } else if (inputNum == 3) {
                //by project
                System.out.println("You can't sort by project yet, sorry.");
                returnToMain();
            } else if (inputNum == 4) {
                //return to main
                mainMenu();
            } else if (inputNum == 0) {
                //just print all stored tasks
                System.out.println(ansYellow + "Here are all your saved tasks:" + ansClear);
                printList();
                returnToMain();
            } else {
                //tell user input was invalid and return to Show Tasks menu
                Messages.invalidInputMsg();
                showMenu();
            }
        } catch (NumberFormatException e) {
            Messages.invalidInputMsg();
            showMenu();
        }
    }

    public void addMenu() {
        //display menu for adding new task, get user input for Name/Project/Date
        Messages.addTasksMenuMsg();
        String newTsName = TaskList.askForName();
        String newTsProj = TaskList.askForProject();
        String newTsDate = TaskList.askForDate();
        //creating a new task, user input for name, project, date, and setting default Ticked status to false
        Task newTask = new Task(newTsName,newTsProj,newTsDate, false);
        System.out.println("NEW TASK Name: "+ ansBlue + newTask.name + ansClear + "\nProject: " + ansBlue + newTask.project + ansClear + "\nDate: " + ansBlue + newTask.date + ansClear);
        taskList.addTask(newTask);
        System.out.println("Your new task is saved.");
        returnToMain();

    }

    public int taskListSelect() {
     //this will take input from user, convert to integer, and then should subtract 1 to make index
        Scanner taskSelector = new Scanner(System.in);
        //here, taking user input and storing it as string
        String taskSelectString = taskSelector.nextLine();
        try {
            //take user string and converting to integer
            taskSelect = Integer.parseInt(taskSelectString);
            //take integer of user input and convert to index by subtracting 1
            taskSelect--;
            Task editor = taskList.get(taskSelect);
            System.out.println( "You selected: "+ ansBkBlue + (taskSelect + 1) + ". " + editor.name + ", " + editor.project + ", " + editor.date + ", " + editor.boolToString() + ansClear);
            return taskSelect;
        } catch (NumberFormatException e) {
            Messages.invalidInputMsg();
            editMenu();
        }
     return taskSelect;
    }

    public void editMenu() {

        // check if there are any tasks in your list, if not send to main menu
        if (taskList.size()==0) {
            System.out.println("You don't have any tasks to edit!");
            returnToMain();
        }
        //display menu for edit options
        Messages.editTasksMenuMsg();
        //show all saved tasks to allow user to choose one
        printList();
        System.out.println("Select a task from the list by entering its number.");
        taskListSelect();

        Messages.editTasksSelectMsg();

        Scanner menuSelector = new Scanner(System.in);
        String inputNumString = menuSelector.nextLine();
        System.out.println("You entered: " + inputNumString);

        // to disallow non integer inputs or values outside of 1-6
        try {
            int inputNum = Integer.parseInt(inputNumString);
            if (inputNum == 1) {
                //edit name
                Task editableName = taskList.get(taskSelect);
                editableName.setName(TaskList.askForName());
                System.out.println("Task name changed to:" + ansBkBlue + editableName.name + ansClear);
                returnToMain();
            } else if (inputNum == 2) {
                //edit project
                Task editableProj = taskList.get(taskSelect);
                editableProj.setProject(TaskList.askForProject());
                System.out.println("Task project changed to:" + ansBkBlue + editableProj.project + ansClear);
                returnToMain();
            } else if (inputNum == 3) {
                //edit date
                Task editableDate = taskList.get(taskSelect);
                editableDate.setDate(TaskList.askForDate());
                System.out.println("Task date changed to:" + ansBkBlue + editableDate.date + ansClear);
                returnToMain();
            } else if (inputNum == 4) {
                //tick or untick: set Complete to Incomplete, or Incomplete to Complete
                Task editableTick = taskList.get(taskSelect);
                if (editableTick.getTickStatus() == false) {
                    editableTick.setTicked(true);
                } else {
                    editableTick.setTicked(false);
                }
                System.out.println("Task is now marked as: " + ansBkBlue + editableTick.boolToString() + ansClear);
                returnToMain();
            } else if (inputNum == 5) {
                //delete task
                taskList.deleteTask(taskList.get(taskSelect));
                System.out.println("Task deleted.");
                returnToMain();
            } else if (inputNum == 6) {
                //main menu
                mainMenu();
            } else {
                //tell user input was invalid and return to Edit Tasks menu
                Messages.invalidInputMsg();
                editMenu();
            }
        } catch (NumberFormatException e) {
            Messages.invalidInputMsg();
            editMenu();
        }
    }

    public void returnToMain() {
        //take the user back to the main menu after adding/editing/printing
        //or reaching a menu item that isn't complete yet
            Messages.returnToMenuMsg();
            Scanner menuOne = new Scanner(System.in);
            String inputOne = menuOne.nextLine();

            // to disallow input of anything other than 1
            try {
                int menuInt = Integer.parseInt(inputOne);
                if (menuInt == 1) {
                    mainMenu();
                } else{
                    Messages.invalidInputMsg();
                    returnToMain();
                }
            } catch (NumberFormatException e) {
                Messages.invalidInputMsg();
                returnToMain();
            }
        }
    public void printList() {
        //show all saved tasks in the order they were added
        int index = 0;
        while(index < taskList.size()) {
            Task printer = taskList.get(index);
            String taskStatus = printer.boolToString();
            //System.out.println((index + 1) + ". " + printer.name + ", " + printer.project + ", " + printer.date + ", " + ansBlue + printer.boolToString()+ansClear); //TODO green for complete?
            System.out.print((index + 1) + ". " + printer.name + ", " + printer.project + ", " + printer.date + ", ");
            if (taskStatus.equals("incomplete")) {
                System.out.print(ansBlue + "incomplete" + ansClear + "\n");
            } else {
               System.out.print("complete" + "\n");
            }
            index++;
        }
    }

    public void makeJudgement() {
        /* count how many tasks TRUE (complete) using variable int tasksDone
        ** count how many tasks FALSE (incomplete) using variable int tasksNotDone
        ** loop for each saved task. If task.isTicked returns true (is complete), augment tasksDone by 1
         */
        int tasksDone = 0;
        int tasksNotDone;
        for (Task task : taskList.getTaskList()) {
            if (task.isTicked) {
                tasksDone++;
            }
        }
        //counted completed tasks, so incomplete tasks = total - completed
        tasksNotDone = taskList.size() - tasksDone;
        System.out.println("You've completed " + ansYellow + tasksDone + ansClear + " tasks, and you've got " + ansYellow + tasksNotDone + ansClear + " tasks to go.");
        //choose which judgement message to print
        if (tasksDone > tasksNotDone) {
            Messages.judgementMsgGood();
        } else if (tasksDone == tasksNotDone) {
            Messages.judgementMsgNeutral();
        } else {
            Messages.judgementMsgBad();
        }

    }
}


