package com.code.advancedsql.query;

import com.code.advancedsql.table.ITable;

public class Drop extends ExecuteStatement<Drop> {

    public Drop(ITable table) {
        super(table);
    }

    @Override
    public String toQuery() {
        return "DROP TABLE " + this.table;
    }
}
