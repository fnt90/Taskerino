package taskerino;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
//my path is C:\Users\fiona\Documents\IdeaProjs\Taskerino\app\src\main\resources
    private String path = "app/src/main/resources/";
    //need to include app in string to prevent error

    public void writeAsData(ArrayList<Task> dataList) {
        //save user tasks to file
        try {
            FileWriter fileWriter = new FileWriter(new File(path + "taskerinoData.txt"));
            for (Task writeTask : dataList) {
                fileWriter.write(writeTask.name + ",,");
                fileWriter.write(writeTask.project+ ",,");
                fileWriter.write(writeTask.date+ ",,");
                fileWriter.write(writeTask.boolToString()+ ",,\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Saving failed.");
        }
    }

    public ArrayList<Task> readAsData() {
        //load user tasks from file
        ArrayList<Task> dataList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(path + "taskerinoData.txt");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String line = "";
            String[] data;
            while ((line = bufReader.readLine()) != null) {
                data = line.split(",,");
                Task saveTask = new Task(data[0], data[1], data[2], data[3]);
                dataList.add(saveTask);
            }
            fileReader.close();
        } catch (IOException e) {
            //this will print before the Main Menu message if there was no saved data found
            System.out.println("(No save file loaded)");
        }
        return dataList;
    }

    public void writeName(String userName) {
        //save username to file to print personalized greeting on next program execution
        try {
            FileWriter fileWriter = new FileWriter(new File(path + "taskerinoDataUser.txt"));
            fileWriter.write(userName);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Saving user name failed.");
        }
    }

    public String readName() {
        //load user's name for printing personalized greeting
        String userName = "";
        try {
            FileReader fileReader = new FileReader(path + "taskerinoDataUser.txt");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String line = "";
            while ((line = bufReader.readLine()) != null) {
            userName = line.toUpperCase();
            }
            fileReader.close();
        } catch (IOException e) {
        //No need to notify user if unable to load username
        }
        return userName;
    }

}
