package advancedsql.table;

import advancedsql.ISQL;
import advancedsql.query.*;

import java.sql.SQLException;
import java.util.Map;

public interface ITable {

    String getName();

    ISQL getSQL();

    boolean exists() throws SQLException;

    Select select();

    Create create();

    Alter alter();

    Insert insert();

    Insert insert(Map<String, Object> fields);

    Update update();

    Update update(Map<String, Object> fields);

    Delete delete();

    Truncate truncate();

    Drop drop();
}
