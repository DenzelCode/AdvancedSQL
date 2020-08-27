package com.code.advancedsql.query;

import com.code.advancedsql.ISQL;
import com.code.advancedsql.table.ITable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ExecuteQuery<T extends IQuery> extends Specifiable<T> {

    public ExecuteQuery(ITable table) {
        super(table);
    }

    @Override
    public PreparedStatement executePrepare() throws SQLException {
        this.execute();

        return this.prepare;
    }

    /**
     * @return A Map of the first result found.
     * @throws SQLException Exception when something goes wrong.
     */
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

    /**
     * @return ResultSet of all the results found.
     * @throws SQLException Exception when something goes wrong.
     */
    public ResultSet fetchAll() throws SQLException {
        return execute();
    }

    /**
     * @return A List of all the results found.
     * @throws SQLException Exception when something goes wrong.
     */
    public List<Map<String, Object>> fetchAllAsList() throws SQLException {
        ResultSet resultSet = this.fetchAll();

        return ISQL.convertResultSetToList(resultSet);
    }

    /**
     * Execute query.
     * @return A ResultSet of all the results found.
     * @throws SQLException Exception when something goes wrong.
     */
    public ResultSet execute() throws SQLException {
        return this.executeQuery();
    }
}