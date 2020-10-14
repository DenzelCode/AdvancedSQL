package com.code.advancedsql.query;

import com.code.advancedsql.table.ITable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Update extends ExecuteUpdate<Update> {

    public Update(ITable table) {
        super(table);
    }

    public Update(ITable table, Map<String, Object> fields) {
        super(table, fields);
    }

    @Override
    public String toQuery() {
        StringBuilder query = new StringBuilder("UPDATE " + this.table + " ");

        for (int i = 0; i < this.fields.size(); i++) query.append(this.fields.size() == 1 ? "SET " + this.fields.get(i) + " = ? " : (i == 0 ? "SET " + this.fields.get(i) + " = ?, " : (i != this.fields.size() - 1 ? this.fields.get(i) + " = ?, " : this.fields.get(i) + " = ?")));

        query.append(this.where != null ? " WHERE " + this.where : "");

        query.append(this.limit > 0 ? " LIMIT " + this.limit : "");

        return query.toString().trim();
    }
}
