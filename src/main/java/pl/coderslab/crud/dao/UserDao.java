package pl.coderslab.crud.dao;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.crud.entity.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static pl.coderslab.crud.util.DbUtil.getConnection;

public class UserDao {

    private static final UserDao INSTANCE = new UserDao();
    private static final String INSERT_SQL = "INSERT INTO users(username, email, password) VALUES(?,?,?)";
    private static final String GET_USER_SQL = "SELECT id, username, email FROM users WHERE id=?";
    private static final String UPDATE_SQL = "UPDATE users SET username=?, email=?, password=? WHERE id=?";
    private static final String GET_ALL_SQL = "SELECT * FROM users";
    private static final String DELETE_SQL = "DELETE FROM users WHERE id=?";
    private static final String DELETE_ALL = "TRUNCATE TABLE users";

    private UserDao() {
    }

    public static UserDao getInstance() {

        return INSTANCE;
    }

    public List<User> findAll() {

        List<User> users = new ArrayList<>();

        try (var preparedStatement = getConnection().prepareStatement(GET_ALL_SQL)) {

            preparedStatement.execute();
            var resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {

                var user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));

                users.add(user);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return users;
    }

    public void delete(Long id) {

        try (var preparedStatement = getConnection().prepareStatement(DELETE_SQL)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.printf("User with ID %d deleted%n", id);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateUser(User user) {

        try (var preparedStatement = getConnection().prepareStatement(UPDATE_SQL)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, hashPassword(user.getPassword()));
            preparedStatement.setLong(4, user.getId());
            preparedStatement.executeUpdate();

            System.out.printf("User with ID %d updated%n", user.getId());

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


    public Optional<User> read(Long id) {

        try (var preparedStatement = getConnection().prepareStatement(GET_USER_SQL)) {

            preparedStatement.setLong(1, id);
            var rs = preparedStatement.executeQuery();

            var user = new User();
            while (rs.next()) {
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                return Optional.of(user);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }

    public User create(User user) {

        try (var preparedStatement = getConnection().prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, hashPassword(user.getPassword()));
            preparedStatement.executeUpdate();

            returnInsertedId(preparedStatement, user);

        } catch (SQLException e) {

            System.err.println(e.getMessage());

        }
        return user;
    }

    public boolean isPasswordCorrect(String password) {

        var hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        return BCrypt.checkpw(password, hashed);
    }

    public void deleteAll() throws SQLException {

        try (var preparedStatement = getConnection().prepareStatement(DELETE_ALL)) {
            preparedStatement.executeUpdate();
            System.out.println("All users deleted");

        }
    }

    public String hashPassword(String password) {

        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public void returnInsertedId(PreparedStatement preparedStatement, User user) throws SQLException {

        var rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {

            long id = rs.getLong(1);
            user.setId(id);
            System.out.println("Inserted ID: " + id);
        }
    }
}
