package by.itcollege.entity;

import java.util.Date;
import java.util.Objects;

public class Request {

    int id;

    private double cost;

    private boolean isCompleted;

    private Car car;

    private Date beginTime;

    private User client;

    private User driver;

    public Request(double cost, boolean isCompleted, Car car, Date beginTime, User client, User driver) {
        this.cost = cost;
        this.isCompleted = isCompleted;
        this.car = car;
        this.beginTime = beginTime;
        this.client = client;
        this.driver = driver;
    }

    public Request(int id, double cost, boolean isCompleted, Car car, Date beginTime, User client, User driver) {
        this.id = id;
        this.cost = cost;
        this.isCompleted = isCompleted;
        this.car = car;
        this.beginTime = beginTime;
        this.client = client;
        this.driver = driver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return id == request.id &&
                Double.compare(request.cost, cost) == 0 &&
                isCompleted == request.isCompleted &&
                car.equals(request.car) &&
                beginTime.equals(request.beginTime) &&
                client.equals(request.client) &&
                driver.equals(request.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost, isCompleted, car, beginTime, client, driver);
    }
}
