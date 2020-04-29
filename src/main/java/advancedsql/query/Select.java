package advancedsql.query;

import advancedsql.query.join.*;
import advancedsql.table.ITable;

import java.util.ArrayList;
import java.util.List;

public class Select extends Fetchable<Select> {


    private String[] columns = {"*"};

    private String distinct = null;

    private String order = null;

    private List<IJoin> joins = new ArrayList<>();

    public Select(ITable table) {
        super(table);
    }

    public void order(String order) {
        this.order = order;
    }

    public Select setColumns(String[] columns) {
        this.columns = columns;

        return this;
    }

    public Select columns(String[] columns) {
        return this.setColumns(columns);
    }

    public void distinct(String column) {
        this.distinct = column;
    }

    public IJoin join(String table) {
        IJoin join = new Join(this, table);

        this.joins.add(join);

        return join;
    }

    public IJoin innerJoin(String table) {
        IJoin join = new InnerJoin(this, table);

        this.joins.add(join);

        return join;
    }

    public IJoin leftJoin(String table) {
        IJoin join = new LeftJoin(this, table);

        this.joins.add(join);

        return join;
    }

    public IJoin rightJoin(String table) {
        IJoin join = new RightJoin(this, table);

        this.joins.add(join);

        return join;
    }

    public IJoin fullJoin(String table) {
        IJoin join = new FullJoin(this, table);

        this.joins.add(join);

        return join;
    }

    @Override
    public String toQuery() {
        StringBuilder query = new StringBuilder("SELECT " + (this.distinct != null ? "DISTINCT " + this.distinct : ""));

        query.append(String.join(",", this.columns));

        query.append(this.table != null ? " FROM " + this.table : "");

        for (IJoin join: this.joins) query.append(" ").append(join.toQuery());

        query.append(this.where != null ? " WHERE " + this.where : "");

        query.append(this.order != null ? " ORDER BY " + this.order : "");

        query.append(this.limit > 0 ? " LIMIT " + this.limit : "");

        return query.toString();
    }
}
