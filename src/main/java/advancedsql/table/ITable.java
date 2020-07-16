package advancedsql.table;

import advancedsql.ISQL;
import advancedsql.query.*;

import java.sql.SQLException;

public interface ITable {

    String getName();

    ISQL getSQL();

    boolean exists() throws SQLException;

    Select select();

    Create create();

    Alter alter();

    Insert insert();

    Update update();

    Delete delete();

    Truncate truncate();

    Drop drop();
}
