import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;


public class readFile {
    //Initializing variables
    String[] txtFileByLine = new String[275];
    int counter = 0;

    public readFile(){
        
    }

    //Initializing and training regular expression
    Pattern pattern = Pattern.compile("^");

    //Takes in a text file, stores each line in an array
    public readFile(String fileName){
        try{
        File file1 = new File(fileName);
        Scanner reader = new Scanner(file1);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            txtFileByLine[counter] = line;
            counter++;
        }
        reader.close();
    } catch (FileNotFoundException e){
        System.out.println("An error occured.");
        e.printStackTrace();
    }
    }


    //Returns the array containing text by line
    public String[] getTxtFileByLine(){
        return txtFileByLine;
    }
}
