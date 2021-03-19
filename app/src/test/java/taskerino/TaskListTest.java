package taskerino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    private TaskList taskListUnderTest;

    @BeforeEach
    void setUp() {
        taskListUnderTest = new TaskList();
    }

    @Test
    void addTaskToEmptyTaskListReturnsTaskListWithOneTask() {
        final Task task = new Task("name", "project", LocalDate.of(2020, 1, 1), false);
        taskListUnderTest.addTask(task);
        assertEquals(taskListUnderTest.size(), 1);
    }
    @Test
    void addTaskToNonemptyTaskListReturnsTaskListWithTwoTasks() {
        final Task task = new Task("name", "project", LocalDate.of(2020, 1, 1), false);
        final Task task1 = new Task("name1", "project1", LocalDate.of(2020, 1, 1), false);
        taskListUnderTest.addTask(task);
        taskListUnderTest.addTask(task1);
        assertEquals(taskListUnderTest.size(), 2);
    }

    @Test
    void deteteLastTaskFromTaskListReturnsEmptyTaskList() {
        final Task task = new Task("name", "project", LocalDate.of(2020, 1, 1), false);
        taskListUnderTest.addTask(task);
        taskListUnderTest.deleteTask(task);
        assertEquals(taskListUnderTest.size(), 0);
    }

    @Test
    void deteteTaskFromTaskListReturnsTaskListMinusOne() {
        final Task task = new Task("name", "project", LocalDate.of(2020, 1, 1), false);
        final Task task1 = new Task("name1", "project1", LocalDate.of(2020, 1, 1), false);
        taskListUnderTest.addTask(task);
        taskListUnderTest.addTask(task1);
        taskListUnderTest.deleteTask(task1);
        assertEquals(taskListUnderTest.size(), 1);
    }

    @Test
    void getSizeOfEmptyTaskListResultsInZero() {
        final int result = taskListUnderTest.size();
        assertEquals(0, result);
    }
    @Test
    void getSizeOfTaskListWithOneTaskResultsInOne() {
        final Task task = new Task("name", "project", LocalDate.of(2020, 1, 1), false);
        taskListUnderTest.addTask(task);
        final int result = taskListUnderTest.size();
        assertEquals(1, result);
    }

    @Test
    void getTaskReturnsTaskAtIndexZero() {
        final Task task = new Task("name", "project", LocalDate.of(2020, 1, 1), false);
        taskListUnderTest.addTask(task);
        final Task result = taskListUnderTest.get(0);
        assertEquals(task, result);
    }

    @Test
    void getTaskReturnsTaskAtIndexOne() {
        final Task task = new Task("name", "project", LocalDate.of(2020, 1, 1), false);
        final Task task1 = new Task("name1", "project1", LocalDate.of(2020, 1, 1), false);
        taskListUnderTest.addTask(task);
        taskListUnderTest.addTask(task1);
        final Task result = taskListUnderTest.get(1);
        assertEquals(task1, result);
    }

    @Test
    void changeTickedStatusFlipsBooleanFromFalseToTrue() {
        Task task = new Task("name", "project", LocalDate.of(2020, 1, 1), false);
        taskListUnderTest.addTask(task);
        taskListUnderTest.changeTicked(0);
        assertTrue(task.isTicked);
    }
    @Test
    void changeTickedStatusFlipsBooleanFromTrueToFalse() {
        Task task = new Task("name", "project", LocalDate.of(2020, 1, 1), true);
        taskListUnderTest.addTask(task);
        taskListUnderTest.changeTicked(0);
        assertFalse(task.isTicked);
    }
}

