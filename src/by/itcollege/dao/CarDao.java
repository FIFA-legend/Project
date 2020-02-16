package by.itcollege.dao;

import by.itcollege.entity.Car;

public interface CarDao {

    void save(Car car);

    Car read(int id);

    void update(int id, Car car);

    void delete(int id);

}
