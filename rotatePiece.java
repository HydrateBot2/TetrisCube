
public class rotatePiece extends Box{
    // Rotates the 3D int array 90 degrees around the X-axis
    public static int[][][] rotateX(int[][][] array) {
        int n = array.length;
        int m = array[0].length;
        int p = array[0][0].length;
        int[][][] rotated = new int[n][p][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                    rotated[i][k][m - j - 1] = array[i][j][k];
                }
            }
        }
        return rotated;
    }

    // Rotates the 3D int array 90 degrees around the Y-axis
    public static int[][][] rotateZ(int[][][] array) {
        int n = array.length;
        int m = array[0].length;
        int p = array[0][0].length;
        int[][][] rotated = new int[p][m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                    rotated[k][j][n - i - 1] = array[i][j][k];
                }
            }
        }
        return rotated;
    }

    // Rotates the 3D int array 90 degrees around the Z-axis
    public static int[][][] rotateY(int[][][] array) {
        int n = array.length;
        int m = array[0].length;
        int p = array[0][0].length;
        int[][][] rotated = new int[m][n][p];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                    rotated[j][n - i - 1][k] = array[i][j][k];
                }
            }
        }
        return rotated;
    }

    // Method to print the 3D int array for testing
    public static void printArray(int[][][] array) {
        int n = array.length;
        int m = array[0].length;
        int p = array[0][0].length;

        for (int i = 0; i < n; i++) {
            System.out.println("Layer " + i + ":");
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}
