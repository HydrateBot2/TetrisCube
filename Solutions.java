import java.util.ArrayList;
public class Solutions {
    int[][][][] solutions;
    Box functionRunner = new Box();
    PieceRotated functionRunnerPieceRotated = new PieceRotated();

    int[][][] tetrisCube = functionRunner.getBox();
    ArrayList<int[][][]> removedPieces;
    Piece obj1;
    Piece tempPiece;
    int counter = 0;
    final int X = 100;
    final int Y = 10;
    final int Z = 1;
    // array for discarding pieces
    
    public int[][][] getSolutions(int shift){ 
        test2(shift);
        if(functionRunner.fullBox(tetrisCube)){
            return tetrisCube;
        }
        functionRunner.removePiece(tetrisCube, tempPiece.getPiece(), tempPiece.getX(), tempPiece.getY(), tempPiece.getZ());
        counter++;
        System.out.println("iteration: " + this.counter);
        return getSolutions(shift);
    }

    public Solutions(Piece obj1){
        this.obj1 = obj1;
    }

    public int[][][] test2(int shift){
        int[][][] tempint = functionRunner.getBox();
        for(int i = 0; i < 12; i++){
            tempPiece = obj1.pieceDictionary.get(obj1.getKeyList().get(i));
            ArrayList<Piece> rotations = Rotations.getAllRotations(tempPiece);
            for (Piece currentPiece : rotations) {
                tempint = iterateThroughPositions(this.tetrisCube, currentPiece, tempPiece.getX(), tempPiece.getY(), tempPiece.getZ() + shift);
                if(tempint != null){
                    this.tetrisCube = tempint;
                    break;
                }
            }
        }
        return this.tetrisCube;
    }

    // public int[][][] tryAllRotations(){
    //     int[][][] tempint = functionRunner.getBox();
    //     tempPiece = obj1.pieceDictionary.get(obj1.getKeyList().get(0));
    //     for(int i = 0; i < 12; i++){
    //         tempint = iterateThroughPositions(this.tetrisCube, Rotations.getAllRotations(tempPiece).get(PieceInsertion), tempPiece.getX(), tempPiece.getY(), tempPiece.getZ());
    //         this.tetrisCube = tempint;
    //     }
    //     return this.tetrisCube;
    // }

    public int[][][] iterateThroughPositions(int[][][] originalbox, Piece piece, int i, int j, int k){
        int[][][] possibleNewBox = originalbox;
        int[][][] tempBox2 = originalbox;
        for(int x = i; x < 7; x++){
             for(int y = j; y < 7; y++){
                for(int z = k; z < 7; z++){
                    piece.setStartPOS(x, y, z);
                    possibleNewBox = functionRunner.insertPiece(tempBox2, piece.getPiece(), x, y, z);

                    // Make these series of for loops a method again
                    //probably cant not gonna mess with
                    // checking for collision 
                    boolean cannotPlace = false;
                    for(int row = 0; row < 10; row++){
                            for(int col = 0; col < 10; col++){
                                for(int zed = 0; zed < 10; zed++){
                                    if(possibleNewBox[row][col][zed] > 1){
                                        cannotPlace = true;
                                    }
                                }
                            }
                    }
                    if(!cannotPlace) {
                        
                        piece.setStartPOS(x, y, z + 1);
                        // for(int o = 0; o < 10; o++){
                        //     for(int u = 0; u < 10; u++){
                        //         for(int l = 0; l < 10; l++){
                        //             System.out.print(possibleNewBox[o][u][l]);
                        //         }
                        //         System.out.println();
                        //     }
                        //     System.out.println();
                        // }
                        return possibleNewBox;
                    }
                }
            }
        }
        // Couldn't place piece
        return null;
    }

    //initial test(see how many pieces the computer can put in the box) WITHOUT ROTATIONS
    public int[][][] test(){
        int[][][] tempint = functionRunner.getBox();
        Piece tempPiece;
        for(int i = 0; i < 12; i++){
            tempPiece = obj1.pieceDictionary.get(obj1.getKeyList().get(i));
            tempint = iterateThroughPositions(this.tetrisCube, tempPiece, tempPiece.getX(), tempPiece.getY(), tempPiece.getZ());
            this.tetrisCube = tempint;
        }
        return this.tetrisCube;
    }

    // // test with rotations yo
    // public int[][][] test2(){
    //     int[][][] tempint = functionRunner.getBox();
    //     Piece tempPiece;
    //     for(int i = 0; i < 12; i++){
    //         tempPiece = obj1.pieceDictionary.get(obj1.getKeyList().get(i));
    //         tempint = iterateThroughPositions(this.tetrisCube, Rotations.getAllRotations(tempPiece).get(i), tempPiece.getX(), tempPiece.getY(), tempPiece.getZ());
    //         this.tetrisCube = tempint;
    //     }
    //     return this.tetrisCube;
    // }


    //Supposed to iterate through all the positions and place the piece when there is an open spot availible(NOT WORKING)
    // public int[][][] iterateThroughPositions(int[][][] originalbox, Piece piece, int i, int j, int k){
    //     int[][][] possibleNewBox = originalbox;
    //     int[][][] tempBox2 = originalbox;
    //     for(int x = i; x < 7; x++){
    //          for(int y = j; y < 7; y++){
    //             for(int z = k; z < 7; z++){
    //                 piece.setStartPOS(x, y, z);
    //                 possibleNewBox = functionRunner.insertPiece(tempBox2, piece.getPiece(), x, y, z);

    //                 // Make these series of for loops a method again
    //                 //probably cant not gonna mess with
    //                 // checking for collision 
    //                 boolean cannotPlace = false;
    //                 for(int row = 0; row < 10; row++){
    //                         for(int col = 0; col < 10; col++){
    //                             for(int zed = 0; zed < 10; zed++){
    //                                 if(possibleNewBox[row][col][zed] > 1){
    //                                     cannotPlace = true;
    //                                 }
    //                             }
    //                         }
    //                 }
    //                 if(!cannotPlace) {
    //                     PieceInsertion++;
    //                     // for(int o = 0; o < 10; o++){
    //                     //     for(int u = 0; u < 10; u++){
    //                     //         for(int l = 0; l < 10; l++){
    //                     //             System.out.print(possibleNewBox[o][u][l]);
    //                     //         }
    //                     //         System.out.println();
    //                     //     }
    //                     //     System.out.println();
    //                     // }
    //                     return possibleNewBox;
    //                 }
    //             }
    //         }
    //     }
    //     // Couldn't place piece
    //     System.out.println(PieceInsertion);
    //     return getTetrisCube();
    // }


    //returns the box that stores all the pieces
    public int[][][] getTetrisCube(){
        return this.tetrisCube;
    }




    //future stuff




    //checks to see if solution is unique
    // public boolean uniqueSolutions(){

    // } 
}
