package Taskerino;

import java.io.*;
import java.util.ArrayList;

//to write as object!! Task class will need to implement Serializable
public class FileHandlerObj {
//my path is C:\Users\fiona\Documents\IdeaProjs\Taskerino\app\src\main\resources
    private String path = "app/src/main/resources/";


    public void writeAsObject(ArrayList<Task> objList) {
        try {
            FileWriter fileWriter = new FileWriter(new File(path + "taskerinoData.txt"));
            for (Task writeTask : objList) {
                fileWriter.write(writeTask.name + ",,");
                fileWriter.write(writeTask.project+ ",,");
                fileWriter.write(writeTask.date+ ",,");
                fileWriter.write(writeTask.boolToString()+ ",\n");
            }
            //objWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }
    public ArrayList<Task> readAsObject() {
        ArrayList<Task> objList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(path + "taskerinoData.txt");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String line = "";
            String[] data;
            while ((line = bufReader.readLine()) != null) {
                data = line.split(",,");
                Task saveTask = new Task(data[0], data[1], data[2], data[3]);
                objList.add(saveTask);
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("(No save file loaded)");
        }
    return objList;
    }

}
