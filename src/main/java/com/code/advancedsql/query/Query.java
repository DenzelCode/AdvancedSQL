package com.code.advancedsql.query;

import com.code.advancedsql.ISQL;
import com.code.advancedsql.table.ITable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class Query<T extends IQuery> implements IQuery {

    protected ISQL sql;

    protected String table;

    protected List<Object> execute = new ArrayList<>();

    protected PreparedStatement prepare = null;

    protected String where = null;

    protected int limit = 0;

    public Query(ITable table) {
        this.sql = table.getSQL();

        this.table = table.getName();
    }

    public Boolean executeStatement() throws SQLException {
        prepare = this.sql.prepare(this);

        ISQL.setStatementParameters(this.prepare, this.execute);

        boolean result = prepare.execute();

        prepare.close();

        return result;
    }

    public ResultSet executeQuery() throws SQLException {
        prepare = this.sql.prepare(this);

        ISQL.setStatementParameters(this.prepare, this.execute);

        return prepare.executeQuery();
    }

    public int executeUpdate() throws SQLException {
        prepare = this.sql.prepare(this);

        ISQL.setStatementParameters(this.prepare, this.execute);

        int result = prepare.executeUpdate();

        prepare.close();

        return result;
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
