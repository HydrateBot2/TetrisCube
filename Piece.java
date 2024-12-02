import java.util.*;


public class Pieces{
    ArrayList<Integer[][][]> piecesList = new ArrayList<>(); 
    Dictionary<String, int[][][]> pieceDictionary = new Hashtable<>();
    Enumeration keyList;
     


    //initializes pieces


    //returns the Dictionary
    public Dictionary<String, int[][][]> getDict(){
        return this.pieceDictionary;
    }


    //Returns all of the keys in the dictionary
    public Enumeration getKeyList(){
        return this.keyList;
    } 





    //Initializes the pieces into a int[][][][]
    public void pieceInitializer(String[] txtFile){
        String tempLine;
        String tempName = "";
            for(int line = 0; line < txtFile.length; line++){
                // System.out.print(txtFile[line]);
                // System.out.println();
                int[][][] tempPiece = new int[4][4][4];
                tempLine = txtFile[line];
                if(tempLine.isEmpty() != true){
                    if(tempLine.charAt(0) == '^'){
                    tempName = tempLine;
                    line+= 2;
                    for(int k = 0; k < 4; k++){
                        for(int i = 0; i < 4; i++){
                            tempLine = txtFile[line];
                            for(int j = 0; j < 4; j++){
                                    int x = tempLine.charAt(j) - '0';
                                    tempPiece[k][i][j] = x;
                            }
                            line++;
                        }
                            line++;
                        }
                    }
                    pieceDictionary.put(tempName, tempPiece);
                }
                
                
            }
        this.keyList = pieceDictionary.keys();
    }



}