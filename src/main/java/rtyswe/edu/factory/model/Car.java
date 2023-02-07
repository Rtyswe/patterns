package rtyswe.edu.factory.model;

import rtyswe.edu.factory.exeptions.DuplicateModelNameException;
import rtyswe.edu.factory.exeptions.ModelPriceOutOfBoundsException;
import rtyswe.edu.factory.exeptions.NoSuchModelNameException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class Car implements Vehicle, Serializable {
    private String brand;

    private Model [] models;

    public Car() {
        models = new Model[0];
    }

    public Car(String brand, int numberOfModels) {
        this.brand = brand;
        Random random = new Random();

        models = new Model[numberOfModels];
        for(int i = 0; i < numberOfModels; i++) {
            Model newModel = new Model("Model #" + (i+1), ((int)(random.nextDouble() * 10000)) / 100.);
            models[i] = newModel;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Model getModelByName(String name) throws NoSuchModelNameException {
        Model model = Arrays.stream(models)
                .filter(el -> name.equals(el.getName()))
                .findAny()
                .orElse(null);
        if (model == null) {
            throw new NoSuchModelNameException("Model with such name doesn't exist.", name);
        }
        return model;
    }

    public int getModelIndexByName(String name) {
        return IntStream.range(0, models.length)
                .filter(i -> name.equals(models[i].getName()))
                .findFirst()
                .orElse(-1);
    }

    public void addModel(String name, double price) throws DuplicateModelNameException {
        if(price < 0.0) {
            throw new ModelPriceOutOfBoundsException("Illegal price!", price);
        }
        Model existingModel = Arrays.stream(models)
                .filter(model -> name.equals(model.getName()))
                .findAny()
                .orElse(null);
        if (existingModel != null) {
            throw new DuplicateModelNameException("Model with such name already exist!", name);
        }

        models = Arrays.copyOf(models, models.length + 1);
        models[models.length - 1] = new Model(name, price);
    }

    public String[] getModelNames() {
        return Arrays.stream(models).map(Model::getName).toArray(String[]::new);
    }

    public double getModelPriceByName(String modelName) throws NoSuchModelNameException {
        return getModelByName(modelName).getPrice();
    }

    public void setModelPriceByName(String modelName, double price) throws NoSuchModelNameException {
        if (price < 0.0) {
            throw new ModelPriceOutOfBoundsException("Illegal price!", price);
        }
        getModelByName(modelName).setPrice(price);
    }

    public double[] getModelPrices() {
        return Arrays.stream(models).mapToDouble(Model::getPrice).toArray();
    }

    public void removeModelByName(String name) {
        int index = getModelIndexByName(name);

        System.arraycopy(models, index + 1, models, index, models.length - index - 1);
        models = Arrays.copyOf(models, models.length - 1);
    }

    public int getSize() {
        return models.length;
    }

    @Override
    public void setModelNameByModelName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        if (Arrays.stream(models).noneMatch(model -> model.getName().equals(oldName))) {
            throw new NoSuchModelNameException("exception", oldName);
        }
        if (oldName.equals(newName)) {
            return;
        }
        if (Arrays.stream(models).anyMatch(model -> model.getName().equals(newName))) {
            throw new DuplicateModelNameException("exception", newName);
        }
        Arrays.stream(models).forEach((model) -> {
            if (model.getName().equals(oldName)) {
                model.setName(newName);
            }
        });
    }

    public Model[] getModels() {
        return models;
    }
    
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Brand: ").append(brand).append("\n");
        for (Model model: models) {
            res.append(model.toString());
        }
        return res.toString();
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        Car car = (Car) super.clone();
        car.models = Arrays.stream(models).map(Model::clone).toArray(Model[]::new);
        return car;
    }

    private static class Model implements Serializable, Cloneable {
        private String name;

        private double price;

        public Model(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Model model = (Model) o;
            return Double.compare(model.price, price) == 0 && Objects.equals(name, model.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price);
        }
        
        @Override
        public String toString() {
            return "[Name: " + name + ", Price: " + price + "]\n";
        }

        @Override
        protected Model clone() {
            try {
                return (Model) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
