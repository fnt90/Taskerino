package Taskerino;
import java.util.Scanner;

public class Task {
    //this gives instructions on how an object Task should look like
    String name;
    String project;
    String date;
    //boolean isTicked;


    public Task(String name, String project, String date) {
        this.name = name;
        this.project = project;
        this.date = date;
        //isTicked = true;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setProject(String project){
        this.project = project;
    }
    //setName
    //getName
    //setProject
    //getProject
    //setDate
    //getDate
    //setTicked
    //getTicked
}



