package com.code.advancedsql;

import com.code.advancedsql.query.IQuery;
import com.code.advancedsql.table.ITable;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ISQL {

    /**
     * Prepare SQL query.
     * @param query Query object that you want to prepare.
     * @return A PreparedStatement object.
     * @throws SQLException Exception when something goes wrong.
     */
    PreparedStatement prepare(IQuery query) throws SQLException;

    /**
     * Get access to a table object to modify information.
     * @param name Name of the table.
     * @return A Table object which allows you to execute SQL query's.
     */
    ITable table(String name);

    /**
     * Get connection state.
     * @return true if connected, false if not.
     */
    boolean isConnected();

    /**
     * @return Connection Object.
     */
    Connection getConnection();

    /**
     * Convert a ResultSet into a list.
     * @param resultSet Result set
     * @return Returns a list of map with the column name and value.
     * @throws SQLException Exception when something goes wrong.
     */
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

    /**
     * Set statement parameters.
     * @param statement Statement to modify.
     * @param execute Parameters to assign.
     * @throws SQLException Exception when something goes wrong.
     */
    static void setStatementParameters(PreparedStatement statement, List<Object> execute) throws SQLException {
        for (int i = 0; i < execute.size(); i++) {
            Object value = execute.get(i);

            statement.setObject(i + 1, value);
        }
    }
}
