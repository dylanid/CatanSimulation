import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class Game {
    private Board board;
    private Stack<DevelopmentCard> developmentCards;
    private Map<ResourceType, Integer> resourceCards = new HashMap<>(GameConstants.RESOURCE_CARDS);
    private Player[] players;
    private Random random = new Random();

    public Game(int numPlayers) {
        board = new Board();
        players = new Player[numPlayers];

        // Assign players random colors
        Color[] temp = {Color.RED, Color.BLUE, Color.ORANGE, Color.WHITE};
        ArrayList<Color> possibleColors = new ArrayList<Color>(Arrays.asList(temp));
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player(possibleColors.remove(random.nextInt(possibleColors.size())));
        }

        // Create and shuffle a new deck of development cards
        ArrayList<DevelopmentCard> preShuffledDevelopmentCards = new ArrayList<DevelopmentCard>();
        for (Map.Entry<DevelopmentCardType, Integer> entry : GameConstants.DEVELOPMENT_CARDS.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                preShuffledDevelopmentCards.add(new DevelopmentCard(entry.getKey()));
            }
        }
        developmentCards = new Stack<DevelopmentCard>();
        for (int i = 0; i < GameConstants.DEVELOPMENT_CARDS_AMOUNT; i++) {
            developmentCards.add(preShuffledDevelopmentCards.get(random.nextInt(preShuffledDevelopmentCards.size())));
        }

        // Randomize the initial order of players
        List<Player> shuffledPlayers = new ArrayList<>(Arrays.asList(players));
        Collections.shuffle(shuffledPlayers, random);

        // Determine order in which players place their starting settlements.
        Player[] order = new Player[numPlayers * 2];
        for (int i = 0; i < numPlayers; i++) {
            order[i] = shuffledPlayers.get(i);
        }
        for (int i = 0; i < numPlayers; i++) {
            order[numPlayers + i] = shuffledPlayers.get(numPlayers - i - 1);
        }
        for (Player player : order) {
            System.out.println(player.toString());
        }
        
    }

    public void printPlayers() {
        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            System.out.println("Player " + i + ": " + player);
        }
    }

    public void printDevelopmentCards() {
        for (int i = 0; i < developmentCards.size(); i++) {
            DevelopmentCard developmentCard = developmentCards.get(i);
            System.out.println(developmentCard);
        }
    }
}
