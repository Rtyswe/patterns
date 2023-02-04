package rtyswe.edu.factory.exeptions;

public class NoSuchModelNameException extends Exception{
    private final String modelName;

    public String getModelName() {
        return modelName;
    }

    public NoSuchModelNameException(String message, String modelName){
        super(message);
        this.modelName = modelName;
    }
}
