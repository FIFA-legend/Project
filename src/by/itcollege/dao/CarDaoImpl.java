package by.itcollege.dao;

import by.itcollege.entity.Car;
import by.itcollege.entity.CarType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements Dao<Car> {

    private static CarDaoImpl INSTANCE;

    private CarDaoImpl() {}

    public static CarDaoImpl newInstance() {
        if (INSTANCE == null) {
            synchronized (CarDaoImpl.class) {
                if (INSTANCE == null) INSTANCE = new CarDaoImpl();
            }
        }
        return INSTANCE;
    }

    public boolean save(Car car) {

        try (Connection connection = ConnectionManager.getConnection()) {

            String saveCarQuery = "INSERT INTO cars(is_taken, brand, model, number, car_type) VALUES (?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(saveCarQuery);
            statement.setBoolean(1, false);
            statement.setString(2, car.getBrand());
            statement.setString(3, car.getModel());
            statement.setString(4, car.getNumber());
            statement.setString(5, car.getCarType().toString());

            statement.execute();

            statement.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Car findById(int id) {

        try (Connection connection = ConnectionManager.getConnection()){

            String readCarQuery = "SELECT * FROM cars WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(readCarQuery);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            Car car = null;

            while (rs.next()) {
                CarType type = null;
                if (rs.getString("car_type").toLowerCase().equals("business")) type = CarType.BUSINESS;
                if (rs.getString("car_type").toLowerCase().equals("sport")) type = CarType.SPORT;
                if (rs.getString("car_type").toLowerCase().equals("normal")) type = CarType.NORMAL;
                car = new Car(id, rs.getBoolean("is_taken"), rs.getString("brand"), rs.getString("model"), rs.getString("number"), type);
            }

            rs.close();
            statement.close();

            return car;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(int id, Car car) {

        try (Connection connection = ConnectionManager.getConnection()){

            String updateCarQuery = "UPDATE cars SET is_taken = ?, brand = ?, model = ?, number = ?, car_type = ? WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(updateCarQuery);
            statement.setBoolean(1, car.isTaken());
            statement.setString(2, car.getBrand());
            statement.setString(3, car.getModel());
            statement.setString(4, car.getNumber());
            statement.setString(5, car.getCarType().toString());
            statement.setInt(6, id);

            statement.execute();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {

        try (Connection connection = ConnectionManager.getConnection()){

            String deleteCarQuery = "DELETE FROM cars WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(deleteCarQuery);
            statement.setInt(1, id);

            statement.execute();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Car> findFreeCars() {

        List<Car> carList = new ArrayList<>();

        try (Connection connection = ConnectionManager.getConnection()){

            String readCarQuery = "SELECT * FROM cars WHERE is_taken = false;";
            PreparedStatement statement = connection.prepareStatement(readCarQuery);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Car car = new Car(rs.getInt("id"), rs.getBoolean("is_taken"), rs.getString("brand"), rs.getString("model"), rs.getString("number"), CarType.valueOf(rs.getString("car_type")));
                carList.add(car);
            }

            rs.close();
            statement.close();

            return carList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
