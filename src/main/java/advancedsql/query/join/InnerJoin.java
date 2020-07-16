package advancedsql.query.join;

import advancedsql.query.Select;

public class InnerJoin extends Join {

    public InnerJoin(Select query, String table) {
        super(query, table);
    }

    @Override
    public String getPrefix() {
        return "INNER JOIN";
    }
}
