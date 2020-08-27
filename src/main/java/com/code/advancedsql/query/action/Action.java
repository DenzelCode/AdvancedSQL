package com.code.advancedsql.query.action;

import com.code.advancedsql.query.column.Base;
import com.code.advancedsql.query.column.Boolean;
import com.code.advancedsql.query.column.IColumn;
import com.code.advancedsql.query.column.*;
import com.code.advancedsql.query.column.Double;
import com.code.advancedsql.query.column.Enum;
import com.code.advancedsql.query.column.Float;

import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public abstract class Action implements IAction<IColumn>, IActionColumns {

    protected List<IColumn> columns = new ArrayList<>();

    public com.code.advancedsql.query.column.Integer id(String name) {
        com.code.advancedsql.query.column.Integer column = this.integer(name);

        column.primary().increment().unsigned();

        return column;
    }

    /**
     * Create a column with type BIGINT.
     * @param name Name of the column.
     * @return
     */
    public BigInteger bigInteger(String name) {
        return this.bigInteger(name, 0);
    }

    public BigInteger bigInteger(String name, Integer length) {
        BigInteger column = new BigInteger(this, name, length);

        this.columns.add(column);

        return column;
    }

    public MediumInteger mediumInteger(String name) {
        return this.mediumInteger(name, 0);
    }

    public MediumInteger mediumInteger(String name, Integer length) {
        MediumInteger column = new MediumInteger(this, name, length);

        this.columns.add(column);

        return column;
    }

    public TinyInteger tinyInteger(String name) {
        return this.tinyInteger(name, 0);
    }

    public TinyInteger tinyInteger(String name, Integer length) {
        TinyInteger column = new TinyInteger(this, name, length);

        this.columns.add(column);

        return column;
    }

    public SmallInteger smallInteger(String name) {
        return this.smallInteger(name, 0);
    }

    public SmallInteger smallInteger(String name, Integer length) {
        SmallInteger column = new SmallInteger(this, name, length);

        this.columns.add(column);

        return column;
    }

    public com.code.advancedsql.query.column.Integer integer(String name) {
        return this.integer(name, 11);
    }

    public com.code.advancedsql.query.column.Integer integer(String name, Integer length) {
        com.code.advancedsql.query.column.Integer column = new com.code.advancedsql.query.column.Integer(this, name, length);

        this.columns.add(column);

        return column;
    }

    public Text text(String name) {
        Text column = new Text(this, name);

        this.columns.add(column);

        return column;
    }

    public MediumText mediumText(String name) {
        MediumText column = new MediumText(this, name);

        this.columns.add(column);

        return column;
    }

    public Binary binary(String name) {
        Binary column = new Binary(this, name);

        this.columns.add(column);

        return column;
    }

    public LongBinary longBinary(String name) {
        LongBinary column = new LongBinary(this, name);

        this.columns.add(column);

        return column;
    }

    public LongText longText(String name) {
        LongText column = new LongText(this, name);

        this.columns.add(column);

        return column;
    }

    public Boolean booleanColumn(String name) {
        Boolean column = new Boolean(this, name);

        this.columns.add(column);

        return column;
    }

    public Date date(String name) {
        Date column = new Date(this, name);

        this.columns.add(column);

        return column;
    }

    public DateTime dateTime(String name) {
        DateTime column = new DateTime(this, name);

        this.columns.add(column);

        return column;
    }

    public Timestamp timestamp(String name) {
        Timestamp column = new Timestamp(this, name);

        this.columns.add(column);

        return column;
    }

    public Decimal decimal(String name, Integer length, Integer precision) {
        Decimal column = new Decimal(this, name, length, precision);

        this.columns.add(column);

        return column;
    }

    public Decimal decimal(String name) {
        return this.decimal(name, 5, 2);
    }

    public Float floatColumn(String name, Integer length, Integer precision) {
        Float column = new Float(this, name, length, precision);

        this.columns.add(column);

        return column;
    }

    public Float floatColumn(String name) {
        return this.floatColumn(name, 11, 6);
    }

    public Double doubleColumn(String name, Integer length, Integer precision) {
        Double column = new Double(this, name, length, precision);

        this.columns.add(column);

        return column;
    }

    public Double doubleColumn(String name) {
        return this.doubleColumn(name, 11, 8);
    }

    public com.code.advancedsql.query.column.Integer id() {
        return this.id("id");
    }

    public com.code.advancedsql.query.column.String string(String name) {
        return this.string(name, 255);
    }

    public com.code.advancedsql.query.column.String string(String name, Integer length) {
        com.code.advancedsql.query.column.String column = new com.code.advancedsql.query.column.String(this, name, length, false);

        this.columns.add(column);

        return column;
    }

    public Enum enumColumn(String name, Object[] list) {
        Enum column = new Enum(this, name, list);

        this.columns.add(column);

        return column;
    }

    public Base column(java.lang.String name, String content) {
        Base column = new Base(this, name, content);

        this.columns.add(column);

        return column;
    }

    @Override
    public List<IColumn> getColumns() {
        return columns;
    }

    @Override
    public String getPrefix() {
        return null;
    }
}
