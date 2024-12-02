
public class Solutions {
    int[][][][] solutions;
    Box functionRunner = new Box();
    int[][][] tetrisCube = functionRunner.getBox();
    Piece obj1;
    int PieceInsertion;
    final int X = 100;
    final int Y = 10;
    final int Z = 1;
    
    public Solutions(Piece obj1){
        this.obj1 = obj1;
    }

    //initial test
    public int[][][] test(){
        int[][][] tempint = functionRunner.getBox();
        Piece tempPiece = obj1.pieceDictionary.get(obj1.getKeyList().get(0));

        tempint = iterateThroughPositions(tempint, tempPiece, 0, 0, 0);
        for(int o = 0; o < 10; o++){
            for(int u = 0; u < 10; u++){
                for(int l = 0; l < 10; l++){
                    System.out.print(tempint[o][u][l]);
                }
                System.out.println();
            }
            System.out.println();
        }

        // for(int i = 0; i < 12; i++){
        //     Piece tempPiece = obj1.pieceDictionary.get(obj1.getKeyList().get(i));
        //     tempint = iterateThroughPositions(tempPiece, tempPiece.getX(), tempPiece.getY(), tempPiece.getZ());
        //     for(int j = 0; j < 10; j++){
        //         for(int k = 0; k < 10; k++){
        //             for(int l = 0; l < 10; l++){
        //                 this.tetrisCube[j][k][l] = tempint[j][k][l];
        //             }
        //         }
        //     }
        // }
        return this.tetrisCube;
    }

    //Supposed to iterate through all the positions and place the piece when there is an open spot availible(NOT WORKING)
    public int[][][] iterateThroughPositions(int[][][] originalbox, Piece piece, int i, int j, int k){
        int[][][] possibleNewBox = originalbox;
        int[][][] tempBox2 = originalbox;
        System.out.println(getTetrisCube()[2][2][2]);
        for(int x = i; x < 7; x++){
             for(int y = j; y < 7; y++){
                for(int z = k; z < 7; z++){
                    piece.setStartPOS(x, y, z);
                    possibleNewBox = functionRunner.insertPiece(tempBox2, piece.getPiece(), x, y, z);

                    // Make these series of for loops a method again 
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
                    if(cannotPlace) {
                        //possibleNewBox = tempBox2;
                        System.out.println("Collision detected " + x + y + z);
                    }
                    else{
                        PieceInsertion++;
                        for(int o = 0; o < 10; o++){
                            for(int u = 0; u < 10; u++){
                                for(int l = 0; l < 10; l++){
                                    System.out.print(possibleNewBox[o][u][l]);
                                }
                                System.out.println();
                            }
                            System.out.println();
                        }
                        return possibleNewBox;
                    }
                }
            }
        }
        PieceInsertion++;
        return getTetrisCube();
    }


    //returns the box that stores all the pieces
    public int[][][] getTetrisCube(){
        return this.tetrisCube;
    }

    public int getpieceinsert(){
        return this.PieceInsertion;
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
