package com.code.advancedsql.query;

import com.code.advancedsql.table.ITable;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class ExecuteUpdate<T extends IQuery> extends Specifiable<T> {

    protected final List<String> fields = new ArrayList<>();

    public ExecuteUpdate(ITable table, Map<String, Object> fields) {
        super(table);

        if (fields != null) this.fields(fields);
    }

    public ExecuteUpdate(ITable table) {
        this(table, null);
    }

    @Override
    public PreparedStatement executePrepare() throws SQLException {
        this.execute();

        return this.prepare;
    }

    /**
     * Columns and values that you want to update/insert.
     * @param field Column name
     * @param value Row value
     * @return Query object.
     */
    @SuppressWarnings("unchecked")
    public T field(String field, Object value) {
        this.fields.add(field);

        this.execute.add(value);

        return (T) this;
    }

    /**
     * Columns and values that you want to update/insert.
     * @param values Map
     * @return Query object.
     */
    @SuppressWarnings("unchecked")
    public T fields(Map<String, Object> values) {
        for (Map.Entry<String, Object> entry: values.entrySet())
            this.field(entry.getKey(), entry.getValue());

        return (T) this;
    }

    /**
     * Execute the query.
     * @return An integer.
     * @throws SQLException Exception when something goes wrong.
     */
    public int execute() throws SQLException {
        return this.executeUpdate();
    }
}
