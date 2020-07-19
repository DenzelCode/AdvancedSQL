package advancedsql.query;

import advancedsql.ISQL;
import advancedsql.table.ITable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Query<T extends IQuery> implements IQuery {

    protected ISQL sql = null;

    protected String table = null;

    protected List<Object> execute = new ArrayList<>();

    protected PreparedStatement prepare = null;

    protected String where = null;

    protected int limit = 0;

    private T instance;

    public Query(ITable table) {
        this.sql = table.getSQL();

        this.table = table.getName();
    }

    /**
     * Assign the limit of rows to be affected.
     * @param limit Limit amount.
     * @return Query object.
     */
    public T limit(int limit) {
        this.limit = limit;

        return (T)this;
    }

    /**
     * @return Limit of rows to be affected.
     */
    public int getLimit() {
        return this.limit;
    }

    @Override
    public T where(String where) {
        this.where = where;

        return (T)this;
    }

    public T where(String where, Object... execute) {
        this.execute.addAll(Arrays.asList(execute));

        return this.where(where);
    }

    public Boolean executeStatement() throws SQLException {
        prepare = this.sql.prepare(this);

        ISQL.setStatementParameters(this.prepare, this.execute);

        return prepare.execute();
    }

    public ResultSet executeQuery() throws SQLException {
        prepare = this.sql.prepare(this);

        ISQL.setStatementParameters(this.prepare, this.execute);

        return prepare.executeQuery();
    }

    public int executeUpdate() throws SQLException {
        prepare = this.sql.prepare(this);

        ISQL.setStatementParameters(this.prepare, this.execute);

        return prepare.executeUpdate();
    }

    public abstract String toQuery();

    public PreparedStatement getPrepare() {
        return prepare;
    }

    @Override
    public String toString() {
        return this.toQuery();
    }
}
