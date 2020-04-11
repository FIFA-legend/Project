package by.itcollege.service;

import by.itcollege.dao.CarDaoImpl;
import by.itcollege.entity.Car;

import java.util.List;

public class CarService implements Service<Car>{

    private static CarService INSTANCE;

    public static  CarService getInstance() {
        if (INSTANCE == null) {
            synchronized (UserService.class) {
                if (INSTANCE == null) INSTANCE = new CarService();
            }
        }
        return  INSTANCE;
    }

    @Override
    public int save(Car car) {
        return CarDaoImpl.newInstance().save(car);
    }

    @Override
    public Car findById(int id) {
        return CarDaoImpl.newInstance().findById(id);
    }

    @Override
    public void update(Car car) {
        CarDaoImpl.newInstance().update(car.getId(), car);
    }

    @Override
    public void delete(int id) {
        CarDaoImpl.newInstance().delete(id);
    }

    public List<Car> getAllCars() {
        return CarDaoImpl.newInstance().findFreeCars();
    }
}
