
public class Solutions {
    int[][][][] solutions;
    Box functionRunner = new Box();
    int[][][] tetrisCube = functionRunner.getBox();
    Piece obj1;
    final int X = 100;
    final int Y = 10;
    final int Z = 1;
    
    public Solutions(Piece obj1){
        this.obj1 = obj1;
    }

    //initial test
    public int[][][] test(){
        int[][][] tempint;
        for(int i = 0; i < 12; i++){
            Piece tempPiece = obj1.pieceDictionary.get(obj1.getKeyList().get(i));
            tempint = iterateThroughPositions(tempPiece, tempPiece.getX(), tempPiece.getY(), tempPiece.getZ());
            for(int j = 0; j < 10; j ++){
                for(int k = 0; k < 10; k ++){
                    for(int l = 0; l < 10; l ++){
                        this.tetrisCube[j][k][l] = this.tetrisCube[j][k][l] + tempint[j][k][l];
                    }
                }
            }
        }
        return this.tetrisCube;
    }

    //Supposed to iterate through all the positions and place the piece when there is an open spot availible(NOT WORKING)
    public int[][][] iterateThroughPositions(Piece piece, int i, int j, int k){
        int[][][] tempBox2 = getTetrisCube();
        for(int x = i; x < 7; x++){
             for(int y = j; y < 7; y++){
                for(int z = k; z < 7; z++){
                    piece.setStartPOS(x, y, z);
                    tempBox2 = functionRunner.insertPiece(tempBox2, piece.returnCurrentPiece(piece), x, y, z);
                    if(obj1.checkBoxCollision(tempBox2) == true){
                        tempBox2 = this.tetrisCube;
                        System.out.println("Collision detected");
                    }
                    else{
                        x = 7;
                        y = 7;
                        z = 7;
                        return tempBox2;
                    }
                }
            }
        }
        return getTetrisCube();
    }


    //returns the box that stores all the pieces
    public int[][][] getTetrisCube(){
        return this.tetrisCube;
    }



    //future stuff


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


    //checks to see if solution is unique
    // public boolean uniqueSolutions(){

    // } 
}
