package advancedsql.query.join;

import advancedsql.query.IQuery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IJoin {

    IJoin on(String conditional);

    IJoin as(String name);

    IJoin using(String[] columns);

    IJoin join(String table);

    IJoin innerJoin(String table);

    IJoin leftJoin(String table);

    IJoin rightJoin(String table);

    IJoin fullJoin(String table);

    IQuery where(String where, Object... execute);

    IQuery where(String where);

    PreparedStatement executePrepare() throws SQLException;

    boolean executeStatement() throws SQLException;

    ResultSet executeQuery() throws SQLException;

    String getPrefix();

    String toQuery();
}
