package Taskerino;

import java.util.ArrayList;
import java.util.Scanner;


public class Menus {
 TaskList taskList;
 ArrayList<Task> objList;
 int taskSelect;
 public Menus() {
     taskList = new TaskList();
 }

    public void mainMenu() {
        //this should contain all of the main menu including logic and input
        Scanner menuSelector = new Scanner(System.in);
        //Load tasks from save file... this seems to only work if there is a save file with stuff in it!!
        //This seems to disallow new tasks from being saved..??
        // need to change objList from ArrayList<Task> into a TaskList
        //if (taskList.loadMethod() != null) {
        //    objList = taskList.loadMethod();
        //   //is this where the problem is
        //    taskList.setTaskList(objList);
        //    taskList.getTaskList() = taskList
        //}

        Messages.mainMenuMsg();
        makeJudgement();
        String inputNumString = menuSelector.nextLine();
        System.out.println("You entered: " + inputNumString);

        // to disallow non integer inputs or values outside of 1-4
        try {
            int inputNum = Integer.parseInt(inputNumString);
            if (inputNum == 1) {
                showMenu();
            } else if (inputNum == 2) {
                addMenu();
            } else if (inputNum == 3) {
                editMenu();
            } else if (inputNum == 4) {
                System.out.println("Saving...");
                //fileH.writeAsObject(taskList.getTaskList());
                //FileHandlerObj.writeAsObject()
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

        //checking if there are any tasks in the list
        if (taskList.size()==0) {
            System.out.println("You don't have any tasks to show!");
            returnToMain();
        }
        //here to display menu for task sort
        Messages.showTasksMenuMsg();
        Scanner menuSelector = new Scanner(System.in);
        String inputNumString = menuSelector.nextLine();
        System.out.println("You entered: " + inputNumString);

        // to disallow non integer inputs or values outside of 1-4
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
                printList();
                returnToMain();
            } else {
                Messages.invalidInputMsg();
                showMenu();
            }
        } catch (NumberFormatException e) {
            Messages.invalidInputMsg();
            showMenu();
        }
    }

    public void addMenu() {
        //here to display menu for task add
        Messages.addTasksMenuMsg();
        String newTsName = TaskList.askForName();
        String newTsProj = TaskList.askForProject();
        String newTsDate = TaskList.askForDate();
        //creating a new task, user input for name, project, date, and setting Ticked Off status to false
        Task newTask = new Task(newTsName,newTsProj,newTsDate, false);
        System.out.println("Now adding new task! Task name: "+ newTask.name + ", Task Project: " + newTask.project + ", Task Date: " + newTask.date);
        taskList.addTask(newTask);
        System.out.println("Thank you! Your new task is saved.");
        returnToMain();

    }

    public int taskListSelect() {
     //this will take input from user, convert to integer, and then should convert this int by -1 to make index
        Scanner taskSelector = new Scanner(System.in);
        //here, taking user input and storing it as string
        String taskSelectString = taskSelector.nextLine();
        try {
            //here, taking user string and converting to integer
            taskSelect = Integer.parseInt(taskSelectString);
            //take integer of user input and convert to index by subtracting 1
            taskSelect--;
            Task editor = taskList.get(taskSelect);
            System.out.println("You selected: "+ (taskSelect + 1) + ". " + editor.name + ", " + editor.project + ", " + editor.date);
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
        //here to display menu for edit
        Messages.editTasksMenuMsg();
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
                System.out.println("Task name changed to:" + editableName.name);
                returnToMain();
            } else if (inputNum == 2) {
                //edit project
                Task editableProj = taskList.get(taskSelect);
                editableProj.setProject(TaskList.askForProject());
                System.out.println("Task project changed to:" + editableProj.project);
                returnToMain();
            } else if (inputNum == 3) {
                //edit date
                Task editableDate = taskList.get(taskSelect);
                editableDate.setDate(TaskList.askForDate());
                System.out.println("Task date changed to:" + editableDate.date);
                returnToMain();
            } else if (inputNum == 4) {
                //tick or untick
                Task editableTick = taskList.get(taskSelect);
                if (editableTick.getTickStatus() == false) {
                    editableTick.setTicked(true);
                } else {
                    editableTick.setTicked(false);
                }
                System.out.println("Task is now marked as: " + editableTick.boolToKlarsprak());
                returnToMain();
            } else if (inputNum == 5) {
                //delete task
                taskList.deleteTask(taskList.get(taskSelect));
                System.out.println("Task deleted.");
                returnToMain();
            } else if (inputNum == 6) {
                mainMenu();
            } else {
                Messages.invalidInputMsg();
                editMenu();
            }
        } catch (NumberFormatException e) {
            Messages.invalidInputMsg();
            editMenu();
        }
    }

    public void returnToMain() {
        //this is a method to take the user back to the main menu after completing some edit
        //or reaching a menu item that isn't complete yet
            Messages.returnToMenuMsg();
            Scanner menuOne = new Scanner(System.in);
            String inputOne = menuOne.nextLine();

            // to disallow input of anything that isn't 1
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
        //System.out.println("Printing task for testing!");
        int index = 0;
        while(index < taskList.size()) {
            Task printer = taskList.get(index);
            System.out.println((index + 1) + ". " + printer.name + ", " + printer.project + ", " + printer.date + ", " + printer.boolToKlarsprak());
            index++;
        }

    }

    public void makeJudgement() {
        //count how many tasks TRUE, using variable int tasksDone
        //count how many tasks FALSE, using variable int tasksNotDone
        //want to make a loop, for each task in taskList, if task.isTicked returns true, augment tasksDone by 1
        int tasksDone = 0;
        int tasksNotDone;
        //tasksDone = 0;
        for (Task task : taskList.getTaskList()) {

            if (task.isTicked) {
                tasksDone++;
            }

        }
        tasksNotDone = taskList.size() - tasksDone;
        System.out.println("You've completed " + tasksDone + " tasks, and you've got " + tasksNotDone + " tasks to go.");
        if (tasksDone > tasksNotDone) {
            Messages.judgementMsgGood();
        } else if (tasksDone == tasksNotDone) {
            Messages.judgementMsgNeutral();
        } else {
            Messages.judgementMsgBad();
        }

    }
}


