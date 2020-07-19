package advancedsql.query;

import advancedsql.table.ITable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class ExecuteUpdate<T extends IQuery> extends Specifiable<T> {

    public ExecuteUpdate(ITable table) {
        super(table);
    }

    @Override
    public PreparedStatement executePrepare() throws SQLException {
        System.out.println(this.execute);

        this.execute();

        return this.prepare;
    }

    /**
     * Execute the query.
     * @return An integer.
     * @throws SQLException Exception when something goes wrong.
     */
    public int execute() throws SQLException {
        return this.executeUpdate();
    }
}
