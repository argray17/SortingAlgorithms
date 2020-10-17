import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class FileGenerator {
    public static void createCSV() {
        Random n = new Random();
        int numberOfValues = 250000;
        try {
            PrintWriter pw = new PrintWriter(new File
                    ("C:\\Users\\Austin\\IdeaProjects\\CS300_Project_1\\src\\DataFiles\\CSV-File-A.csv"));
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < numberOfValues; i++) {
                int value = n.nextInt((1000 + 1000) + 1) - 1000;
                if( i != numberOfValues - 1) {
                    sb.append(value + ", ");
                } else {
                    sb.append(value);
                }
                if((i + 1) % 25 == 0){
                    sb.append("\n");
                }
            }
            pw.write(sb.toString());
            pw.close();

            System.out.println("File CSV-File-A Saved.");

        } catch(Exception e) {
            System.out.println("File Not Found.");
        }
    }
    public static void createCSV(int[] list, String fileName) {
        String s = "C:\\Users\\Austin\\IdeaProjects\\CS300_Project_1\\src\\DataFiles\\" + fileName + ".csv";
        try {
            PrintWriter pw = new PrintWriter(new File(s));
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < list.length; i++) {
                int value = list[i];
                if( i != list.length - 1) {
                    sb.append(value + ", ");
                } else {
                    sb.append(value);
                }
                if((i + 1) % 25 == 0){
                    sb.append("\n");
                }
            }
            pw.write(sb.toString());
            pw.close();

            System.out.println("File " + fileName + " Saved.\n");

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.\n");
        }
    }
}
