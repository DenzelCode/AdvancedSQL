package advancedsql.query.join;

import advancedsql.query.Select;

public class FullJoin extends Join {

    public FullJoin(Select query, String table) {
        super(query, table);
    }

    @Override
    public String getPreffix() {
        return "FULL JOIN";
    }
}
