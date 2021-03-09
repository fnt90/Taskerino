package Taskerino;
import java.io.Serializable;

public class Task implements Serializable {
    //this gives instructions on how an object Task should look like
    String name;
    String project;
    String date;
    boolean isTicked;


    public Task(String name, String project, String date, boolean isTicked) {
        this.name = name;
        this.project = project;
        this.date = date;
        this.isTicked = isTicked;

    }
    //public Task(String name, String project, String date) {
    //    this.name = name;
    //    this.project = project;
    //    this.date = date;
     //   this.isTicked = false;

    //}

    public Task(String name, String project, String date, String status) {
        this.name = name;
        this.project = project;
        this.date = date;
        this.isTicked = stringToBool(status);

    }
    public String getName() {
        return name;
    }

    public String getProject() {
        return project;
    }

    public String getDate() {
        return date;
    }

    public boolean getTickStatus() {
        return isTicked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setProject(String project){
        this.project = project;
    }

    public void setTicked(boolean isTicked) {
        this.isTicked = isTicked;
    }

    public String boolToString(){
        if (isTicked==true){
            return "complete";
        } else {
            return "incomplete";
        }
    }
    public boolean stringToBool(String string) {
        if (string.equals("complete")) {
            return true;
        } else {
            return false;
        }
    }
}



