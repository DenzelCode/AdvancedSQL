package com.code.advancedsql.query.join;

import com.code.advancedsql.query.Select;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IJoin {

    /**
     * Assign join conditional
     * @param conditional Conditional to execute join.
     * @return Join object.
     */
    IJoin on(String conditional);

    /**
     * Assign an alias to the table.
     * @param name alias.
     * @return Join object
     */
    IJoin as(String name);

    /**
     * Set USING attribute.
     * @param columns columns to use.
     * @return Join object.
     */
    IJoin using(String[] columns);

    /**
     * Join table.
     * @param table Table name.
     * @return Join object.
     */
    IJoin join(String table);

    /**
     * Inner Join table.
     * @param table Table name.
     * @return IJoin object.
     */
    IJoin innerJoin(String table);

    /**
     * Left Join table.
     * @param table Table name.
     * @return IJoin object.
     */
    IJoin leftJoin(String table);

    /**
     * Right Join table.
     * @param table Table name.
     * @return IJoin object.
     */
    IJoin rightJoin(String table);

    /**
     * Full Join table.
     * @param table Table name.
     * @return IJoin object.
     */
    IJoin fullJoin(String table);

    /**
     * Specify what values will be affected for example:
     * query.where("first_name = ? AND last_name = ?", "Denzel", "Code");
     * @param where Where statement.
     * @param execute Values of the statement.
     * @return Query object.
     */
    Select where(String where, Object... execute);

    /**
     * Specify what values will be affected for example:
     * query.where("first_name = 'Denzel' AND last_name = 'Code'");
     * @param where Where statement.
     * @return Query object.
     */
    Select where(String where);

    /**
     * @return A Map of the first result found.
     * @throws SQLException Exception when something goes wrong.
     */
    Map<String, Object> fetch() throws SQLException;

    /**
     * @return ResultSet of all the results found.
     * @throws SQLException Exception when something goes wrong.
     */
    ResultSet fetchAll() throws SQLException;

    /**
     * @return A List of all the results found.
     * @throws SQLException Exception when something goes wrong.
     */
    List<Map<String, Object>> fetchAllAsList() throws SQLException;

    /**
     * Execute query and return a boolean.
     * Recommended for: CREATE, ALTER, DROP, TRUNCATE.
     * @return boolean.
     * @throws SQLException Exception when something goes wrong.
     */
    Boolean executeStatement() throws SQLException;

    /**
     * Execute query and return an integer.
     * Recommended for: INSERT, UPDATE, DELETE.
     * @return integer.
     * @throws SQLException Exception when something goes wrong.
     */
    int executeUpdate() throws SQLException;

    /**
     * Execute query and return a ResultSet.
     * Recommended for: SELECT, SHOW.
     * @return ResultSet.
     * @throws SQLException Exception when something goes wrong.
     */
    ResultSet executeQuery() throws SQLException;

    /**
     * Execute query and return a PreparedStatement.
     * Recommended for: General.
     * @return ResultSet.
     * @throws SQLException Exception when something goes wrong.
     */
    PreparedStatement executePrepare() throws SQLException;

    /**
     * Execute query.
     * @return A ResultSet of all the results found.
     * @throws SQLException Exception when something goes wrong.
     */
    ResultSet execute() throws SQLException;

    /**
     * @return Query object.
     */
    Select getQuery();

    /**
     * @return Join prefix.
     */
    String getPrefix();

    /**
     * @return String representation of the Query.
     */
    String toQuery();

    /**
     * @return String representation of the Query.
     */
    String toString();
}
