public class DevelopmentCard {
    DevelopmentCardType developmentCardType;

    public DevelopmentCard(DevelopmentCardType developmentCardType) {
        this.developmentCardType = developmentCardType;
    }

    public DevelopmentCardType getType() {
        return developmentCardType;
    }

    public String toString() {
        return developmentCardType.toString();
    }
}
