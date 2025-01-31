public class Harbor {
    private ResourceType resourceType;
    private int inputAmount;
    private int outputAmount;

    public Harbor(ResourceType resourceType, int inputAmount, int outputAmount) {
        this.resourceType = resourceType;
        this.inputAmount = inputAmount;
        this.outputAmount = outputAmount;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public int getInputAmount() {
        return inputAmount;
    }

    public int getOutputAmount() {
        return outputAmount;
    }
}
