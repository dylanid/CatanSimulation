public class Tile {
    Tile[] adjacentTiles;
    ResourceType resourceType;
    Piece[] roads;
    Piece[] settlements;
    int numberToken;

    public Tile() {
        this.adjacentTiles = new Tile[6];
        this.resourceType = null;
        this.roads = new Piece[6];
        this.settlements = new Piece[6];
        this.numberToken = 0;
    }

    public Tile(ResourceType resourceType, int numberToken) {
        this.adjacentTiles = new Tile[6];
        this.resourceType = resourceType;
        this.roads = new Piece[6];
        this.settlements = new Piece[6];
        this.numberToken = numberToken;
    }

    public Tile(Tile[] adjacentTiles) {
        this.adjacentTiles = adjacentTiles;
        this.resourceType = null;
        this.roads = new Piece[6];
        this.settlements = new Piece[6];
        this.numberToken = 0;
    }

    public Tile(Tile[] adjacentTiles, ResourceType resourceType) {
        this.adjacentTiles = adjacentTiles;
        this.resourceType = resourceType;
        this.roads = new Piece[6];
        this.settlements = new Piece[6];
        this.numberToken = 0;
    }

    public Tile[] getAdjacentTiles() {
        return adjacentTiles;
    }

    public void setAdjacentTilesTiles(Tile[] adjacentTiles) {
        this.adjacentTiles = adjacentTiles;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void placePiece(Piece piece, int position) {
        if (piece.getPieceType() == PieceType.ROAD) {
            roads[position] = piece;
            return;
        }
        settlements[position] = piece;
    }

    public String toString() {
        if (resourceType == null) {
            return "DES";
        }
        return numberToken + "-" + resourceType.toString().substring(0,3);
    }

    public void printAdjacentTiles() {
        for (Tile tile : adjacentTiles) {
            System.out.println(tile);
        }
        System.out.println();
    }
}