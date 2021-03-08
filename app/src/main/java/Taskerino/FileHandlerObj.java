package Taskerino;

import java.io.*;
import java.util.ArrayList;

//to write as object!! Task class will need to implement Serializable
public class FileHandlerObj {
//C:\Users\fiona\Documents\IdeaProjs\Taskerino\app\src\main\resources
    private String path = "src/main/resources";
    TaskList taskList;

    public void writeAsObject(ArrayList<Task> objList) {
        try {
            FileOutputStream fileWriter = new FileOutputStream(path + "taskerinoObjData.txt"));
            ObjectOutputStream objWriter = new ObjectOutputStream(fileWriter);

            objWriter.writeObject(objList);

            objWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("File not found." + e);
        }
    }
    public void readAsObject() {
        ArrayList<Task> objList = new ArrayList<>();

        try {
            FileInputStream fileStream = new FileInputStream(path + "taskerinoObjData.txt"));
            ObjectInputStream objReader = new ObjectInputStream(fileStream);

            objList = (ArrayList<Task>) objReader.readObject();
            objReader.close();
            fileStream.close();



           // bufReader.close();
        } catch (IOException e) {
            System.out.println("File not found." + e);
        } catch (ClassNotFoundException e) {
            System.out.println("File not found." + e);
        } catch (FileNotFoundException e) {
            System.out.println("File not found." + e);
        }

    }

}
