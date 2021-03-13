package Taskerino;

import java.util.Scanner;

public class Main {
    //for formatting text and clearing formatting
    public static final String ANS_YELLOW = "[38;5;185m";
    public static final String ANS_CLEAR = "[0m";
    public static final String ANS_BOLD = "[1m";

    public static void main(String[] args) {
        //main method of Taskerino

        Messages.welcomeMsg();


        FileHandler fileHandler = new FileHandler();
        String userName = fileHandler.readName();
        if (userName.equals("")) {
            Scanner askUserName = new Scanner(System.in);
            System.out.println(ANS_YELLOW + "What's your name?" + ANS_CLEAR);
            String userNameInp = askUserName.nextLine();

            if (userNameInp.length() == 0) {
                userNameInp = "Buddy";
                //I'm not your buddy, guy
            }
            fileHandler.writeName(userNameInp);
            System.out.println("Nice to meet you, " + ANS_YELLOW + ANS_BOLD + userNameInp + "!" + ANS_CLEAR);
        } else {
            System.out.println("Welcome back, " + ANS_YELLOW + ANS_BOLD + userName + "!" + ANS_CLEAR);

        }
        Menus menu = new Menus();
        menu.mainMenu();

    }
}

