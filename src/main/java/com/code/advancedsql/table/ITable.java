package com.code.advancedsql.table;

import com.code.advancedsql.ISQL;
import com.code.advancedsql.query.*;

import java.sql.SQLException;
import java.util.Map;

public interface ITable {

    /**
     * @return Table name.
     */
    String getName();

    /**
     * @return SQL object.
     */
    ISQL getSQL();

    /**
     * Check if the table exists.
     * @return true if table exists.
     * @throws SQLException Exception when something goes wrong.
     */
    boolean exists() throws SQLException;

    /**
     * Generate a SELECT query.
     * Remember to execute the query after you specify the parameters.
     * @return A Select object that allows you to specify the parameters of your query.
     */
    Select select();

    /**
     * Generate a SELECT query.
     * Remember to execute the query after you specify the parameters.
     * @param columns Array of columns that you want to select.
     * @return A Select object that allows you to specify the parameters of your query.
     */
    Select select(String[] columns);

    /**
     * Create table.
     * Set the columns type that you want to create and then execute the query.
     * Remember to execute the query after you specify the parameters.
     * @return A Create object that allows you to specify the parameters of your query.
     */
    Create create();

    /**
     * Alter the table.
     * Remember to execute the query after you specify the parameters.
     * @return An Alter object that allows you to specify the parameters of your query.
     */
    Alter alter();

    /**
     * Insert a row into the table.
     * Remember to execute the query after you specify the parameters.
     * @return An Insert object that allows you to specify the parameters of your query.
     */
    Insert insert();

    /**
     * Insert a row into the table.
     * Remember to execute the query after you specify the parameters.
     * @param fields Columns and values to insert.
     * @return An Insert object that allows you to specify the parameters of your query.
     */
    Insert insert(Map<String, Object> fields);

    /**
     * Update rows from the table.
     * Remember to execute the query after you specify the parameters.
     * @return An Update object that allows you to specify the parameters of your query.
     */
    Update update();

    /**
     * Update rows from the table.
     * Remember to execute the query after you specify the parameters.
     * @param fields Columns and values to update.
     * @return An Update object that allows you to specify the parameters of your query.
     */
    Update update(Map<String, Object> fields);

    /**
     * Delete rows from the table.
     * Remember to execute the query after you specify the parameters.
     * @return An Delete object that allows you to specify the parameters of your query.
     */
    Delete delete();

    /**
     * Empty the table.
     * Remember to execute the query after you specify the parameters.
     * @return A Truncate object that allows you to specify the parameters of your query.
     */
    Truncate truncate();

    /**
     * Delete the table.
     * Remember to execute the query after you specify the parameters.
     * @return A Drop object that allows you to specify the parameters of your query.
     */
    Drop drop();
}
