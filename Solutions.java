import java.util.ArrayList;
import java.util.Enumeration;

public class Solutions {
    Piece obj1 = new Piece();
    ArrayList<String> pieceKeys = obj1.getKeyList();
    final int xRotation = 100;
    final int yRotation = 10;
    final int zRotation = 1;
    

    public int[][][] getSolutions(int[][][] cube, int[][][] piece, int pieceNumber){ 
       int newPieceNumber = pieceNumber;
       int[][][] newCube = cube;
        if(newPieceNumber == 12){
            obj1.insertPiece(obj1.pieceDictionary.get(pieceKeys.get(12)), pieceNumber, pieceNumber, pieceNumber)
            return newCube;
        }

        newPieceNumber++;
        piece = Box.getDict(pieceKeys.get(newPieceNumber));
        return newCube + getSolutions(newCube, piece, pieceNumber);
    }
}
