package advancedsql.query.join;

import advancedsql.query.Select;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
    public Select where(String where) {
        return this.query.where(where);
    }

    @Override
    public Select where(String where, Object... execute) {
        return this.query.where(where, execute);
    }

    @Override
    public PreparedStatement executePrepare() throws SQLException {
        return this.query.executePrepare();
    }

    @Override
    public ResultSet execute() throws SQLException {
        return this.executeQuery();
    }

    @Override
    public Map<String, Object> fetch() throws SQLException {
        return this.query.fetch();
    }

    @Override
    public ResultSet fetchAll() throws SQLException {
        return this.query.fetchAll();
    }

    @Override
    public List<Map<String, Object>> fetchAllAsList() throws SQLException {
        return this.query.fetchAllAsList();
    }

    @Override
    public Boolean executeStatement() throws SQLException {
        return this.query.executeStatement();
    }

    @Override
    public ResultSet executeQuery() throws SQLException {
        return this.query.executeQuery();
    }

    @Override
    public int executeUpdate() throws SQLException {
        return this.query.executeUpdate();
    }

    @Override
    public String getPrefix() {
        return "JOIN";
    }

    @Override
    public Select getQuery() {
        return query;
    }

    @Override
    public String toQuery() {
        StringBuilder query = new StringBuilder(this.getPrefix() + " " + this.table);

        query.append(this.as != null ? " AS " + this.as : "");

        query.append(this.on != null ? " ON (" + this.on + ")" : "");

        query.append(this.using != null ? " USING (" + String.join(", ", this.using) + ")" : " ");

        return query.toString();
    }

    @Override
    public String toString() {
        return this.toQuery();
    }
}
