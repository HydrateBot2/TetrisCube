import java.util.ArrayList;

public class Solutions {
    Box obj1 = new Box();
    ArrayList<String> pieceKeys = Box.getKeyList();
    

    public int[][][] getSolutions(int[][][] cube, int[][][] piece, int pieceNumber){ 
       int newPieceNumber = pieceNumber;
       int[][][] newCube = cube;
        if(newPieceNumber == 12){
            obj1.insertPiece(, pieceNumber, pieceNumber, pieceNumber)
            return newCube;
        }

        newPieceNumber++;
        piece = Box.getDict(pieceKeys.get(newPieceNumber));
        return newCube + getSolutions(newCube, piece, pieceNumber);
    }
}
