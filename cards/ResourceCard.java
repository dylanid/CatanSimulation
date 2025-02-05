package cards;
import enums.ResourceType;

public class ResourceCard {
    ResourceType resourceType;

    public ResourceCard(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public ResourceType getType() {
        return resourceType;
    }
}
