package rtyswe.edu.exeptions;

public class DuplicateModelNameException extends Exception{
    private final String modelName;

    public String getModelName() {
        return modelName;
    }

    public DuplicateModelNameException(String message, String modelName){
        super(message);
        this.modelName = modelName;
    }
}
