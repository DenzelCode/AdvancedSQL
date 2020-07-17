package advancedsql.query.join;

import advancedsql.query.IQuery;
import advancedsql.query.Select;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Join implements IJoin {

    protected Select query = null;

    protected String table = null;

    protected String on = null;

    protected String as = null;

    protected String[] using = null;

    public Join(Select query, String table) {
        this.query = query;

        this.table = table;
    }

    @Override
    public IJoin on(String conditional) {
        this.on = conditional;

        return this;
    }

    @Override
    public IJoin as(String name) {
        this.as = name;

        return this;
    }

    @Override
    public IJoin using(String[] columns) {
        this.using = columns;

        return this;
    }

    @Override
    public IJoin join(String table) {
        return this.query.join(table);
    }

    @Override
    public IJoin innerJoin(String table) {
        return this.query.innerJoin(table);
    }

    public IJoin leftJoin(String table) {
        return this.query.leftJoin(table);
    }

    @Override
    public IJoin rightJoin(String table) {
        return this.query.rightJoin(table);
    }

    @Override
    public IJoin fullJoin(String table) {
        return this.query.fullJoin(table);
    }

    @Override
    public IQuery where(String where) {
        return this.query.where(where);
    }

    @Override
    public IQuery where(String where, Object... execute) {
        return this.query.where(where, execute);
    }

    @Override
    public PreparedStatement executePrepare() throws SQLException {
        return this.query.executePrepare();
    }

    public PreparedStatement execute() throws SQLException {
        return this.executePrepare();
    }

    @Override
    public boolean executeStatement() throws SQLException {
        return this.query.executeStatement();
    }

    @Override
    public ResultSet executeQuery() throws SQLException {
        return this.query.executeQuery();
    }

    @Override
    public String getPrefix() {
        return "JOIN";
    }

    @Override
    public String toQuery() {
        StringBuilder query = new StringBuilder(this.getPrefix() + " " + this.table);

        query.append(this.as != null ? " AS " + this.as : "");

        query.append(this.on != null ? " ON (" + this.on + ")" : "");

        query.append(this.using != null ? " USING (" + String.join(", ", this.using) + ")" : " ");

        return query.toString();
    }
}
