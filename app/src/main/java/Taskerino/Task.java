package Taskerino;

import java.util.Comparator;
import java.time.LocalDate;


public class Task implements Comparable {
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
        if (isTicked==true){
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
    @Override
    public boolean equals(Object o) {
        return ((Task) o).getProject().equals(getProject());
    }
    @Override
    public int compareTo(Object o) {
        Task t = (Task) o;
        return getProject().compareTo(t.getProject());
    }
        //solution from https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
        //under heading Sorting ArrayList<Object> multiple properties with Comparator
        // public static Comparator<Task> taskProjComparator = new Comparator<Task>() {
        //     @Override
        //    public int compare(Task o1, Task o2) {
        //        String Project1 = o1.getProject().toUpperCase();
        //        String Project2 = o2.getProject().toUpperCase();
        //        return Project1.compareTo(Project2);
        //    }
        //};


}



