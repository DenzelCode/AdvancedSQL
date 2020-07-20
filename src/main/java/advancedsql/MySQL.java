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
     * @param attributes MySQL server connection attributes.
     * @throws SQLException Exception when something goes wrong.
     */
    public MySQL(String host, int port, String username, String password, String database, String attributes) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            this.connect(host, port, username, password, database, attributes);
        } catch (SQLException e) {
            if (e.getErrorCode() == 1049) {
                createDatabase(host, port, username, password, database, attributes);

                connect(host, port, username, password, database, attributes);

                return;
            }

            throw new SQLException(e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            this.connected = false;

            throw new SQLException("Can't load JDBC Driver", e);
        }
    }

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
        this(host, port, username, password, database, "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
    }

    private void connect(String host, int port, String username, String password, String database, String attributes) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + (attributes.isEmpty() ? "" : "?" + attributes), username, password);

        this.connected = true;
    }

    private void createDatabase(String host, int port, String username, String password, String database, String attributes) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + (attributes.isEmpty() ? "" : "?" + attributes), username, password);

        Statement statement = connection.createStatement();

        statement.executeUpdate("CREATE DATABASE " + database);

        connection.close();

        connection = null;
    }
}
