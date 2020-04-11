package by.itcollege.dao;

import by.itcollege.entity.Car;
import by.itcollege.entity.Request;
import by.itcollege.entity.User;

import java.sql.*;

public class RequestDaoImpl implements Dao<Request> {

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
    public int save(Request request) {

        try (Connection connection = ConnectionManager.getConnection()) {

            String data = request.getBeginTime().getYear() + "-" + (request.getBeginTime().getMonth() + 1) + "-" + request.getBeginTime().getDate();

            String addRequestQuery = "INSERT INTO requests(cost, is_completed, number_of_days, begin_time, car_id, client_id, driver_id) VALUES (?,?,?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(addRequestQuery);
            statement.setDouble(1, request.getCost());
            statement.setBoolean(2, request.isCompleted());
            statement.setInt(3, request.getNumberOfDays());
            statement.setString(4, data);
            statement.setInt(5, request.getCar().getId());
            statement.setInt(6, request.getClient().getId());
            statement.setInt(7, request.getDriver().getId());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            request.setId(id);

            rs.close();
            statement.close();
            return id;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
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
                request = new Request(rs.getDouble("cost"), rs.getBoolean("is_completed"), rs.getInt("number_of_days"), car, rs.getDate("end_time"), client, driver);
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

            String updateRequestQuery = "UPDATE requests SET cost = ?, is_completed = ?, number_of_days = ?, begin_time = ?, car_id = ?, client_id = ?, driver_id = ? WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(updateRequestQuery);
            statement.setDouble(1, request.getCost());
            statement.setBoolean(2, request.isCompleted());
            statement.setInt(3, request.getNumberOfDays());
            statement.setDate(4, (Date) request.getBeginTime());
            statement.setInt(5, request.getCar().getId());
            statement.setInt(6, request.getClient().getId());
            statement.setInt(7,request.getDriver().getId());
            statement.setInt(8, id);

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
