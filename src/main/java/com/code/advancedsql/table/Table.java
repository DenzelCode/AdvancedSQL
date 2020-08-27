package com.code.advancedsql.table;

import com.code.advancedsql.ISQL;
import com.code.advancedsql.SQL;
import com.code.advancedsql.query.*;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class Table implements ITable {

    protected String name;

    protected ISQL sql;

    public Table(SQL sql, String name) {
        this.sql = sql;

        this.name = name;
    }

    public boolean exists() throws SQLException {
        DatabaseMetaData metaData = sql.getConnection().getMetaData();

        ResultSet tables = metaData.getTables(null, null, this.name, null);

        return tables.next();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ISQL getSQL() {
        return this.sql;
    }

    @Override
    public Select select() {
        return new Select(this);
    }

    @Override
    public Select select(String[] columns) {
        return new Select(this, columns);
    }

    @Override
    public Create create() {
        return new Create(this);
    }

    @Override
    public Alter alter() {
        return new Alter(this);
    }

    @Override
    public Insert insert() {
        return new Insert(this);
    }

    @Override
    public Insert insert(Map<String, Object> fields) {
        return new Insert(this, fields);
    }

    @Override
    public Update update() {
        return new Update(this);
    }

    @Override
    public Update update(Map<String, Object> fields) {
        return new Update(this, fields);
    }

    @Override
    public Delete delete() {
        return new Delete(this);
    }

    @Override
    public Truncate truncate() {
        return new Truncate(this);
    }

    @Override
    public Drop drop() {
        return new Drop(this);
    }
}
