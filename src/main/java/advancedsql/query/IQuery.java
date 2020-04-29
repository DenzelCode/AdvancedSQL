package advancedsql.query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IQuery {

    IQuery where(String where, Object... execute);

    IQuery where(String where);

    boolean executeBoolean() throws SQLException;

    PreparedStatement executePrepare() throws SQLException;

    String toQuery();
}
