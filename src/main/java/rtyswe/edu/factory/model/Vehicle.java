package rtyswe.edu.factory.model;

import rtyswe.edu.factory.exeptions.DuplicateModelNameException;
import rtyswe.edu.factory.exeptions.NoSuchModelNameException;

public interface Vehicle extends Cloneable {
    void addModel(String name, double price) throws DuplicateModelNameException;

    String [] getModelNames();

    double getModelPriceByName(String modelName) throws NoSuchModelNameException;

    void setModelPriceByName(String modelName, double price) throws NoSuchModelNameException;

    double [] getModelPrices();

    void removeModelByName(String name) throws NoSuchModelNameException;

    int getSize();

    String getBrand();

    void setBrand(String brand);

    void setModelNameByModelName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException;
}