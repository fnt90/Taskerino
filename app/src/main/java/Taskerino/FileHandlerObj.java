package Taskerino;

import java.io.*;
import java.util.ArrayList;

//to write as object!! Task class will need to implement Serializable
public class FileHandlerObj {
//my path is C:\Users\fiona\Documents\IdeaProjs\Taskerino\app\src\main\resources
    private String path = "app/src/main/resources/";
    //TaskList objList;
    //File taskerinoObjData;

    public void writeAsObject(ArrayList<Task> objList) {
        try {

            FileOutputStream fileWriter = new FileOutputStream(new File(path + "taskerinoObjData.txt"));

            //FileOutputStream fileWriter = new FileOutputStream(new File(path + "taskerinoObjData.txt"));
            ObjectOutputStream objWriter = new ObjectOutputStream(fileWriter);

            objWriter.writeObject(objList);

            objWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }
    public ArrayList<Task> readAsObject() {
        ArrayList<Task> objList = new ArrayList<>();

        try {
            FileInputStream fileStream = new FileInputStream(path + "taskerinoObjData.txt");
            ObjectInputStream objReader = new ObjectInputStream(fileStream);

            objList = (ArrayList<Task>) objReader.readObject();
            objReader.close();
            fileStream.close();


        } catch (IOException e) {
            System.out.println("No save file loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("No save file loaded.");
        }
    return objList;
    }

}
