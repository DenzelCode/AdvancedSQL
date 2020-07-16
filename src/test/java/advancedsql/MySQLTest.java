/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package advancedsql;

import advancedsql.query.Create;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class MySQLTest {
    public MySQL connect() throws SQLException {
        return new MySQL("127.0.0.1", 3306, "root", "", "unittesting");
    }

    @Test public void testConnection() {
        try {
            MySQL mySQL = connect();

            assertTrue(mySQL.isConnected());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test public void testCreateTable() {
        try {
            MySQL mySQL = connect();

            Create create = mySQL.table("test").create();

            create.id();

            create.columns(new HashMap<>() {{
                put("first_name", "varchar(255)");
                put("last_name", "varchar(255)");
            }});

            create.execute();

            assertTrue(mySQL.isConnected());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
