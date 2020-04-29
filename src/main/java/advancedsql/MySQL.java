package advancedsql;

import advancedsql.SQL;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL extends SQL {

    public MySQL(String host, int port, String username, String password, String database) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            this.connect(host, port, username, password, database);
        } catch (SQLException e) {
            if (e.getErrorCode() == 1049) {
                createDatabase(host, port, username, password, database);

                connect(host, port, username, password, database);

                return;
            }

            throw new SQLException(e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            this.connected = false;

            throw new SQLException("Can't load JDBC Driver", e);
        }
    }

    private void connect(String host, int port, String username, String password, String database) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sql://" + host + ":" + port + "/" + database, username, password);

        this.connected = true;
    }

    private void createDatabase(String host, int port, String username, String password, String database) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sql://" + host + ":" + port, username, password);

        Statement statement = connection.createStatement();

        statement.executeUpdate("CREATE DATABASE " + database);

        connection.close();

        connection = null;
    }
}
