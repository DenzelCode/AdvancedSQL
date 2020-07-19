package advancedsql;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL extends SQL {

    /**
     * Create MySQL connection.
     * Do not worry about creating the database, AdvancedSQL takes care of it for you.
     * @param host MySQL server host.
     * @param port MySQL server port.
     * @param username MySQL server username.
     * @param password MySQL server password.
     * @param database MySQL server database. If not exists AdvancedSQL creates it for you.
     * @throws SQLException Exception when something goes wrong.
     */
    public MySQL(String host, int port, String username, String password, String database) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

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
        connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", username, password);

        this.connected = true;
    }

    private void createDatabase(String host, int port, String username, String password, String database) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", username, password);

        Statement statement = connection.createStatement();

        statement.executeUpdate("CREATE DATABASE " + database);

        connection.close();

        connection = null;
    }
}
