package advancedsql.query;

import advancedsql.ISQL;
import advancedsql.table.ITable;

import java.sql.PreparedStatement;
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

    public T setLimit(int limit) {
        this.limit = limit;

        return (T)this;
    }

    public T limit(int limit) {
        return this.setLimit(limit);
    }

    public int getLimit() {
        return this.limit;
    }

    @Override
    public T where(String where) {
        this.where = where;

        return (T)this;
    }

    public T where(String where, Object... execute) {
        this.execute = Arrays.asList(execute);

        return this.where(where);
    }

    @Override
    public PreparedStatement executePrepare() throws SQLException {
        this.executeBoolean();

        return this.prepare;
    }

    @Override
    public boolean executeBoolean() throws SQLException {
        this.prepare = this.sql.prepare(this);

        ISQL.setStatementParameters(this.prepare, this.execute);

        return prepare.execute();
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
