package Taskerino;

import java.util.Scanner;


public class Menus {


    public static void mainMenu() {
        //this should contain all of the main menu including logic and input
        Scanner menuSelector = new Scanner(System.in);

        Messages.mainMenuMsg();
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
                Messages.exitMsg();
            } else {
                Messages.invalidInputMsg();
                mainMenu();
            }
        } catch(NumberFormatException e) {
            Messages.invalidInputMsg();
            mainMenu();
        }
    }

    public static void showMenu() {
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
            } else {
                Messages.invalidInputMsg();
                showMenu();
            }
        } catch (NumberFormatException e) {
            Messages.invalidInputMsg();
            showMenu();
        }
    }

    public static void addMenu() {
        //here to display menu for task add
        Scanner newCreate = new Scanner(System.in);
        Messages.addTasksMenuMsg();
        System.out.println("Enter name:");
        String newTsName = newCreate.nextLine();
        System.out.println("Enter proj:");
        String newTsProj = newCreate.nextLine();
        System.out.println("Enter date:");
        String newTsDate = newCreate.nextLine();
        Task newTask = new Task(newTsName,newTsProj,newTsDate);
        System.out.println("Now adding new task! Task name: "+ newTask.name + ", Task Project: " + newTask.project + ", Task Date: " + newTask.date);
        System.out.println("Thank you!Unfortunately this was not saved because it isn't implemented yet.");
        returnToMain();

    }

    public static void editMenu() {
        //here to display menu for edit
        Messages.editTasksMenuMsg();
        System.out.println("Press enter to continue, imagining you are selecting a task from the list");

        Scanner menuSelector = new Scanner(System.in);
        menuSelector.nextLine();

        editSubMenu();

    }
    public static void editSubMenu() {
        //this is the submenu for editing, after a task has been selected
        Messages.editTasksSelectMsg();

        Scanner menuSelector = new Scanner(System.in);
        String inputNumString = menuSelector.nextLine();
        System.out.println("You entered: " + inputNumString);

        // to disallow non integer inputs or values outside of 1-6
        try {
            int inputNum = Integer.parseInt(inputNumString);
            if (inputNum == 1) {
                //edit name
                System.out.println("You can't edit name yet, sorry.");
                returnToMain();
            } else if (inputNum == 2) {
                //edit due date
                System.out.println("You can't edit due date yet, sorry.");
                returnToMain();
            } else if (inputNum == 3) {
                //edit project
                System.out.println("You can't edit project yet, sorry.");
                returnToMain();
            } else if (inputNum == 4) {
                //tick or untick
                System.out.println("You can't tick/untick yet, sorry.");
                returnToMain();
            } else if (inputNum == 5) {
                //delete task
                System.out.println("You can't delete yet, sorry.");
                returnToMain();
            } else if (inputNum == 6) {
                mainMenu();
            } else {
                Messages.invalidInputMsg();
                editSubMenu();
            }
        } catch (NumberFormatException e) {
            Messages.invalidInputMsg();
            editSubMenu();
        }
    }
    public static void returnToMain() {
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

    //This does not work as I want, inputNumString is left hanging
    //public static void textPrompt() {
    // Scanner menuSelector = new Scanner(System.in);
    // String inputNumString = menuSelector.nextLine();
    // System.out.println("You entered: " + inputNumString);
    // }
}

