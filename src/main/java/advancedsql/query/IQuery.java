package advancedsql.query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IQuery {

    IQuery where(String where, Object... execute);

    IQuery where(String where);

    Boolean executeStatement() throws SQLException;

    int executeUpdate() throws SQLException;

    ResultSet executeQuery() throws SQLException;

    PreparedStatement executePrepare() throws SQLException;

    String toQuery();
}
