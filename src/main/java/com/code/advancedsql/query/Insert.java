package com.code.advancedsql.query;

import com.code.advancedsql.table.ITable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Insert extends ExecuteUpdate<Insert> {

    private final List<String> fields = new ArrayList<>();

    private final List<Object> values = new ArrayList<>();

    public Insert(ITable table) {
        super(table);
    }

    public Insert(ITable table, Map<String, Object> fields) {
        super(table);

        this.fields(fields);
    }

    /**
     * Columns and values that you want to insert.
     * @param field Column name
     * @param value Row value
     * @return Query object.
     */
    public Insert field(String field, Object value) {
        this.fields.add(field);

        this.values.add(value);

        this.execute.add(value);

        return this;
    }

    /**
     * Columns and values that you want to insert.
     * @param values Map
     * @return Query object.
     */
    public Insert fields(Map<String, Object> values) {
        for (Map.Entry<String, Object> entry: values.entrySet()) this.field(entry.getKey(), entry.getValue());

        return this;
    }

    @Override
    public String toQuery() {
        StringBuilder query = new StringBuilder("INSERT INTO " + this.table + " (");

        for (int i = 0; i < this.fields.size(); i++) query.append(i != this.fields.size() - 1 ? this.fields.get(i) + ", " : this.fields.get(i));

        query.append(") VALUES (");

        for (int i = 0; i < this.values.size(); i++) query.append(i != this.values.size() - 1 ? "?, " : "?");

        query.append(")");

        return query.toString().trim();
    }
}