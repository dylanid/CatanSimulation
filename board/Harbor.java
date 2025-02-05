package board;
import enums.ResourceType;

public class Harbor {
    private ResourceType resourceType;
    private int inputAmount;
    private int outputAmount;


    public Harbor(ResourceType resourceType, int inputAmount, int outputAmount) {
        this.resourceType = resourceType;
        this.inputAmount = inputAmount;
        this.outputAmount = outputAmount;
    }

    public ResourceType getType() {
        return resourceType;
    }

    public int getInputAmount() {
        return inputAmount;
    }

    public int getOutputAmount() {
        return outputAmount;
    }

    public String toString() {
        return resourceType.toString() + " " + inputAmount + ":" + outputAmount;
    }
}
