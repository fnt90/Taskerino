package taskerino;

import java.io.*;
import java.util.ArrayList;
/**
 * The FileHandler class handles reading and writing user's name and task data to file.
 * @author Fiona Thompson
 * @version 1.0 (2021.03.18)
 */
public class FileHandler {

    private String path = "app/src/main/resources/";

    /**
     * Saves user tasks to file in String format. Creates or rewrites a text save file in "resources" folder with one
     * task on each line, using ",," as a delimiter. Throws IOException and prints error message if resources folder
     * is not found.
     * @param dataList ArrayList of Tasks to be written to file
     */
    public void writeAsData(ArrayList<Task> dataList) {
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

    /**
     * Reads saved tasks from text file in "resources" folder for use within the program. Takes in one line per task,
     * uses ",," as a delimiter. Recreates task objects by inputting string-only data into secondary constructor,
     * allowing parsing and conversion for recreation of LocalDate and Boolean values.
     * @return ArrayList of saved tasks
     */
    public ArrayList<Task> readAsData() {
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

    /**
     * Saves user's name to file to print personalized greeting on next program execution.
     * @param userName name of user displayed in greeting
     */
    public void writeName(String userName) {
        try {
            FileWriter fileWriter = new FileWriter(new File(path + "taskerinoDataUser.txt"));
            fileWriter.write(userName);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Saving user name failed.");
        }
    }

    /**
     * Attempts to load saved name from text file. Sets user's name to a blank string to be replaced with user's name
     * if save file is found.
     * @return user's name or blank string to print within personalized greeting upon starting the program
     */
    public String readName() {
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
