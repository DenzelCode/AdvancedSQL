package advancedsql.query.join;

import advancedsql.query.IQuery;
import advancedsql.query.Select;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IJoin {

    IJoin on(String conditional);

    IJoin as(String name);

    IJoin using(String[] columns);

    IJoin join(String table);

    IJoin innerJoin(String table);

    IJoin leftJoin(String table);

    IJoin rightJoin(String table);

    IJoin fullJoin(String table);

    Select where(String where, Object... execute);

    Select where(String where);

    Map<String, Object> fetch() throws SQLException;

    ResultSet fetchAll() throws SQLException;

    List<Map<String, Object>> fetchAllAsList() throws SQLException;

    PreparedStatement executePrepare() throws SQLException;

    boolean executeStatement() throws SQLException;

    ResultSet executeQuery() throws SQLException;

    ResultSet execute() throws SQLException;

    Select getQuery();

    String getPrefix();

    String toQuery();

    String toString();
}
