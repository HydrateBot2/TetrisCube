public class Main{
        public static void main(String[] args){

        // Initialization    
        readFile fileByLine = new readFile("Pieces.txt");
        Pieces Pieces = new Pieces();
        Pieces.pieceInitializer(fileByLine.getTxtFileByLine());

        int[][][] testRotate = rotatePiece.rotateZ(Pieces.getDict().get("^sword, red"));
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k ++){
                    System.out.print(testRotate[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
        // for(int i = 0; i < 4; i++){
        //     for(int j = 0; j < 4; j++){
        //         for(int k = 0; k < 4; k ++){
        //             System.out.print(Pieces.getDict().get("^sword, red")[i][j][k]);
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        // }
        // testRotate = rotatePiece.rotateZ(testRotate);
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k ++){
                    System.out.print(testRotate[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }



    }
    }