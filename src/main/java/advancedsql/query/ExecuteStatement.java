package advancedsql.query;

import advancedsql.table.ITable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class ExecuteStatement<T extends IQuery> extends Query<T> {

    public ExecuteStatement(ITable table) {
        super(table);
    }

    @Override
    public PreparedStatement executePrepare() throws SQLException {
        this.execute();

        return this.prepare;
    }

    public Boolean execute() throws SQLException {
        return this.executeStatement();
    }
}
