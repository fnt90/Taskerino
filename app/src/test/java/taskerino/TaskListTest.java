package taskerino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskListTest {

    private TaskList taskListUnderTest;

    @BeforeEach
    void setUp() {
        taskListUnderTest = new TaskList();
    }

    @Test
    void testAddTask() {
        final Task task = new Task("name", "project", LocalDate.of(2020, 1, 1), false);
        taskListUnderTest.addTask(task);
        assertEquals(taskListUnderTest.size(), 1);
    }

    @Test
    void testDeleteTask() {
        final Task task = new Task("name", "project", LocalDate.of(2020, 1, 1), false);
        taskListUnderTest.deleteTask(task);
        assertEquals(taskListUnderTest.size(), 0);
    }

    @Test
    void testSize() {
        final int result = taskListUnderTest.size();
        assertEquals(0, result);
    }

    @Test
    void testGet() {
        final Task task = new Task("name", "project", LocalDate.of(2020, 1, 1), false);
        taskListUnderTest.addTask(task);
        final Task result = taskListUnderTest.get(0);
        assertEquals(task, result);
    }

    @Test
    void testChangeTicked() {
        Task task = new Task("name", "project", LocalDate.of(2020, 1, 1), false);
        taskListUnderTest.addTask(task);
        taskListUnderTest.changeTicked(0);
        assertTrue(task.isTicked);
    }

}
