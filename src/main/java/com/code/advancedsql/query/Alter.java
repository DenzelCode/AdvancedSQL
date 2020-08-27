package com.code.advancedsql.query;

import com.code.advancedsql.query.action.Add;
import com.code.advancedsql.query.column.IColumn;
import com.code.advancedsql.table.ITable;
import com.code.advancedsql.query.action.Drop;
import com.code.advancedsql.query.action.Modify;

import java.util.ArrayList;
import java.util.List;

public class Alter extends ExecuteStatement<Alter> {

    private final Add add = new Add();
    private final Modify modify = new Modify();
    private final Drop drop = new Drop();

    public Alter(ITable table) {
        super(table);
    }

    /**
     * @return "Drop" Object that allows you to specify the columns that you want to drop.
     */
    public Drop drop() {
        return drop;
    }

    /**
     * @return "Modify" Object that allows you to specify the columns that you want to modify.
     */
    public Modify modify() {
        return modify;
    }

    /**
     * @return "Add" Object that allows you to specify the columns that you want to add.
     */
    public Add add() {
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

        return query.toString().trim();
    }
}
