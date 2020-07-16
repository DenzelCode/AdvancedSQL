package advancedsql.query;

import advancedsql.table.ITable;

public class Truncate extends ExecuteStatement<Truncate> {

    public Truncate(ITable table) {
        super(table);
    }

    @Override
    public String toQuery() {
        return "TRUNCATE TABLE " + this.table;
    }
}
