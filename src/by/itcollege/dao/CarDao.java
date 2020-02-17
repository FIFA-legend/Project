package by.itcollege.dao;

import by.itcollege.entity.Car;

public interface CarDao {

    void save(Car car);

    Car findById(int id);

    void update(int id, Car car);

    void delete(int id);

}
