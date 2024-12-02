import java.util.ArrayList;
import java.util.HashSet;

public class Rotations {
    static Piece tempPiece;

    public static ArrayList<Piece> getAllRotations(Piece piece) {
        ArrayList<Piece> rotationsList = new ArrayList<>();
        HashSet<String> uniqueRotations = new HashSet<>();
        tempPiece = piece;

        int[][][] originalPiece = piece.getPiece();
        int N = originalPiece.length;

        // For each face (0 to 5)
        for (int face = 0; face < 6; face++) {
            int[][][] rotatedPiece = rotateToBottom(originalPiece, face);

            // Rotate around Z-axis by 0, 90, 180, 270 degrees
            for (int i = 0; i < 4; i++) {
                int degrees = i * 90;
                int[][][] finalRotatedPiece = rotateZ(rotatedPiece, degrees);

                String serialized = serializePiece(finalRotatedPiece);

                if (!uniqueRotations.contains(serialized)) {
                    uniqueRotations.add(serialized);

                    // Create a new Piece object with the rotated piece
                    Piece newPiece = new Piece(piece.getX(), piece.getY(), piece.getZ(), degrees, finalRotatedPiece, piece.getName());
                    rotationsList.add(newPiece);
                }
            }
        }

        return rotationsList;
    }

    // Rotates the piece to bring the specified face to the bottom
    public static int[][][] rotateToBottom(int[][][] piece, int face) {
        int[][][] rotated = piece;

        switch (face) {
            case 0: // Original bottom face
                // No rotation needed
                break;
            case 1: // Original top face
                rotated = rotateX(rotated, 180);
                break;
            case 2: // Original front face
                rotated = rotateX(rotated, 90);
                break;
            case 3: // Original back face
                rotated = rotateX(rotated, 270);
                break;
            case 4: // Original left face
                rotated = rotateY(rotated, 270);
                break;
            case 5: // Original right face
                rotated = rotateY(rotated, 90);
                break;
        }

        return rotated;
    }

    // Rotates around X-axis by the specified degrees
    public static int[][][] rotateX(int[][][] piece, int degrees) {
        int rotations = (degrees / 90) % 4;
        int[][][] rotated = piece;

        for (int i = 0; i < rotations; i++) {
            rotated = rotateX90(rotated);
        }

        return rotated;
    }

    // Rotates around Y-axis by the specified degrees
    public static int[][][] rotateY(int[][][] piece, int degrees) {
        int rotations = (degrees / 90) % 4;
        int[][][] rotated = piece;

        for (int i = 0; i < rotations; i++) {
            rotated = rotateY90(rotated);
        }

        return rotated;
    }

    // Rotates around Z-axis by the specified degrees
    public static int[][][] rotateZ(int[][][] piece, int degrees) {
        int rotations = (degrees / 90) % 4;
        int[][][] rotated = piece;

        for (int i = 0; i < rotations; i++) {
            rotated = rotateZ90(rotated);
        }

        return rotated;
    }

    // Rotate around X-axis by 90 degrees
    public static int[][][] rotateX90(int[][][] piece) {
        int N = piece.length;
        int[][][] rotated = new int[N][N][N];

        for (int z = 0; z < N; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    rotated[z][y][x] = piece[N - 1 - y][z][x];
                }
            }
        }
        return rotated;
    }

    // Rotate around Y-axis by 90 degrees
    public static int[][][] rotateY90(int[][][] piece) {
        int N = piece.length;
        int[][][] rotated = new int[N][N][N];

        for (int z = 0; z < N; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    rotated[z][y][x] = piece[z][N - 1 - x][y];
                }
            }
        }
        return rotated;
    }

    // Rotate around Z-axis by 90 degrees
    public static int[][][] rotateZ90(int[][][] piece) {
        int N = piece.length;
        int[][][] rotated = new int[N][N][N];

        for (int z = 0; z < N; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    rotated[z][y][x] = piece[y][N - 1 - x][z];
                }
            }
        }
        return rotated;
    }

    // Serialize the 3D array to a string for comparison
    public static String serializePiece(int[][][] piece) {
        StringBuilder sb = new StringBuilder();
        int N = piece.length;

        for (int z = 0; z < N; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    sb.append(piece[z][y][x]);
                }
            }
        }

        return sb.toString();
    }

    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Piece Name: ").append(tempPiece.getName()).append("\n");
    sb.append("Start Position: (").append(tempPiece.getX()).append(", ")
      .append(tempPiece.getY()).append(", ").append(tempPiece.getZ()).append(")\n");
    sb.append("Rotation: ").append(tempPiece.getRotation()).append(" degrees\n");
    sb.append("Piece Structure:\n");

    int[][][] pieceArray = tempPiece.getPiece();

    // Iterate over the Z-axis (layers)
    for (int z = 0; z < pieceArray.length; z++) {
        sb.append("Layer Z = ").append(z).append(":\n");
        // Iterate over the Y-axis (rows)
        for (int y = 0; y < pieceArray[z].length; y++) {
            // Iterate over the X-axis (columns)
            for (int x = 0; x < pieceArray[z][y].length; x++) {
                sb.append(pieceArray[z][y][x]).append(" ");
            }
            sb.append("\n"); // Newline after each row
        }
        sb.append("\n"); // Extra newline after each layer
    }
    return sb.toString();
}




}
