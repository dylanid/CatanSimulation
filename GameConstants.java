import java.util.Map;

public final class GameConstants {
    public static final int POINTS_TO_WIN = 10;

    public static final int TILES_AMOUNT = 19;
    public static final Map<ResourceType, Integer> TILE_RESOURCE_AMOUNTS = Map.of(
        ResourceType.BRICK, 3,
        ResourceType.GRAIN, 4,
        ResourceType.LUMBER, 4,
        ResourceType.ORE, 3,
        ResourceType.WOOL, 4
    );

    public static final int SEA_FRAMES_AMOUNT = 6;
    public static final int HARBOR_PIECES_AMOUNT = 9;
    public static final Harbor[] HARBOR_PIECES = {
        new Harbor(null, 3, 1),
        new Harbor(ResourceType.GRAIN, 2, 1),
        new Harbor(ResourceType.ORE, 2, 1),
        new Harbor(null, 3, 1),
        new Harbor(ResourceType.WOOL, 2, 1),
        new Harbor(null, 3, 1),
        new Harbor(null, 3, 1),
        new Harbor(ResourceType.BRICK, 2, 1),
        new Harbor(ResourceType.LUMBER, 2, 1),
    };

    public static final int NUMBER_TOKENS_AMOUNT = 18;
    public static final int[] NUMBER_TOKENS = {
        2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 9, 9, 10, 10, 11, 11, 12
    };

    public static final int RESOURCE_CARDS_AMOUNT = 95;
    public static final Map<ResourceType, Integer> RESOURCE_CARDS = Map.of(
        ResourceType.BRICK, 19,
        ResourceType.GRAIN, 19,
        ResourceType.LUMBER, 19,
        ResourceType.ORE, 19,
        ResourceType.WOOL, 19
    );
    
    public static final int DEVELOPMENT_CARDS_AMOUNT = 25;
    public static final Map<DevelopmentCardType, Integer> DEVELOPMENT_CARDS = Map.of(
        DevelopmentCardType.KNIGHT, 14,
        DevelopmentCardType.VICTORY_POINT, 5,
        DevelopmentCardType.ROAD_BUILDING, 2,
        DevelopmentCardType.MONOPOLY, 2,
        DevelopmentCardType.YEAR_OF_PLENTY, 2
    );

    public static final int CITIES_AMOUNT = 16;
    public static final int CITIES_PER_PLAYER = 4;

    public static final int SETTLEMENTS_AMOUNT = 20;
    public static final int SETTLEMENTS_PER_PLAYER = 5;
    
    public static final int ROADS_AMOUNT = 60;
    public static final int ROADS_PER_PLAYER = 15;

    public static final int DICE_AMOUNT = 2;
    public static final int ROBBERS_AMOUNT = 1;
}
