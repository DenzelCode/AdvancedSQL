package advancedsql.query;

import advancedsql.table.ITable;

import java.sql.SQLException;

public abstract class Action<T extends IQuery> extends Query<T> {

    public Action(ITable table) {
        super(table);
    }

    public Boolean execute() throws SQLException {
        return this.executeBoolean();
    }
}
