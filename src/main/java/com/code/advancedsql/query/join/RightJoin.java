package com.code.advancedsql.query.join;

import com.code.advancedsql.query.Select;

public class RightJoin extends Join {

    public RightJoin(Select query, String table) {
        super(query, table);
    }

    @Override
    public String getPrefix() {
        return "RIGHT JOIN";
    }
}
