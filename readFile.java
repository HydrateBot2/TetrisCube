import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class readFile {
    //Initializing variables
    Dictionary<String, int[][][]> pieceDictionary = new Hashtable<>();
    String[] txtFileByLine = new String[263];
    int counter = 0;
    Enumeration keyList;

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

    public Dictionary<String, int[][][]> getDict(){
        return this.pieceDictionary;
    }

    public Enumeration getKeyList(){
        return this.keyList;
    } 


    //Initializes the pieces into a int[][][][]
    public void pieceInitializer(String[] txtFile){
        String tempLine;
        int[][][] tempPiece = new int[4][4][4];
        String tempName = "";

        for(int line = 0; line < txtFile.length; line++){
            tempLine = txtFile[line];
            Matcher matcher = pattern.matcher(tempLine);

            for(int w = 0; w < 12; w++){
                for(int i = 0; i < 4; i++){
                    for(int j = 0; j < 4; j++){
                        for(int k = 0; k < 4; k++){
                            if(matcher.find()){
                                tempName = tempLine;
                            } else if(tempLine.isEmpty()) {
                                continue;
                            } else{
                                int x = tempLine.charAt(k) - '0';
                                tempPiece[i][j][k] = x;
                                
                                
                            }    

                        }
                    }
                }
                pieceDictionary.put(tempName, tempPiece);

            }
        }
        this.keyList = pieceDictionary.keys();
    }
}
