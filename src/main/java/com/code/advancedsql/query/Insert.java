package com.code.advancedsql.query;

import com.code.advancedsql.table.ITable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Insert extends ExecuteUpdate<Insert> {

    public Insert(ITable table) {
        super(table);
    }

    public Insert(ITable table, Map<String, Object> fields) {
        super(table, fields);
    }

    @Override
    public String toQuery() {
        StringBuilder query = new StringBuilder("INSERT INTO " + this.table + " (");

        for (int i = 0; i < this.fields.size(); i++) query.append(i != this.fields.size() - 1 ? this.fields.get(i) + ", " : this.fields.get(i));

        query.append(") VALUES (");

        for (int i = 0; i < this.fields.size(); i++) query.append(i != this.fields.size() - 1 ? "?, " : "?");

        query.append(")");

        return query.toString().trim();
    }
}
