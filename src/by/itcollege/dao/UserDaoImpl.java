package by.itcollege.dao;

import by.itcollege.entity.Role;
import by.itcollege.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Dao<User> {

    private static UserDaoImpl INSTANCE;

    private UserDaoImpl() {}

    public static UserDaoImpl newInstance() {
        if (INSTANCE == null) {
            synchronized (UserDaoImpl.class) {
                if (INSTANCE == null) INSTANCE = new UserDaoImpl();
            }
        }
        return INSTANCE;
    }

    public int save(User user) {

        try (Connection connection = ConnectionManager.getConnection()){

            String addUserQuery = "INSERT INTO users(is_on_request, name, last_name, password, role) VALUES (?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(addUserQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setBoolean(1, false);
            statement.setString(2, user.getName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getRole().toString());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            user.setId(id);

            rs.close();
            statement.close();
            return id;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public User findById(int id) {

        try (Connection connection = ConnectionManager.getConnection()) {

            String readUserQuery = "SELECT * FROM users WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(readUserQuery);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            User user = null;

            while (rs.next()) {
                Role temp = Role.valueOf(rs.getString("role"));
                user = new User(id, rs.getBoolean("is_on_request"), rs.getString("name"), rs.getString("last_name"), rs.getString("password"), temp);
            }

            rs.close();
            statement.close();

            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(int id, User user) {

        try (Connection connection = ConnectionManager.getConnection()) {

            String updateUserQuery = "UPDATE users SET is_on_request = ?, name = ?, last_name = ?, password = ?, role = ? WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(updateUserQuery);
            statement.setBoolean(1, user.isOnRequest());
            statement.setString(2, user.getName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getRole().toString());
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

            String deleteUserQuery = "DELETE FROM users where id = ?;";
            PreparedStatement statement = connection.prepareStatement(deleteUserQuery);
            statement.setInt(1, id);

            statement.execute();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> findFreeDrivers() {

        List<User> userList = new ArrayList<>();

        try (Connection connection = ConnectionManager.getConnection()) {

            String readUserQuery = "SELECT * FROM users WHERE is_on_request = false AND role = 'DRIVER';";
            PreparedStatement statement = connection.prepareStatement(readUserQuery);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getBoolean("is_on_request"), rs.getString("name"), rs.getString("last_name"), rs.getString("password"), Role.DRIVER);
                userList.add(user);
            }

            rs.close();
            statement.close();

            return userList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
