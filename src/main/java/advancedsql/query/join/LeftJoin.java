package advancedsql.query.join;

import advancedsql.query.Select;

public class LeftJoin extends Join {

    public LeftJoin(Select query, String table) {
        super(query, table);
    }

    @Override
    public String getPreffix() {
        return "LEFT JOIN";
    }
}
