package com.code.advancedsql.query;

import advancedsql.query.join.*;
import com.code.advancedsql.table.ITable;
import com.code.advancedsql.query.join.*;

import java.util.ArrayList;
import java.util.List;

public class Select extends ExecuteQuery<Select> {


    private String[] columns = {"*"};

    private String distinct = null;

    private String order = null;

    private final List<IJoin> joins = new ArrayList<>();

    public Select(ITable table, String[] columns) {
        super(table);

        this.columns = columns;
    }

    public Select(ITable table) {
        this(table, new String[]{"*"});
    }

    /**
     * Set how the values will be ordered.
     * Example: .orderBy("id DESC")
     * @param order Values order
     */
    public Select order(String order) {
        return this.orderBy(order);
    }

    /**
     * Set how the values will be ordered.
     * Example: .orderBy("id DESC")
     * @param order Values order
     */
    public Select orderBy(String order) {
        this.order = order;

        return this;
    }

    /**
     * Set the columns that you want to fetch.
     * @param columns Columns array.
     * @return Query object.
     */
    public Select columns(String[] columns) {
        this.columns = columns;

        return this;
    }

    /**
     * Set DISTINCT attribute.
     * @param column Name of the column that you want to be distinct.
     */
    public void distinct(String column) {
        this.distinct = column;
    }

    /**
     * Join table.
     * @param table Table name.
     * @return IJoin object.
     */
    public IJoin join(String table) {
        IJoin join = new Join(this, table);

        this.joins.add(join);

        return join;
    }

    /**
     * Inner Join table.
     * @param table Table name.
     * @return IJoin object.
     */
    public IJoin innerJoin(String table) {
        IJoin join = new InnerJoin(this, table);

        this.joins.add(join);

        return join;
    }

    /**
     * Left Join table.
     * @param table Table name.
     * @return IJoin object.
     */
    public IJoin leftJoin(String table) {
        IJoin join = new LeftJoin(this, table);

        this.joins.add(join);

        return join;
    }

    /**
     * Right Join table.
     * @param table Table name.
     * @return IJoin object.
     */
    public IJoin rightJoin(String table) {
        IJoin join = new RightJoin(this, table);

        this.joins.add(join);

        return join;
    }

    /**
     * Full Join table.
     * @param table Table name.
     * @return IJoin object.
     */
    public IJoin fullJoin(String table) {
        IJoin join = new FullJoin(this, table);

        this.joins.add(join);

        return join;
    }

    @Override
    public String toQuery() {
        StringBuilder query = new StringBuilder("SELECT " + (this.distinct != null ? "DISTINCT " + this.distinct : ""));

        query.append(String.join(", ", this.columns));

        query.append(this.table != null ? " FROM " + this.table : "");

        for (IJoin join: this.joins) query.append(" ").append(join);

        query.append(this.where != null ? " WHERE " + this.where : "");

        query.append(this.order != null ? " ORDER BY " + this.order : "");

        query.append(this.limit > 0 ? " LIMIT " + this.limit : "");

        return query.toString().trim();
    }
}
