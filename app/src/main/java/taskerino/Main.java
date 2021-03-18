package taskerino;

/**
 * The Main class greets the user with a personalized message and directs to the Main Menu.
 * @author Fiona Thompson
 * @version 1.0 (2021.03.18)
 */
public class Main {
    /**
     * ANSI escape codes corresponding to text formatting.
     */
    public static final String ANS_YELLOW = "[38;5;185m";
    public static final String ANS_CLEAR = "[0m";
    public static final String ANS_BOLD = "[1m";

    /**
     * Attempts to load user's name from save file. If file is found, greets user with a personalized message. If no
     * file is found, prompts user to enter their name, saves name to file and prints personalized message. If user
     * does not enter a name, name is set to "Buddy". Directs user to main menu.
     */
    public static void main(String[] args) {
        Messages.printWelcome();

        FileHandler fileHandler = new FileHandler();
        String userName = fileHandler.readName();
        if (userName.equals("")) {
            //no save file found, ask user for name
            String userNameInput = UserInput.askUserName();
            if (userNameInput.length() == 0) {
                //user pressed Enter/Return without entering name
                userNameInput = "Buddy";
            }
            //save user's name to file
            fileHandler.writeName(userNameInput);
            System.out.println("Nice to meet you, " + ANS_YELLOW + ANS_BOLD + userNameInput.toUpperCase() + "!" + ANS_CLEAR);
        } else {
            System.out.println("Welcome back, " + ANS_YELLOW + ANS_BOLD + userName + "!" + ANS_CLEAR);

        }
        Menus menu = new Menus();
        menu.mainMenu();
    }
}

