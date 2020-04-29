package advancedsql.query;

import advancedsql.table.ITable;

public class Drop extends Action<Truncate> {


    public Drop(ITable table) {
        super(table);
    }

    @Override
    public String toQuery() {
        return "DROP TABLE " + this.table;
    }
}
