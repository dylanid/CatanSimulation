package board;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import enums.ResourceType;
import simulation.GameConstants;

public class Board {
    private Tile[][] tiles;
    private Random random = new Random();

    public Board() {
        // Generate list of number tokens
        List<Integer> numberTokensLeft = new ArrayList<>();
        for (int number : GameConstants.NUMBER_TOKENS) {
            numberTokensLeft.add(number);
        }
        Collections.shuffle(numberTokensLeft, random);

        // Generate list of tiles with resource types and number tokens
        List<Tile> tilesLeft = new ArrayList<>();
        for (Map.Entry<ResourceType, Integer> entry : GameConstants.TILE_RESOURCE_AMOUNTS.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                int numberToken = numberTokensLeft.remove(0);
                tilesLeft.add(new Tile(entry.getKey(), numberToken));
            }
        }
        tilesLeft.add(new Tile()); // Add the desert tile

        // Create arrays for each row of the board.
        tiles = new Tile[5][];
        tiles[0] = new Tile[3];
        tiles[1] = new Tile[4];
        tiles[2] = new Tile[5];
        tiles[3] = new Tile[4];
        tiles[4] = new Tile[3];
        
        // Populate each row with a randomly selected tile.
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[x].length; y++) {
                Tile currentTile = tilesLeft.remove(random.nextInt(tilesLeft.size()));
                tiles[x][y] = currentTile;
            }
        }

        // Assign adjacent tiles for each tile.
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[x].length; y++) {
                assignAdjacentTiles(x, y);
            }
        }

        // Setup the harbor tiles
        if (GameConstants.RANDOMIZE_HARBOR_TILES) {
            // Add randomization logic later
            
        } else {
            tiles[0][0].setHarbors(new Harbor[]{GameConstants.HARBOR_PIECES[0], GameConstants.HARBOR_PIECES[0], null, null, null, null});
            tiles[0][1].setHarbors(new Harbor[]{null, GameConstants.HARBOR_PIECES[1], GameConstants.HARBOR_PIECES[1], null, null, null});
            tiles[0][2].setHarbors(new Harbor[]{GameConstants.HARBOR_PIECES[1], null, null, GameConstants.HARBOR_PIECES[2], null, null});
            tiles[1][0].setHarbors(new Harbor[]{GameConstants.HARBOR_PIECES[8], null, null, null, null, GameConstants.HARBOR_PIECES[8]});
            tiles[1][1].setHarbors(new Harbor[]{null, null, null, null, null, null});
            tiles[1][2].setHarbors(new Harbor[]{null, null, null, null, null, null});
            tiles[1][3].setHarbors(new Harbor[]{null, GameConstants.HARBOR_PIECES[2], GameConstants.HARBOR_PIECES[2], null, null, null});
            tiles[2][0].setHarbors(new Harbor[]{null, GameConstants.HARBOR_PIECES[8], null, null, GameConstants.HARBOR_PIECES[7], null});
            tiles[2][1].setHarbors(new Harbor[]{null, null, null, null, null, null});
            tiles[2][2].setHarbors(new Harbor[]{null, null, null, null, null, null});
            tiles[2][3].setHarbors(new Harbor[]{null, null, null, null, null, null});
            tiles[2][4].setHarbors(new Harbor[]{null, null, GameConstants.HARBOR_PIECES[3], GameConstants.HARBOR_PIECES[3], null, null});
            tiles[3][0].setHarbors(new Harbor[]{GameConstants.HARBOR_PIECES[7], null, null, null, null, GameConstants.HARBOR_PIECES[7]});
            tiles[3][1].setHarbors(new Harbor[]{null, null, null, null, null, null});
            tiles[3][2].setHarbors(new Harbor[]{null, null, null, null, null, null});
            tiles[3][3].setHarbors(new Harbor[]{null, null, null, GameConstants.HARBOR_PIECES[4], GameConstants.HARBOR_PIECES[4], null});
            tiles[4][0].setHarbors(new Harbor[]{null, null, null, null, GameConstants.HARBOR_PIECES[6], GameConstants.HARBOR_PIECES[6]});
            tiles[4][1].setHarbors(new Harbor[]{null, null, null, GameConstants.HARBOR_PIECES[5], GameConstants.HARBOR_PIECES[5], null});
            tiles[4][2].setHarbors(new Harbor[]{null, null, GameConstants.HARBOR_PIECES[4], null, null, GameConstants.HARBOR_PIECES[5]});
        }
    }

    private int getQMin(int x) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return -1;
        } else {
            return -2;
        }
    }

    private void assignAdjacentTiles(int x, int y) {
        Tile currentTile = tiles[x][y];
        int axialR = x - 2;
        int qMin = getQMin(x);
        int axialQ = y + qMin;

        int[][] axialDirections = {
            {-1, 0},  // top left
            {0, -1},  // top right
            {1, -1},  // right
            {1, 0},    // bottom right
            {0, 1},   // bottom left
            {-1, 1},  // left
        };


        for (int i = 0; i < axialDirections.length; i++) {
            int dq = axialDirections[i][0];
            int dr = axialDirections[i][1];

            int neighborAxialQ = axialQ + dq;
            int neighborAxialR = axialR + dr;

            int neighborX = neighborAxialR + 2;
            if (neighborX < 0 || neighborX >= tiles.length) {
                continue;
            }
            int neighborQMin = getQMin(neighborX);
            int neighborY = neighborAxialQ - neighborQMin;
            if (neighborY < 0 || neighborY >= tiles[neighborX].length) {
                continue;
            }
            currentTile.adjacentTiles[(i + 5) % 6] = tiles[neighborX][neighborY];
        }
    }

    public String toString() {
        String output = "";
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[x].length; y++) {
                output += "\n" + tiles[x][y] + "\n Harbors: " + tiles[x][y].getHarborsAsString() + " Settlements: " + tiles[x][y].getSettlementsAsString() + " Roads: " + tiles[x][y].getRoadsAsString() + " Adjacent Tiles: " + tiles[x][y].getAdjacentTilesAsString();
            }
        }
        return output;
    }

    

    public void printBoard() {
        System.out.println("Board Layout:\n");
        for (int x = 0; x < tiles.length; x++) {
            if (x == 0 || x == 4) {
                System.out.print(" ".repeat(10));
            }
            if (x == 1 || x == 3) {
                System.out.print(" ".repeat(5));
            }
            for (int y = 0; y < tiles[x].length; y++) {
                System.out.printf("%10s", tiles[x][y]);
            }
            System.out.print("\n".repeat(3));
        }
    }
}
