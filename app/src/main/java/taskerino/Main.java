package taskerino;

import java.util.Scanner;
/**
 * The main...
 * @author Fiona Thompson
 * @version 1.0 (2021.03.18)
 */
public class Main {
    //for formatting text and clearing formatting
    public static final String ANS_YELLOW = "[38;5;185m";
    public static final String ANS_CLEAR = "[0m";
    public static final String ANS_BOLD = "[1m";

    public static void main(String[] args) throws InterruptedException {
        //main method of Taskerino

        Messages.printWelcome();

        FileHandler fileHandler = new FileHandler();
        String userName = fileHandler.readName();
        if (userName.equals("")) {
            String userNameInp = UserInput.askUserName();
            if (userNameInp.length() == 0) {
                userNameInp = "Buddy";
            }
            fileHandler.writeName(userNameInp);
            System.out.println("Nice to meet you, " + ANS_YELLOW + ANS_BOLD + userNameInp.toUpperCase() + "!" + ANS_CLEAR);
        } else {
            System.out.println("Welcome back, " + ANS_YELLOW + ANS_BOLD + userName + "!" + ANS_CLEAR);

        }
        Menus menu = new Menus();
        menu.mainMenu();
    }
}

