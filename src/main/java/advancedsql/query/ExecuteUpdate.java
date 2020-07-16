package advancedsql.query;

import advancedsql.table.ITable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class ExecuteUpdate<T extends IQuery> extends Query<T> {

    public ExecuteUpdate(ITable table) {
        super(table);
    }

    @Override
    public PreparedStatement executePrepare() throws SQLException {
        this.execute();

        return this.prepare;
    }

    public int execute() throws SQLException {
        return this.executeUpdate();
    }
}
