package advancedsql.query;

import advancedsql.ISQL;
import advancedsql.table.ITable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ExecuteQuery<T extends IQuery> extends Query<T> {

    public ExecuteQuery(ITable table) {
        super(table);
    }

    @Override
    public PreparedStatement executePrepare() throws SQLException {
        this.execute();

        return this.prepare;
    }

    public Map<String, Object> fetch() throws SQLException {
        this.limit(1);

        ResultSet resultSet = this.execute();

        if (resultSet == null) return null;

        resultSet.next();

        ResultSetMetaData metaData = resultSet.getMetaData();

        Map<String, Object> map = new HashMap<>();

        for (int i = 0; i < metaData.getColumnCount(); i++) {
            try {
                map.put(metaData.getColumnName(i), resultSet.getObject(i));
            } catch (SQLException e) {

            }
        }

        return map;
    }

    public ResultSet fetchAll() throws SQLException {
        return execute();
    }

    public List<Map<String, Object>> fetchAllAsList() throws SQLException {
        ResultSet resultSet = this.fetchAll();

        return ISQL.convertResultSetToList(resultSet);
    }

    public ResultSet execute() throws SQLException {
        return this.executeQuery();
    }
}
