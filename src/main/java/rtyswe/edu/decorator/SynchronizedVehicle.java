package rtyswe.edu.decorator;

import rtyswe.edu.exeptions.DuplicateModelNameException;
import rtyswe.edu.exeptions.NoSuchModelNameException;
import rtyswe.edu.model.Vehicle;
import rtyswe.edu.visitor.Visitor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedVehicle implements Vehicle {

    private final Vehicle vehicle;
    private final Lock locker;

    public SynchronizedVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.locker = new ReentrantLock();
    }

    @Override
    public void accept(Visitor visitor) {
        locker.lock();
        try {
            vehicle.accept(visitor);
        } finally {
            locker.unlock();
        }
    }

    @Override
    public void addModel(String name, double price) throws DuplicateModelNameException {
        locker.lock();
        try {
            vehicle.addModel(name, price);
        } finally {
            locker.unlock();
        }
    }

    @Override
    public String[] getModelNames() {
        locker.lock();
        try {
            return vehicle.getModelNames();
        } finally {
            locker.unlock();
        }
    }

    @Override
    public double getModelPriceByName(String modelName) throws NoSuchModelNameException {
        locker.lock();
        try {
            return vehicle.getModelPriceByName(modelName);
        } finally {
            locker.unlock();
        }
    }

    @Override
    public void setModelPriceByName(String modelName, double price) throws NoSuchModelNameException {
        locker.lock();
        try {
            vehicle.setModelPriceByName(modelName, price);
        } finally {
            locker.unlock();
        }
    }

    @Override
    public double[] getModelPrices() {
        locker.lock();
        try {
            return vehicle.getModelPrices();
        } finally {
            locker.unlock();
        }
    }

    @Override
    public void removeModelByName(String name) throws NoSuchModelNameException {
        locker.lock();
        try {
            vehicle.removeModelByName(name);
        } finally {
            locker.unlock();
        }
    }

    @Override
    public int getSize() {
        locker.lock();
        try {
            return vehicle.getSize();
        } finally {
            locker.unlock();
        }
    }

    @Override
    public String getBrand() {
        locker.lock();
        try {
            return vehicle.getBrand();
        } finally {
            locker.unlock();
        }
    }

    @Override
    public void setBrand(String brand) {
        locker.lock();
        try {
            vehicle.setBrand(brand);
        } finally {
            locker.unlock();
        }
    }

    @Override
    public void setModelNameByModelName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        locker.lock();
        try {
            vehicle.setModelNameByModelName(oldName, newName);
        } finally {
            locker.unlock();
        }
    }
}
