package taskerino;

import java.util.Comparator;
import java.time.LocalDate;

/**
 * The Task class should create Tasks that have a Name and Project with String values, a due date with LocalDate values,
 * and a ticked/unticked status with a boolean value. A task marked as ticked will be complete, whereas a task marked
 * as unticked will be incomplete.
 * @author Fiona Thompson
 * @version 1.0 (2021.03.18)
 */
public class Task {
    //this gives instructions on how an object Task should look like
    String name;
    String project;
    LocalDate date;
    boolean isTicked;

    public Task(String name, String project, LocalDate date, boolean isTicked) {
        this.name = name;
        this.project = project;
        this.date = date;
        this.isTicked = isTicked;
    }

    public Task(String name, String project, String sDate, String status) {
        //this was added in order to correctly read Date and Ticked status from save file
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

    public String boolToString(){
        //to convert boolean TRUE to "complete" and FALSE to "incomplete" for user understanding
        if (isTicked){
            return "complete";
        } else {
            return "incomplete";
        }
    }
    public boolean stringToBool(String string) {
        //to convert saved data from String back into boolean form, to correctly display # of tasks done and allow editing
        if (string.equals("complete")) {
            return true;
        } else {
            return false;
        }
    }

        public static Comparator<Task> taskProjComparator = new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                String project1 = t1.getProject();
                String project2 = t2.getProject();
                return project1.compareToIgnoreCase(project2);
            }
        };

        public static Comparator<Task> taskDateComparator = new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                LocalDate date1 = t1.getDate();
                LocalDate date2 = t2.getDate();
                return date1.compareTo(date2);
            }
        };
}



