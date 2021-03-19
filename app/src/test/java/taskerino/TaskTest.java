package taskerino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private Task taskUnderTest;

    @BeforeEach
    void setUp() {
        taskUnderTest = new Task("name", "project", LocalDate.of(2020, 1, 1), false);
    }

    @Test void stringToBoolReturnsTrueWhenComplete() {
        assertTrue(taskUnderTest.stringToBool("complete"));
    }

    @Test void stringToBoolReturnsFalseWhenIncomplete() {
        assertFalse(taskUnderTest.stringToBool("incomplete"));
    }

    @Test
    void testGetTickStatusReturnsFalseOnNewTask() {
        final boolean result = taskUnderTest.getTickStatus();
        assertFalse(result);
    }

    @Test
    void stringToBoolReturnsIncompleteWhenIsTickedEqualsFalse() {
        assertEquals(taskUnderTest.boolToString(),"incomplete");
    }

    @Test
    void stringToBoolReturnsCompleteWhenIsTickedEqualsTrue() {
        Task completedTask = new Task("name", "project", LocalDate.of(2020, 1, 1), true);
        assertEquals(completedTask.boolToString(),"complete");
    }
}