package advancedsql;

import advancedsql.query.IQuery;
import advancedsql.table.ITable;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ISQL {

    PreparedStatement prepare(IQuery query) throws SQLException;

    ITable table(String name);

    boolean isConnected();

    Connection getConnection();

    static List<Map<String, Object>> convertResultSetToList(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        int columns = metaData.getColumnCount();

        List<Map<String,Object>> list = new ArrayList<>();

        while (resultSet.next()) {
            Map<String,Object> row = new HashMap<>(columns);

            for (int i = 1; i <= columns; i++) row.put(metaData.getColumnName(i), resultSet.getObject(i));

            list.add(row);
        }

        return list;
    }

    static void setStatementParameters(PreparedStatement statement, List<Object> execute) throws SQLException {
        for (int i = 0; i < execute.size(); i++) {
            Object value = execute.get(i);

            if (value instanceof String) statement.setString(i + 1, (String) value);

            if (value instanceof Integer) statement.setInt(i + 1, (Integer) value);
        }
    }
}
