package by.itcollege.dao;

import by.itcollege.entity.Car;
import by.itcollege.entity.Request;
import by.itcollege.entity.User;

import java.sql.*;

public class RequestDaoImpl implements Dao<Request>, CarAndRequestDao<Request> {

    private static RequestDaoImpl INSTANCE;

    private RequestDaoImpl() {};

    public static RequestDaoImpl newInstance() {
        if (INSTANCE == null) {
            synchronized (RequestDaoImpl.class) {
                if (INSTANCE == null) INSTANCE = new RequestDaoImpl();
            }
        }
        return INSTANCE;
    }

    @Override
    public boolean save(Request request) {

        try (Connection connection = ConnectionManager.getConnection()) {

            String addRequestQuery = "INSERT INTO requests(cost, is_completed, begin_time, car_id, client_id, driver_id) VALUES (?,?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(addRequestQuery);
            statement.setDouble(1, request.getCost());
            statement.setBoolean(2, request.isCompleted());
            statement.setDate(3, (Date) request.getBeginTime());
            statement.setInt(4, request.getCar().getId());
            statement.setInt(5, request.getClient().getId());
            statement.setInt(6, request.getDriver().getId());

            statement.execute();

            statement.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Request findById(int id) {

        try (Connection connection = ConnectionManager.getConnection()){

            String readRequestQuery = "SELECT * FROM requests WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(readRequestQuery);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            Request request = null;

            while (rs.next()) {
                Car car = CarDaoImpl.newInstance().findById(rs.getInt("car_id"));
                User client = UserDaoImpl.newInstance().findById(rs.getInt("client_id"));
                User driver = UserDaoImpl.newInstance().findById(rs.getInt("driver_id"));
                request = new Request(rs.getDouble("cost"), rs.getBoolean("is_completed"), car, rs.getDate("begin_time"), client, driver);
            }

            rs.close();
            statement.close();

            return request;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(int id, Request request) {

        try (Connection connection = ConnectionManager.getConnection()){

            String updateRequestQuery = "UPDATE requests SET cost = ?, is_completed = ?, begin_time = ?, car_id = ?, client_id = ?, driver_id = ? WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(updateRequestQuery);
            statement.setDouble(1, request.getCost());
            statement.setBoolean(2, request.isCompleted());
            statement.setDate(3, (Date) request.getBeginTime());
            statement.setInt(4, request.getCar().getId());
            statement.setInt(5, request.getClient().getId());
            statement.setInt(6,request.getDriver().getId());
            statement.setInt(7, id);

            statement.execute();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {

        try (Connection connection = ConnectionManager.getConnection()){

            String deleteRequestQuery = "DELETE FROM requests WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(deleteRequestQuery);
            statement.setInt(1, id);

            statement.execute();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
