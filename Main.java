public class Main{
        public static void main(String[] args){
        readFile obj1 = new readFile("Pieces.txt");
        obj1.pieceInitializer(obj1.getTxtFileByLine());
        System.out.println(obj1.getDict().toString());
        System.out.println(obj1.getDict().get("^sword, red")[0][0][0]);
        while(obj1.getKeyList().hasMoreElements()){
            int[][][] test = obj1.getDict().get(obj1.getKeyList().nextElement());
            for(int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    for (int k = 0; k < 4; k++){
                        System.out.print(test[i][j][k]);
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }

    }
    }