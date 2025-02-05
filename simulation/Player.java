package simulation;
import java.util.ArrayList;

import cards.DevelopmentCard;
import cards.ResourceCard;
import enums.Color;
import enums.DevelopmentCardType;
import enums.ResourceType;

public class Player {
    private Color color;
    private ArrayList<ResourceCard> resourceCards;
    private ArrayList<DevelopmentCard> developmentCards;

    public Player(Color color) {
        this.color = color;
    }

    public ArrayList<ResourceCard> getResourceCards() {
        return resourceCards;
    }

    public ArrayList<DevelopmentCard> getDevelopmentCards() {
        return developmentCards;
    }

    public ArrayList<ResourceCard> getResourceCards(ResourceType resourceType) {
        ArrayList<ResourceCard> validCards = new ArrayList<ResourceCard>();
        for (ResourceCard resourceCard : resourceCards) {
            if (resourceCard.getType() == resourceType) {
                validCards.add(resourceCard);
            }
        }
        return validCards;
    }

    public ArrayList<DevelopmentCard> getDevelopmentCards(DevelopmentCardType DevelopmentType) {
        ArrayList<DevelopmentCard> validCards = new ArrayList<DevelopmentCard>();
        for (DevelopmentCard DevelopmentCard : developmentCards) {
            if (DevelopmentCard.getType() == DevelopmentType) {
                validCards.add(DevelopmentCard);
            }
        }
        return validCards;
    }

    public void addResourceCard(ResourceCard resourceCard) {
        resourceCards.add(resourceCard);
    }

    public void addDevelopmentCard(DevelopmentCard developmentCard) {
        developmentCards.add(developmentCard);
    }

    public void removeResourceCard(ResourceCard resourceCard) {
        resourceCards.remove(resourceCard);
    }

    public void removeDevelopmentCard(DevelopmentCard developmentCard) {
        developmentCards.remove(developmentCard);
    }

    public String toString() {
        return color.toString() + " | Resources: " + resourceCards + " Development Cards: " + developmentCards;
    }
}
