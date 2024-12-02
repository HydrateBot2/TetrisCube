import java.util.*;
import java.util.Collections;


public class Piece extends rotatePiece{
    ArrayList<Integer[][][]> piecesList = new ArrayList<>(); 
    Dictionary<String, Piece> pieceDictionary = new Hashtable<>();
    ArrayList<String> keyList;
     
    readFile txtfile = new readFile();
    int[][][] piece;
    int startX;
    int startY;
    int startZ; 
    int rotation;
    String pieceName;

    //initializes pieces
    public Piece(int startX, int startY, int startZ, int rotation, int[][][] piece, String pieceName){
        this.piece = piece;
        this.startX = startX;
        this.startY = startY;
        this.startZ = startZ;
        this.rotation = rotation;
        this.pieceName = pieceName;
        pieceInitializer(txtfile.getTxtFileByLine());
    }

    public Piece(){

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
                    Piece piece = new Piece(0, 0, 0, 0, tempPiece, tempName);
                    pieceDictionary.put(tempName, piece);
                }
                
                
            }
        this.keyList = Collections.list(pieceDictionary.keys());
        System.out.println(pieceDictionary.keys() + " WOWOWOWOOWOW");
        System.out.println(this.keyList + "WOWOWOWOWOL");
    }


    //Backend programming stuff

    public int[][][] returnCurrentPiece(Piece piece){
       int[][][] returnPiece = piece.getPiece();
       return returnPiece;
    }

    public int[][][] getPiece(){
        return this.piece;
    }

    public int getX(){
        return this.startX;
    }

    public int getY(){
        return this.startY;
    }

    public int getZ(){
        return this.startZ;
    }

    public void setStartPOS(int x, int y, int z){
        this.startX = x;
        this.startY = y;
        this.startZ = z;
    }

    public int getRotation(){
        return this.rotation;
    }

    public void setRotation(int rotation){
        this.rotation = rotation;
    }

    public String getName(){
        return this.pieceName;
    }

    public void setName(String name){
        this.pieceName = name;
    }

    //returns the Dictionary
    public Dictionary<String, Piece>getDict(){
        return this.pieceDictionary;
    }


    //Returns all of the keys in the dictionary
    public ArrayList<String> getKeyList(){
        System.out.println(this.keyList);
        return this.keyList;
        // ArrayList<String> tempList = new ArrayList<>();
        // System.out.println(this.keyList + " WWWWWWWW");
        // if(this.keyList != null){
        //     System.out.println(this.keyList + " WWWWWWWW");
        // while(keyList.hasMoreElements()){
        //     tempList.add((String) keyList.nextElement());
        // }
        // System.out.println(tempList + " LLLLLLLLLLLL");
        // return tempList;
        // }
        // System.out.println(tempList + " LLLLLLLLLLLL");
        // return tempList;
    } 

    public void printPiece(){
        for(int i = 0; i < this.piece.length; i++){
            for(int j = 0; j < this.piece.length; j++){
                for(int k = 0; k < this.piece.length; k++){
                    System.out.print(this.piece[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    @Override
    public String toString(){
        return "Start POS: " + this.startX + " " + this.startY + " " + this.startZ + " Rotation: " + this.rotation + " Name: " + this.pieceName; 
    }



}