package by.itcollege.service;

import by.itcollege.dao.CarDaoImpl;
import by.itcollege.entity.Car;

import java.util.List;

public class CarService {

    private static CarService INSTANCE;

    public static  CarService getInstance() {
        if (INSTANCE == null) {
            synchronized (UserService.class) {
                if (INSTANCE == null) INSTANCE = new CarService();
            }
        }
        return  INSTANCE;
    }

    public List<Car> getAllCars() {
        return CarDaoImpl.newInstance().findFreeCars();
    }

    public Car findById(int id) {
        return CarDaoImpl.newInstance().findById(id);
    }

    public void updateCar(Car car) {
        CarDaoImpl.newInstance().update(car.getId(), car);
    }
}
