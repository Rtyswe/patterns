package rtyswe.edu.factory.model;

import rtyswe.edu.factory.exeptions.DuplicateModelNameException;
import rtyswe.edu.factory.exeptions.ModelPriceOutOfBoundsException;
import rtyswe.edu.factory.exeptions.NoSuchModelNameException;

import java.io.Serializable;
import java.util.Random;

public class Motorcycle implements Vehicle, Serializable {
    private String brand;

    private int size = 0;

    private Model head;

    private transient long lastModified;

    {
        lastModified = System.currentTimeMillis();
    }

    public Motorcycle() {}

    public Motorcycle(String brand, int size) {
        this.brand = brand;
        this.size = size;

        Random random = new Random();
        if (size > 0) {
            head = new Model("Model #" + 1, ((int)(random.nextDouble() * 10000)) / 100.);
            head.next = head;
            head.prev = head;
        }
        Model curr = head;
        for (int i = 1; i < size; ++i) {
            curr.next = new Model("Model #" + (i+1), ((int)(random.nextDouble() * 10000)) / 100.);
            curr.next.prev = curr;
            curr = curr.next;
            curr.next = head;
        }
        head.prev = curr;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;

        lastModified = System.currentTimeMillis();
    }

    public Model getModelByName(String name) throws NoSuchModelNameException {
        Model currModel = head;
        for (int i = 0; i < size; i++, currModel = currModel.next) {
            if (currModel.getName().equals(name)) {
                return currModel;
            }
        }
        throw new NoSuchModelNameException("Model with such name doesn't exist.", name);
    }

    public void addModel(String name, double price) throws DuplicateModelNameException {
        if (price < 0.0) {
            throw new ModelPriceOutOfBoundsException("Illegal price!", price);
        }
        Model newModel = new Model(name, price);
        if (head == null) {
            head = newModel;
            head.next = head;
            head.prev = head;
        } else {
            Model last = head;
            if (head.getName().equals(name)) {
                throw new DuplicateModelNameException("Model with such name already exist!", name);
            }
            while (last.next != head) {
                last = last.next;
                if (last.getName().equals(name)) {
                    throw new DuplicateModelNameException("Model with such name already exist!", name);
                }
            }

            last.next = newModel;
            newModel.prev = last;
            newModel.next = head;
            head.prev = newModel;
        }
        lastModified = System.currentTimeMillis();
        size++;
    }

    public String [] getModelNames() {
        String[] res = new String[size];

        Model last = head;
        for (int i = 0; i < size; i++) {
            res[i] = last.getName();
            last = last.next;
        }
        return res;
    }

    public double getModelPriceByName(String modelName) throws NoSuchModelNameException {
        return getModelByName(modelName).getPrice();
    }

    public void setModelPriceByName(String modelName, double price) throws NoSuchModelNameException {
        if(price < 0.0) {
            throw new ModelPriceOutOfBoundsException("Illegal price!", price);
        }
        getModelByName(modelName).setPrice(price);

        lastModified = System.currentTimeMillis();
    }

    public double [] getModelPrices() {
        double [] res = new double[size];

        Model last = head;
        for (int i = 0; i < size; i++) {
            res[i] = last.getPrice();
            last = last.next;
        }

        return res;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Brand: ").append(brand);
        Model last = head;
        res.append("\nHead: [Name: ").append(head.getName()).append(", Price: ").append(head.getPrice()).append("]\n");
        for (int i = 0; i < size; i++) {
            res.append(last.toString());
            last = last.next;
        }

        return res.toString();
    }

    public void removeModelByName(String name) throws NoSuchModelNameException {
        Model modelToDelete = getModelByName(name);

        if (head.equals(modelToDelete)) {
            head.next.prev = head.prev;
            head.prev.next = head.next;
            head = head.next;
        } else {
            modelToDelete.next.prev = modelToDelete.prev;
            modelToDelete.prev.next = modelToDelete.next;
        }
        size--;
        lastModified = System.currentTimeMillis();
    }

    public int getSize() {
        return size;
    }

    private boolean hasModelByName(String name) {
        Model currModel = head;
        for (int i = 0; i < size; i++, currModel = currModel.next) {
            if (currModel.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setModelNameByModelName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        if (!hasModelByName(oldName)) {
            throw new NoSuchModelNameException("exception", oldName);
        }
        if (oldName.equals(newName)) {
            return;
        }
        if (hasModelByName(newName)) {
            throw new DuplicateModelNameException("exception", newName);
        }

        getModelByName(oldName).setName(newName);
        lastModified = System.currentTimeMillis();
    }

    @Override
    protected Motorcycle clone() throws CloneNotSupportedException {
        return (Motorcycle) super.clone();
    }

    private static class Model implements Serializable{
        String name;

        double price;

        Model prev = null;

        Model next = null;

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
        public String toString() {
            if (next == null) {
                if(prev == null) {
                    return "[Name: " + name + ", Price: " + price + ", Next: " + null + ", Prev: " + null + "]\n";
                } else {
                    return "[Name: " + name + ", Price: " + price + ", Next: " + null + ", Prev: " + prev.getName() + "]\n";
                }
            } else if (prev == null) {
                return "[Name: " + name + ", Price: " + price + ", Next: " + next.getName() + ", Prev: " + null + "]\n";
            } else {
                return "[Name: " + name + ", Price: " + price + ", Next: " + next.getName() + ", Prev: " + prev.getName() + "]\n";
            }
        }
    }
}
