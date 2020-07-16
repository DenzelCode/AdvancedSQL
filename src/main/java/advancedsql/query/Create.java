package advancedsql.query;

import advancedsql.query.action.Regular;
import advancedsql.query.column.Base;
import advancedsql.query.column.IColumn;
import advancedsql.table.ITable;

import java.util.List;

public class Create extends ExecuteStatement<Create> {

    private final advancedsql.query.action.Action action = new Regular();

    public Create(ITable table) {
        super(table);
    }

    public advancedsql.query.column.Integer id(String name) {
        return this.action.id(name);
    }

    public advancedsql.query.column.BigInteger bigInteger(String name) {
        return this.bigInteger(name, 0);
    }

    public advancedsql.query.column.BigInteger bigInteger(String name, Integer length) {
        return this.action.bigInteger(name, length);
    }

    public advancedsql.query.column.MediumInteger mediumInteger(String name) {
        return this.mediumInteger(name, 0);
    }

    public advancedsql.query.column.MediumInteger mediumInteger(String name, Integer length) {
        return this.action.mediumInteger(name, length);
    }

    public advancedsql.query.column.TinyInteger tinyInteger(String name) {
        return this.tinyInteger(name, 0);
    }

    public advancedsql.query.column.TinyInteger tinyInteger(String name, Integer length) {
        return this.action.tinyInteger(name, length);
    }

    public advancedsql.query.column.SmallInteger smallInteger(String name) {
        return this.smallInteger(name, 0);
    }

    public advancedsql.query.column.SmallInteger smallInteger(String name, Integer length) {
        return this.action.smallInteger(name, length);
    }

    public advancedsql.query.column.Integer integer(String name) {
        return this.integer(name, 11);
    }

    public advancedsql.query.column.Integer integer(String name, Integer length) {
        return this.action.integer(name, length);
    }

    public advancedsql.query.column.Text text(String name) {
        return this.action.text(name);
    }

    public advancedsql.query.column.MediumText mediumText(String name) {
        return this.action.mediumText(name);
    }

    public advancedsql.query.column.Binary binary(String name) {
        return this.action.binary(name);
    }

    public advancedsql.query.column.LongBinary longBinary(String name) {
        return this.action.longBinary(name);
    }

    public advancedsql.query.column.LongText longText(String name) {
        return this.action.longText(name);
    }

    public advancedsql.query.column.Boolean booleanColumn(String name) {
        return this.action.booleanColumn(name);
    }

    public advancedsql.query.column.Date date(String name) {
        return this.action.date(name);
    }

    public advancedsql.query.column.DateTime dateTime(String name) {
        return this.action.dateTime(name);
    }

    public advancedsql.query.column.Timestamp timestamp(String name) {
        return this.action.timestamp(name);
    }

    public advancedsql.query.column.Decimal decimal(String name, Integer length, Integer precision) {
        return this.action.decimal(name, length, precision);
    }

    public advancedsql.query.column.Decimal decimal(String name) {
        return this.decimal(name, 5, 2);
    }

    public advancedsql.query.column.Float floatColumn(String name, Integer length, Integer precision) {
        return this.action.floatColumn(name, length, precision);
    }

    public advancedsql.query.column.Float floatColumn(String name) {
        return this.floatColumn(name, 11, 6);
    }

    public advancedsql.query.column.Double doubleColumn(String name, Integer length, Integer precision) {
        return this.action.doubleColumn(name, length, precision);
    }

    public advancedsql.query.column.Double doubleColumn(String name) {
        return this.doubleColumn(name, 11, 8);
    }

    public advancedsql.query.column.Integer id() {
        return this.id("id");
    }

    public advancedsql.query.column.String string(String name) {
        return this.string(name, 255);
    }

    public advancedsql.query.column.String string(String name, Integer length) {
        return this.action.string(name, length);
    }

    public advancedsql.query.column.Enum enumColumn(String name, Object[] list) {
        return this.action.enumColumn(name, list);
    }

    public Base column(java.lang.String name, String content) {
        return this.action.column(name, content);
    }

    @Override
    public java.lang.String toQuery() {
        StringBuilder query = new StringBuilder("CREATE TABLE " + this.table + " ( ");

        List<IColumn> columns = this.action.getColumns();

        for (int i = 0; i < columns.size(); i++) query.append(i != columns.size() - 1 ? columns.get(i).toString() + ", " : columns.get(i).toString() + " ");

        query.append(")");

        return query.toString();
    }
}
