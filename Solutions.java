import java.util.ArrayList;

public class Solutions {
    int[][][][] solutions;
    Piece obj1 = new Piece();
    Box tempBox = new Box();
    int[][][] box1 = tempBox.getBox();
    final int x = 100;
    final int y = 10;
    final int z = 1;
    
    public Solutions(){

    }

    // public int[][][] getSolutions( int[][][] piece, int pieceNumber){ 
    //    int newPieceNumber = pieceNumber;
    //    int[][][] newCube = this.box;
    //     if(newPieceNumber == 12){
    //         obj1.insertPiece(obj1.returnCurrentPiece(obj1.pieceDictionary.get(pieceKeys.get(12))), pieceNumber, pieceNumber, pieceNumber);
    //         return newCube;
    //     }

    //     newPieceNumber++;
    //     piece = Box.getDict(pieceKeys.get(newPieceNumber));
    //     return newCube + getSolutions(newCube, piece, pieceNumber);
    // }

    public int[][][] test(){
        //Problem right now lies in pieceKeys not having the pieces stored properly.
        System.out.println(obj1.getKeyList());
            for(int i = 1; i < 7; i++){
                Piece tempPiece = obj1.pieceDictionary.get(obj1.getKeyList().get(i));
                iterateThroughPositions(tempPiece, tempPiece.startX, tempPiece.startX, tempPiece.startZ);
            }
            System.out.println(obj1.getKeyList());
        System.out.println(obj1.getKeyList());
        System.out.println(obj1.getKeyList());
        return this.box1;
    }

    public int[][][] iterateThroughPositions(Piece piece, int i, int j, int k){
        for(int x = i; x < 10; x++){
            for(int y = j; y < 10; y++){
                for(int z = k; z < 10; z++){
                    piece.startX = x;
                    piece.startY = y;
                    piece.startZ = z;
                    this.box1 = tempBox.insertPiece(piece.returnCurrentPiece(piece), x, y, z);
                    // if(obj1.checkBoxCollision() != true){
                    //     return this.box;
                    // }

                }
            }
        }
        return this.box1;
    }

    public int[][][] getBox1(){
        return this.box1;
    }


    //checks to see if solution is unique
    // public boolean uniqueSolutions(){

    // } 
}
