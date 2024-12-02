
public class Main{
        public static void main(String[] args){

        // Initialization    
        readFile fileByLine = new readFile("Pieces.txt");
        Piece pieces = new Piece();
        pieces.pieceInitializer(fileByLine.getTxtFileByLine());
        System.out.println(pieces.keyList);
        System.out.println(pieces.keyList);
        Solutions test = new Solutions(pieces);
        Rotations rotate1 = new Rotations();
        Piece tempPiece = pieces.getParticularPiece();

        // test.getSolutions();

        // test for putting one piece in all rotations.



        // ArrayList<Piece> allRotations = Rotations.getAllRotations(tempPiece);

        // int rotationCount = 1;
        // for (Piece rotatedPiece : allRotations) {
        //     System.out.println("Rotation " + rotationCount + ":");
        //     System.out.println(rotatedPiece.toString());
        //     System.out.println("-----------------------------------\n");
        //     rotationCount++;
        // }

        // for(int i = 0; i < Rotations.getAllRotations(tempPiece).size(); i++){
        //     System.out.println(Rotations.getAllRotations(tempPiece).get(i));
        // }

        // initial test
        // test.test();
        // for(int i = 0; i < 10; i++){
        //     for(int j = 0; j < 10; j++){
        //         for(int k = 0; k < 10; k++){
        //         System.out.print(test.getTetrisCube()[i][j][k]);
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        // }
        // System.out.println(test.getpieceinsert());

        test.getSolutions(1);
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 10; k++){
                System.out.print(test.getTetrisCube()[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }


        //prior tests


        // int[][][] testRotate = rotatePiece.rotateZ(Pieces.getDict().get("^sword, red"));
        // for(int i = 0; i < 4; i++){
        //     for(int j = 0; j < 4; j++){
        //         for(int k = 0; k < 4; k ++){
        //             System.out.print(testRotate[i][j][k]);
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        // }
        // // for(int i = 0; i < 4; i++){
        // //     for(int j = 0; j < 4; j++){
        // //         for(int k = 0; k < 4; k ++){
        // //             System.out.print(Pieces.getDict().get("^sword, red")[i][j][k]);
        // //         }
        // //         System.out.println();
        // //     }
        // //     System.out.println();
        // // }
        // // testRotate = rotatePiece.rotateZ(testRotate);
        // for(int i = 0; i < 4; i++){
        //     for(int j = 0; j < 4; j++){
        //         for(int k = 0; k < 4; k ++){
        //             System.out.print(testRotate[i][j][k]);
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        //}



    }
    }