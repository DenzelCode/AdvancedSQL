package advancedsql.query;

import advancedsql.query.column.IColumn;
import advancedsql.table.ITable;

import java.util.ArrayList;
import java.util.List;

public class Alter extends ExecuteStatement<Alter> {

    private final advancedsql.query.action.Add add = new advancedsql.query.action.Add();
    private final advancedsql.query.action.Modify modify = new advancedsql.query.action.Modify();
    private final advancedsql.query.action.Drop drop = new advancedsql.query.action.Drop();

    public Alter(ITable table) {
        super(table);
    }

    public advancedsql.query.action.Drop drop() {
        return drop;
    }

    public advancedsql.query.action.Modify modify() {
        return modify;
    }

    public advancedsql.query.action.Add add() {
        return add;
    }

    @Override
    public java.lang.String toQuery() {
        StringBuilder query = new StringBuilder("ALTER TABLE " + this.table + " ");

        List<IColumn> columns = new ArrayList<>();

        columns.addAll(add.getColumns());
        columns.addAll(modify.getColumns());

        List<String> dropColumns = drop.getColumns();

        for (int i = 0; i < columns.size(); i++) query.append(i != columns.size() - 1 ? columns.get(i).toString() + ", " : columns.get(i).toString() + (dropColumns.size() > 0 ? ", " : ";"));

        for (int i = 0; i < dropColumns.size(); i++) query.append(i != dropColumns.size() - 1 ? drop.getPrefix() + dropColumns.get(i) + ", " : drop.getPrefix() + dropColumns.get(i) + ";");

        return query.toString();
    }
}
