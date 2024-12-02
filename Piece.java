import java.util.*;


public class Piece extends rotatePiece{
    ArrayList<Integer[][][]> piecesList = new ArrayList<>(); 
    Dictionary<String, Piece> pieceDictionary = new Hashtable<>();
    ArrayList<String> keyList;
     
    readFile txtfile = new readFile("Pieces.txt");
    private int[][][] piece;
    private int startX;
    private int startY;
    private int startZ; 
    private int rotation;
    private String pieceName;


    //constructors for Piece
    public Piece(){

    }

    public Piece(int startX, int startY, int startZ, int rotation, int[][][] piece, String pieceName){
        this.piece = piece;
        this.startX = startX;
        this.startY = startY;
        this.startZ = startZ;
        this.rotation = rotation;
        this.pieceName = pieceName;
    }



    //initializes pieces

    //Initializes the pieces into a dictionary containg a piece
    public void pieceInitializer(String[] txtFile){
        String tempLine = "";
        String tempName = "";
            for(int line = 0; line < txtFile.length; line++){
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
                    Piece newPiece = new Piece(0, 0, 0, 0, tempPiece, tempName);
                    pieceDictionary.put(tempName, newPiece);
                }
                
                
            }
            //creates the list of keys from the dictionary
        this.keyList = Collections.list(pieceDictionary.keys());
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
        return this.keyList;
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