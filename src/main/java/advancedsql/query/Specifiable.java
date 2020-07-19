package advancedsql.query;

import advancedsql.table.ITable;

import java.util.Arrays;

public abstract class Specifiable<T extends IQuery> extends Query<T> implements ISpecifiable {


    public Specifiable(ITable table) {
        super(table);
    }

    public T limit(int limit) {
        this.limit = limit;

        return (T)this;
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
        this.execute.addAll(Arrays.asList(execute));

        return this.where(where);
    }
}
