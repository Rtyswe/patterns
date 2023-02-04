package rtyswe.edu.factory.exeptions;

public class ModelPriceOutOfBoundsException extends RuntimeException{
    private final double modelPrice;

    public double getModelPrice() {
        return modelPrice;
    }

    public ModelPriceOutOfBoundsException(String message, double modelPrice){
        super(message);
        this.modelPrice = modelPrice;
    }
}
