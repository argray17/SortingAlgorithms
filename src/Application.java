import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws Exception {
        System.out.println();
        FileGenerator.createCSV();
        FileToList csvFileA = new FileToList
                ("C:\\Users\\Austin\\IdeaProjects\\CS300_Project_1\\src\\DataFiles\\CSV-File-A.csv");
        int[] list = csvFileA.getList();
        Scanner sc = new Scanner(System.in);

        ArraySort fileA = new ArraySort(list);

        do {
            System.out.println("\nEnter the sort method to be used (Bubble, Insertion, Merge, Quick, or Exit)");
            String sortMethod = sc.nextLine().toLowerCase();

            switch (sortMethod) {

                case "bubble":
                    fileA.bubbleSort();
                    System.out.println("Enter a name to save the file under: ");
                    String fileNameBubble = sc.nextLine();
                    FileGenerator.createCSV(fileA.getSortedList(), fileNameBubble);
                    fileA.resetList();
                    break;

                case "insertion":
                    fileA.insertionSort();
                    System.out.println("Enter a name to save the file under: ");
                    String fileNameInsertion = sc.nextLine();
                    FileGenerator.createCSV(fileA.getSortedList(), fileNameInsertion);
                    fileA.resetList();
                    break;

                case "merge":
                    fileA.mergeSort();
                    Thread.sleep(100);
                    System.out.println("Enter a name to save the file under: ");
                    String fileNameMerge = sc.nextLine();
                    FileGenerator.createCSV(fileA.getSortedList(), fileNameMerge);
                    fileA.resetList();
                    break;

                case "quick":
                    fileA.quickSort();
                    System.out.println("Enter a name to save the file under: ");
                    String fileNameQuick = sc.nextLine();
                    FileGenerator.createCSV(fileA.getSortedList(), fileNameQuick);
                    fileA.resetList();
                    break;

                case "exit":
                    System.exit(0);

                default:
                    System.out.println("Not a valid entry");
                    break;
            }
        }while(true);
    }
}