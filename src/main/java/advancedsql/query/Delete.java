package advancedsql.query;

import advancedsql.table.ITable;

public class Delete extends ExecuteUpdate<Delete> {

    public Delete(ITable table) {
        super(table);
    }

    @Override
    public String toQuery() {
        return "DELETE FROM " + this.table + (this.where != null ? " WHERE " + this.table : "") +
                (this.limit > 0 ? " LIMIT " + this.limit : "");
    }
}
