package com.code.advancedsql.query.join;

import com.code.advancedsql.query.Select;

public class FullJoin extends Join {

    public FullJoin(Select query, String table) {
        super(query, table);
    }

    @Override
    public String getPrefix() {
        return "FULL JOIN";
    }
}
