package board;

import enums.PieceType;
import enums.ResourceType;

public class Tile {
    Tile[] adjacentTiles;
    ResourceType resourceType;
    Piece[] roads;
    Piece[] settlements;
    Harbor[] harbors;
    int numberToken;

    public Tile() {
        this.adjacentTiles = new Tile[6];
        this.resourceType = null;
        this.roads = new Piece[6];
        this.settlements = new Piece[6];
        this.harbors = new Harbor[6];
        this.numberToken = 0;
    }

    public Tile(ResourceType resourceType, int numberToken) {
        this.adjacentTiles = new Tile[6];
        this.resourceType = resourceType;
        this.roads = new Piece[6];
        this.settlements = new Piece[6];
        this.harbors = new Harbor[6];
        this.numberToken = numberToken;
    }

    public Tile(Tile[] adjacentTiles) {
        this.adjacentTiles = adjacentTiles;
        this.resourceType = null;
        this.roads = new Piece[6];
        this.settlements = new Piece[6];
        this.harbors = new Harbor[6];
        this.numberToken = 0;
    }

    public Tile(Tile[] adjacentTiles, ResourceType resourceType) {
        this.adjacentTiles = adjacentTiles;
        this.resourceType = resourceType;
        this.roads = new Piece[6];
        this.settlements = new Piece[6];
        this.harbors = new Harbor[6];
        this.numberToken = 0;
    }

    public Tile[] getAdjacentTiles() {
        return adjacentTiles;
    }

    public void setAdjacentTiles(Tile[] adjacentTiles) {
        this.adjacentTiles = adjacentTiles;
    }

    public void setHarbors(Harbor[] harbors) {
        this.harbors = harbors;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public Harbor[] getHarbors() {
        return harbors;
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

    public void printHarbors() {
        for (Harbor harbor : harbors) {
            System.out.println(harbor);
        }
        System.out.println();
    }

    public void printAdjacentTiles() {
        for (Tile tile : adjacentTiles) {
            System.out.println(tile);
        }
        System.out.println();
    }

    public String getHarborsAsString() {
        String output = "";
        for (Harbor harbor : harbors) {
            output += harbor + " ";
        }
        output += "\n";
        return output;
    }

    public String getRoadsAsString() {
        String output = "";
        for (Piece piece : roads) {
            output += piece + " ";
        }
        output += "\n";
        return output;
    }

    public String getSettlementsAsString() {
        String output = "";
        for (Piece piece : settlements) {
            output += piece + " ";
        }
        output += "\n";
        return output;
    }
    
    public String getAdjacentTilesAsString() {
        String output = "";
        for (Tile tile : adjacentTiles) {
            output += tile + " ";
        }
        output += "\n";
        return output;
    }
}