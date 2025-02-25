package by.itcollege.entity;

import java.util.Objects;

public class Car {

    private int id;

    private boolean isTaken;

    private String model;

    private String brand;

    private String number;

    private CarType carType;


    public Car(int id, boolean isTaken, String model, String brand, String number, CarType carType) {
        this.id = id;
        this.isTaken = isTaken;
        this.model = model;
        this.brand = brand;
        this.number = number;
        this.carType = carType;
    }

    public Car(boolean isTaken, String model, String brand, String number, CarType carType) {
        this.isTaken = isTaken;
        this.model = model;
        this.brand = brand;
        this.number = number;
        this.carType = carType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                model.equals(car.model) &&
                Objects.equals(brand, car.brand) &&
                number.equals(car.number) &&
                carType == car.carType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, brand, number, carType);
    }
}
