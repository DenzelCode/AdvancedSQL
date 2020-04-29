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

public abstract class Fetchable<T extends IQuery> extends Query<T> {

    public Fetchable(ITable table) {
        super(table);
    }

    public Map<String, Object> fetch() throws SQLException {
        ResultSet resultSet = this.fetchAll();

        if (resultSet == null) return null;

        resultSet.first();

        ResultSetMetaData metaData = resultSet.getMetaData();

        Map<String, Object> map = new HashMap<>();

        for (int i = 0; i < metaData.getColumnCount(); i++) map.put(metaData.getColumnName(i), resultSet.getObject(i));

        return map;
    }

    public ResultSet fetchAll() throws SQLException {
        PreparedStatement prepare = this.executePrepare();

        return prepare.getResultSet();
    }

    public List<Map<String, Object>> fetchAllAsList() throws SQLException {
        ResultSet resultSet = this.fetchAll();

        return ISQL.convertResultSetToList(resultSet);
    }

    public PreparedStatement execute() throws SQLException {
        return this.executePrepare();
    }
}
