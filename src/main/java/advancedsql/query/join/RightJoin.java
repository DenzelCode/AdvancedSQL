package advancedsql.query.join;

import advancedsql.query.Select;

public class RightJoin extends Join {

    public RightJoin(Select query, String table) {
        super(query, table);
    }

    @Override
    public String getPreffix() {
        return "RIGHT JOIN";
    }
}
