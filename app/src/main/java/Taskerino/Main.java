package Taskerino;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //main method of Taskerino!

        Messages.welcomeMsg();
        Menus menu = new Menus();


        FileHandler fileHandler = new FileHandler();
        String userName = fileHandler.readName();
        if (userName.equals("")) {
            Scanner askUserName = new Scanner(System.in);
            System.out.println("What's your name?");
            String userNameInp = askUserName.nextLine();

            if (userNameInp.length() == 0) {
                userNameInp = "Buddy";
            }
            fileHandler.writeName(userNameInp);
            System.out.println("Nice to meet you, " + userNameInp + "!");
        } else {
            System.out.println("Welcome back, " + userName + "!");

        }

        menu.mainMenu();

    }
}

