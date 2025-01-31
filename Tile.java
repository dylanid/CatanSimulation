public class Tile {
    Tile[] neighboringTiles;
    ResourceType resourceType;
    Piece[][] pieces;
    int numberToken;

    public Tile() {
        this.neighboringTiles = new Tile[6];
        this.resourceType = null;
        this.pieces = new Piece[6][2];
        this.numberToken = 0;
    }

    public Tile(ResourceType resourceType, int numberToken) {
        this.neighboringTiles = new Tile[6];
        this.resourceType = resourceType;
        this.pieces = new Piece[6][2];
        this.numberToken = numberToken;
    }

    public Tile(Tile[] neighboringTiles) {
        this.neighboringTiles = neighboringTiles;
        this.resourceType = null;
        this.pieces = new Piece[6][2];
        this.numberToken = 0;
    }

    public Tile(Tile[] neighboringTiles, ResourceType resourceType) {
        this.neighboringTiles = neighboringTiles;
        this.resourceType = resourceType;
        this.pieces = new Piece[6][2];
        this.numberToken = 0;
    }

    public Tile[] getNeighboringTiles() {
        return neighboringTiles;
    }

    public void setNeighboringTiles(Tile[] neighboringTiles) {
        this.neighboringTiles = neighboringTiles;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void placePiece(Piece piece, int position) {
        if (piece.getPieceType() == PieceType.ROAD) {
            pieces[position][0] = piece;
            return;
        }
        pieces[position][1] = piece;
    }

    public String toString() {
        if (resourceType == null) {
            return "DESERT";
        }
        return numberToken + "-" + resourceType.toString();
    }
}