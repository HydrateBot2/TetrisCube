import java.util.ArrayList;
public class Solutions {
    ArrayList<int[][][]> solutions = new ArrayList<int[][][]>();
    Box box = new Box();
    Piece piece = new Piece();
    PieceRotated pieceRotated = new PieceRotated();
    WriteToFile writer = new WriteToFile();
    int placedPieces = 0;
    readFile readFile = new readFile("Pieces.txt", 275);
    int[][][] tetrisCube = box.getTetrisCube(false);
    int[][][] tetrisCubeWHS = box.getTetrisCube(true);
    Piece obj1;
    Piece tempPiece;
    int counter = 0;
    boolean backtracking;
    final int END_PIECE = 4;
    final int X = 100;
    final int Y = 10;
    final int Z = 1;
    // array for discarding pieces

    public void findSolutions(int pieceIndex, int[][][] tetrisCube, boolean headstart){
        piece.pieceInitializer(readFile.getTxtFileByLine());
        if(pieceIndex == 12){
            solutions.add(tetrisCube);
            writer.tryWriteToFile("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" + placedPieces, false);
            return;
        }
        Piece previousTry = new Piece();
        Piece tempPiece = piece.getDict().get(piece.getKeyList().get(pieceIndex));
        //Try placing this piece in every possible position with every rotation
        for (Piece rotation : Rotations.getAllRotations(tempPiece)){
            //System.out.println("Trying new rotation");
            for (int x = 0; x < 7; x++) {
               // System.out.println("x = " + x);
                for (int y = 0; y < 7; y++) {
                   // System.out.println("y = " + y);
                    for (int z = 0; z < 7; z++) {
                        //System.out.println("z = " + z);
                        if (canPlacePiece(tetrisCube, rotation, x, y, z)) {
                            writer.tryWriteToFile("Piece: " + rotation.getName() + " placed at " + x + " " + y + " " + z + "Pieces Placed: " + placedPieces + "\n", headstart);
                            tetrisCube = insertPiece(tetrisCube, rotation.getPiece(), x, y, z, false); // Place the piece
                            placedPieces++;
                            // for(int i = 0; i < 10; i++){
                            //     for(int j = 0; j < 10; j++){
                            //         for(int k = 0; k < 10; k++){
                            //         System.out.print(tetrisCube[i][j][k]);
                            //         }
                            //         System.out.println();
                            //     }
                            //     System.out.println();
                            // }
                            findSolutions(pieceIndex + 1, tetrisCube, headstart); // Recurse to place next piece

                            placedPieces--; 
                            tetrisCube = insertPiece(tetrisCube, rotation.getPiece(), x, y, z, true);
                            // tetrisCube = insertPiece(tetrisCube, rotation.getPiece(), x, y, z + 1); // Backtrack
                        }
                    }
                }
            }
        }
    }

    private int[][][] deepCopy(int[][][] original) {
        int[][][] copy = new int[original.length][original[0].length][original[0][0].length];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[0].length; j++) {
                System.arraycopy(original[i][j], 0, copy[i][j], 0, original[0][0].length);
            }
        }
        return copy;
    }

    public int[][][] insertPiece(int[][][] oldCube, int[][][] piece, int leftShift, int forwardShift, int downwardShift, boolean removed){
        int[][][] newBox = new int[10][10][10];
        for (int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 10; k++){
                    newBox[i][j][k] = oldCube[i][j][k];
                }
            }
        }
        if(removed == true){
            for(int x = 0; x < END_PIECE; x++){
                for(int y = 0; y < END_PIECE; y++){
                    for(int z = 0; z < END_PIECE; z++){
                        newBox[x + leftShift][y + forwardShift][z + downwardShift] = oldCube[x + leftShift][y + forwardShift][z + downwardShift] - piece[x][y][z];
                    }
                }
            }
        } else {
            for(int x = 0; x < END_PIECE; x++){
                for(int y = 0; y < END_PIECE; y++){
                    for(int z = 0; z < END_PIECE; z++){
                        newBox[x + leftShift][y + forwardShift][z + downwardShift] = oldCube[x + leftShift][y + forwardShift][z + downwardShift] + piece[x][y][z];
                    }
                }
            }
        }
        return newBox;
    }
    
    public boolean canPlacePiece(int[][][] oldcube, Piece piece, int leftShift, int forwardShift, int downwardShift){
        boolean cannotPlace = true;
        int [][][] tempCube = new int[10][10][10];
        tempCube = insertPiece(oldcube, piece.getPiece(), leftShift, forwardShift, downwardShift,false);
        for(int i = 0; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    for(int k = 0; k < 10; k++){
                        if(tempCube[i][j][k] > 1){
                            cannotPlace = false;
                        }
                    }
                }
        }
        return cannotPlace;
        //return (checkBoxCollision(box) || checkPieceCollision(box));
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
                    possibleNewBox = box.insertPiece(tempBox2, piece.getPiece(), x, y, z);

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
    // public int[][][] test(){
    //     int[][][] tempint = functionRunner.getTetrisCube();
    //     Piece tempPiece;
    //     for(int i = 0; i < 12; i++){
    //         tempPiece = obj1.pieceDictionary.get(obj1.getKeyList().get(i));
    //         tempint = iterateThroughPositions(this.tetrisCube, tempPiece, tempPiece.getX(), tempPiece.getY(), tempPiece.getZ());
    //         this.tetrisCube = tempint;
    //     }
    //     return this.tetrisCube;
    // }

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

     // public int[][][] getSolutions(int shift){ 
    //     test2(shift);
    //     if(functionRunner.fullBox(tetrisCube)){
    //         return tetrisCube;
    //     }
    //     functionRunner.removePiece(tetrisCube, tempPiece.getPiece(), tempPiece.getX(), tempPiece.getY(), tempPiece.getZ());
    //     counter++;
    //     System.out.println("iteration: " + this.counter);
    //     return getSolutions(shift);
    // }

    // public Solutions(Piece obj1){
    //     this.obj1 = obj1;
    // }

    // public int[][][] test2(int shift){
    //     int[][][] tempint = functionRunner.getBox();
    //     for(int i = 0; i < 12; i++){
    //         tempPiece = obj1.pieceDictionary.get(obj1.getKeyList().get(i));
    //         ArrayList<Piece> rotations = Rotations.getAllRotations(tempPiece);
    //         for (Piece currentPiece : rotations) {
    //             tempint = iterateThroughPositions(this.tetrisCube, currentPiece, tempPiece.getX(), tempPiece.getY(), tempPiece.getZ() + shift);
    //             if(tempint != null){
    //                 this.tetrisCube = tempint;
    //                 break;
    //             }
    //         }
    //     }
    //     return this.tetrisCube;
    // }

    //returns the box that stores all the pieces
    

    //future stuff




    //checks to see if solution is unique
    // public boolean uniqueSolutions(){

    // } 
}
