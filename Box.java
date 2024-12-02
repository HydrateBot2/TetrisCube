

public class Box{
    final int START_BOX = 3;
    final int END_BOX = 8;
    final int END_PIECE = 4;


    //Box template
    int[][][] box = {
        {
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}
        },
        {
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}
        },
        {
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}
        },
        {
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,0,0,0,0,1,1,1},
            {1,1,1,0,0,0,0,1,1,1},
            {1,1,1,0,0,0,0,1,1,1},
            {1,1,1,0,0,0,0,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}
        },
        {
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,0,0,0,0,1,1,1},
            {1,1,1,0,0,0,0,1,1,1},
            {1,1,1,0,0,0,0,1,1,1},
            {1,1,1,0,0,0,0,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}
        },
        {
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,0,0,0,0,1,1,1},
            {1,1,1,0,0,0,0,1,1,1},
            {1,1,1,0,0,0,0,1,1,1},
            {1,1,1,0,0,0,0,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}
        },
        {
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,0,0,0,0,1,1,1},
            {1,1,1,0,0,0,0,1,1,1},
            {1,1,1,0,0,0,0,1,1,1},
            {1,1,1,0,0,0,0,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}
        },
        {
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}
        },
        {
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}
        },
        {
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}
        }
    };
    
    /* Inserts a piece with a given starting position into the box
     * takes in the box, the piece thats being placed, the the forward, left, and downward shift(aka starting POS)
     * returns the box with the piece inside of it
     */

    public int[][][] insertPiece(int[][][] oldCube, int[][][] piece, int leftShift, int forwardShift, int downwardShift){
        int[][][] newBox = new int[10][10][10];
        for (int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 10; k++){
                    newBox[i][j][k] = oldCube[i][j][k];
                }
            }
        }

        for(int x = 0; x < END_PIECE; x++){
            for(int y = 0; y < END_PIECE; y++){
                for(int z = 0; z < END_PIECE; z++){
                    newBox[x + leftShift][y + forwardShift][z + downwardShift] = oldCube[x + leftShift][y + forwardShift][z + downwardShift] + piece[x][y][z];
                }
            }
        }
        // System.out.println(newBox[2][2][2] + " n ");
        // System.out.println(oldCube[2][2][2] + " o ");
        return newBox;
    }

    /*Combination of both checkBoxCollision and checkPieceCollision(See below)
    * returns true if piece is colliding with either the box or another piece
    * returns false if no collision is detected
    */
    public boolean checkCollision(int[][][] box){
        boolean cannotPlace = false;
        for(int i = 0; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    for(int k = 0; k < 10; k++){
                        if(box[i][j][k] > 1){
                            cannotPlace = true;
                        }
                    }
                }
        }
        return cannotPlace;
        //return (checkBoxCollision(box) || checkPieceCollision(box));
    }




    /* Checks piece collision with box(i.e theres a 2 outside of the 4x4x4) 
     * return a boolean cannotPlace
     * returns true if the piece cannot be placed(i.e theres a 2 outside the box)
     * or false if the piece can be placed
    */


    public boolean checkBoxCollision(int[][][] box){
        boolean cannotPlace = false;
        for(int i = 0; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    for(int k = 0; k < 10; k++){
                        if(box[i][j][k] >= 1){
                            cannotPlace = true;
                        }
                    }
                }
        }
        return cannotPlace;
    }

    /*Checks to see if placed pieces are colliding with each other
     * returns a boolean, true if two pieces are on top of each(i.e a 2 in any spot)
     * returns false if the place does not collide with any piece.
     */
    public boolean checkPieceCollision(int[][][] box){
        boolean cannotplace = false; 

        for(int i = START_BOX; i < END_BOX; i++){
            for(int j = START_BOX; j < END_BOX; j++){
                for(int k = START_BOX; k < END_BOX; k++){
                    if(box[i][j][k] >= 1){
                        cannotplace = true;
                    }
                }
            }
        }
        return cannotplace;
    }


    //returns the box in this class, Box.java
    public int[][][] getBox(){
        return this.box;
    }

    
    
    
}