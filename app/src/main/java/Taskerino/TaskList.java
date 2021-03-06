package Taskerino;
import java.util.ArrayList;

public class TaskList {
    //this should be an array list of Task objects, and the list is called taskList
    public ArrayList<Task> taskList;

    public TaskList(String name, String project, String date) {

        taskList = new ArrayList<>();
        Task task = new Task(name, project, date);
        taskList.add(task);
    }
}
