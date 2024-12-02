import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public static class readFile {
    public readFile(String fileName){
        File file1 = new File(fileName);
        Scanner reader = new Scanner(file1);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            System.out.println(line);
        }
        reader.close();
    } 
}
