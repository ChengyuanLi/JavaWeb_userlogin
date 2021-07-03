package com.dao;

import com.domain.User;

import java.sql.*;

/**
 * 单例模式
 * @author aidenli
 */
public class UserDao {

    private UserDao() {}
    private static UserDao dao = new UserDao();
    public static UserDao getInstance() {
        return dao;
    }

    public User findUserByNameAndPass(String name, String pass) {
        String sql = "SELECT * FROM T_USER WHERE UNAME = ? AND UPASS = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc::mysql://localhost:3306/0702",
                    "root",
                    ",,,,");

            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, pass);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int uno = resultSet.getInt("uno");
                String uname = resultSet.getString("uname");
                String upass = resultSet.getString("upass");
                String truename = resultSet.getString("truename");
                String flag = resultSet.getString("flag");

                return new User(uno, uname, upass, truename, flag);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }

        return null;
    }
}
