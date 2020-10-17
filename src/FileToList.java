import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FileToList {
    int[] list;
    String fileName;

    public FileToList(String fileName) throws Exception {
        this.fileName = fileName;
        setList(readFile());
    }
    public ArrayList<Integer> readFile() throws Exception {
        FileReader fr = new FileReader (new File(this.fileName));
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();
        String line;
        int value;

        while((line = br.readLine()) != null) {
            lines.add(line);
        }

        for(String str : lines) {
            String[] tempLine = str.split(", ");
            for(int i = 0; i < tempLine.length; i++) {
                value = Integer.parseInt(tempLine[i]);
                values.add(value);
            }
        }
        return values;
    }
    public void setList(ArrayList<Integer> values) {
        int[] list = new int[values.size()];
        int i = 0;

        for(int value: values) {
            list[i] = value;
            i++;
        }
        this.list = list;
    }
    public int[] getList() {
        return this.list;
    }
}
