package advancedsql.table;

import advancedsql.ISQL;
import advancedsql.SQL;
import advancedsql.query.*;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public Create create() {
        return new Create(this);
    }

    @Override
    public Insert insert() {
        return new Insert(this);
    }

    @Override
    public Update update() {
        return new Update(this);
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
