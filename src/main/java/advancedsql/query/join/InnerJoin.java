package advancedsql.query.join;

import advancedsql.query.Select;

public class InnerJoin extends Join {

    public InnerJoin(Select query, String table) {
        super(query, table);
    }

    @Override
    public String getPreffix() {
        return "INNER JOIN";
    }
}
