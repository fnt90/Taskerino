package taskerino;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenusTest {
    @Test void showMenuReturnsToMainWhenTaskListEmpty() {
        Menus menus = new Menus();
        menus.showMenu();
        assertNull(menus.taskList);
    }

}
