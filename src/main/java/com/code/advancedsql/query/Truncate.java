package com.code.advancedsql.query;

import com.code.advancedsql.table.ITable;

public class Truncate extends ExecuteStatement<Truncate> {

    public Truncate(ITable table) {
        super(table);
    }

    @Override
    public String toQuery() {
        return "TRUNCATE TABLE " + this.table;
    }
}
