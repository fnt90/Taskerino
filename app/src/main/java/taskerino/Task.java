package taskerino;

import java.util.Comparator;
import java.time.LocalDate;

/**
 * The Task class creates Tasks that have a Name and Project with String values, a due date with LocalDate values,
 * and a ticked/unticked status with a boolean value. A task marked as ticked will be complete, whereas a task marked
 * as unticked will be incomplete.
 * @author Fiona Thompson
 * @version 1.0 (2021.03.18)
 */
public class Task {
    String name;
    String project;
    LocalDate date;
    boolean isTicked;

    /**
     * Main constructor to create task objects with name, project, date and ticked status.
     * @param name The name of the to-do task the user wants to put on the list
     * @param project The project to which the to-do task belongs
     * @param date The due date of the to-do task
     * @param isTicked The complete or incomplete status of the task
     */
    public Task(String name, String project, LocalDate date, boolean isTicked) {
        this.name = name;
        this.project = project;
        this.date = date;
        this.isTicked = isTicked;
    }

    /**
     * Secondary constructor to correctly read Date and Ticked status from save file.
     * @param name Name of task to be read from save file
     * @param project Project of task to be read from save file
     * @param sDate String in LocalDate format YYYY-MM-DD to be read from save file
     * @param status String "complete" or "incomplete" corresponding to boolean true or false
     */
    public Task(String name, String project, String sDate, String status) {
        this.name = name;
        this.project = project;
        this.date = LocalDate.parse(sDate);
        this.isTicked = stringToBool(status);
    }

    public String getName() {
        return name;
    }

    public String getProject() {
        return project;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean getTickStatus() {
        return isTicked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setProject(String project){
        this.project = project;
    }

    public void setTicked(boolean isTicked) {
        this.isTicked = isTicked;
    }

    /**
     * Converts boolean true/false to String for ease of saving to file and printing to list, for user to easily
     * understand true means task is completed and false means task is incomplete.
     * @return string to represent boolean value
     */
    public String boolToString(){
        if (isTicked){
            return "complete";
        } else {
            return "incomplete";
        }
    }

    /**
     * Converts String stored in save file back to boolean for storage in current TaskList.
     * @param string String version of isTicked
     * @return boolean value for isTicked variable
     */
    public boolean stringToBool(String string) {
        if (string.equals("complete")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Custom comparator to allow sorting of tasks by their Project field, ignoring case to allow user-friendly sorting.
     */
    public static Comparator<Task> taskProjComparator = new Comparator<Task>() {
        @Override
        public int compare(Task t1, Task t2) {
            String project1 = t1.getProject();
            String project2 = t2.getProject();
            return project1.compareToIgnoreCase(project2);
        }
    };
    /**
     * Custom comparator to allow sorting of tasks by their due date.
     */
    public static Comparator<Task> taskDateComparator = new Comparator<Task>() {
        @Override
        public int compare(Task t1, Task t2) {
            LocalDate date1 = t1.getDate();
            LocalDate date2 = t2.getDate();
            return date1.compareTo(date2);
        }
    };
}



