import java.util.ArrayList;
public class PieceRotated{
    private Piece piece;
    private String pieceName;
    private int currentPiece;
    private ArrayList<Piece> pieces;


    public PieceRotated(){
        
    }
    public PieceRotated(Piece piece, String pieceName) {
        this.piece = piece;
        this.pieceName = pieceName;
        this.currentPiece = 0;
        this.pieces = Rotations.getAllRotations(piece);
    }

    public Piece getRotationOfPiece(){
        return pieces.get(getCurrentPiece());

    }

    public int getCurrentPiece(){
        this.currentPiece++;
        return this.currentPiece - 1;
    }



    
}
