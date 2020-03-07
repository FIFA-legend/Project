package by.itcollege.dao;

import by.itcollege.entity.Role;
import by.itcollege.entity.User;

import java.sql.*;

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

    //@Override
    public int save(User user) {

        try (Connection connection = ConnectionManager.getConnection()){

            String addUserQuery = "INSERT INTO users(name, last_name, password, role) VALUES (?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(addUserQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole().toString());
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
                Role temp = null;
                if (rs.getString("role").toLowerCase().equals("driver")) temp = Role.DRIVER;
                if (rs.getString("role").toLowerCase().equals("client")) temp = Role.CLIENT;
                if (rs.getString("role").toLowerCase().equals("dispatcher")) temp = Role.DISPATCHER;
                user = new User(id, rs.getString("name"), rs.getString("last_name"), rs.getString("password"), temp);
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

            String updateUserQuary = "UPDATE users SET name = ?, last_name = ?, password = ?, role = ? WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(updateUserQuary);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole().toString());
            statement.setInt(5, id);

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

}
