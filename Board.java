import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Board {
    private Tile centerTile;
    private Random random = new Random();

    public Board() {
        // Step 1: Generate list of number tokens
        List<Integer> numberTokensLeft = new ArrayList<>();
        for (int number : BoardGenerationConstants.NUMBER_TOKENS) {
            numberTokensLeft.add(number);
        }
        Collections.shuffle(numberTokensLeft, random);

        // Step 2: Generate list of tiles with resource types and number tokens
        List<Tile> tilesLeft = new ArrayList<>();
        for (Map.Entry<ResourceType, Integer> entry : BoardGenerationConstants.TILE_RESOURCE_AMOUNTS.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                int numberToken = numberTokensLeft.remove(0);
                tilesLeft.add(new Tile(entry.getKey(), numberToken));
            }
        }
        tilesLeft.add(new Tile()); // Add the desert tile

        // Step 3: Place the center tile
        centerTile = tilesLeft.remove(random.nextInt(tilesLeft.size()));

        // Step 4: Create the first ring of tiles around the center (6 tiles)
        Tile[] firstRing = new Tile[6];
        for (int i = 0; i < 6; i++) {
            firstRing[i] = tilesLeft.remove(random.nextInt(tilesLeft.size()));
        }
        centerTile.setNeighboringTiles(firstRing);

        // Step 5: Connect the first ring of tiles to each other and the center
        for (int i = 0; i < 6; i++) {
            Tile currentTile = firstRing[i];
            Tile[] neighbors = new Tile[6];

            // Connect to the center tile
            neighbors[3] = centerTile;

            // Connect to adjacent first ring tiles
            neighbors[2] = firstRing[(i + 5) % 6]; // Left neighbor
            neighbors[4] = firstRing[(i + 1) % 6]; // Right neighbor

            currentTile.setNeighboringTiles(neighbors);
        }

        // Step 6: Create the second ring of tiles (12 tiles)
        List<Tile> secondRing = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            secondRing.add(tilesLeft.remove(random.nextInt(tilesLeft.size())));
        }

        // Step 7: Connect the second ring to the first ring and each other
        for (int i = 0; i < 12; i++) {
            Tile currentTile = secondRing.get(i);
            Tile[] neighbors = new Tile[6];

            // Connect to two first ring tiles
            int firstRingIndex = (i / 2) % 6;
            neighbors[0] = firstRing[firstRingIndex];
            neighbors[1] = firstRing[(firstRingIndex + 1) % 6];

            // Connect to adjacent second ring tiles
            neighbors[2] = secondRing.get((i + 1) % 12); // Next in the ring
            neighbors[4] = secondRing.get((i + 11) % 12); // Previous in the ring

            currentTile.setNeighboringTiles(neighbors);
        }

        // Step 8: Print the board for verification
        printBoard(firstRing, secondRing);
    }

    private void printBoard(Tile[] firstRing, List<Tile> secondRing) {
        System.out.println("Board Layout:\n");
    
        // Ensure the board is complete
        if (firstRing.length < 6 || secondRing.size() < 12) {
            System.out.println("Error: Board structure is incomplete.");
            return;
        }
    
        // Board layout:
        System.out.printf("       %s   %s   %s%n", secondRing.get(0), secondRing.get(1), secondRing.get(2));
        System.out.printf("    %s   %s   %s   %s%n", secondRing.get(11), firstRing[0], firstRing[1], secondRing.get(3));
        System.out.printf(" %s   %s   %s   %s   %s%n", secondRing.get(10), firstRing[5], centerTile, firstRing[2], secondRing.get(4));
        System.out.printf("    %s   %s   %s   %s%n", secondRing.get(9), firstRing[4], firstRing[3], secondRing.get(5));
        System.out.printf("       %s   %s   %s%n", secondRing.get(8), secondRing.get(7), secondRing.get(6));
    
        System.out.println("\nLegend: Each tile is represented by its resource type and number.");
    }
    

    public static void main(String[] args) {
        new Board();
    }
}
