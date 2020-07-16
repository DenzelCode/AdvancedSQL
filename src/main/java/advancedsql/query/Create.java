package advancedsql.query;

import advancedsql.query.column.Base;
import advancedsql.query.column.IColumn;
import advancedsql.table.ITable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Create extends Action<Create> {

    private List<IColumn> columns = new ArrayList<>();

    public Create(ITable table) {
        super(table);
    }

    /**
     * Create a primary column with auto incremented.
     * Example: int(11) PRIMARY KEY AUTO_INCREMENT
     *
     * @return advancedsql.query.column.Integer
     */
    public advancedsql.query.column.Integer id(String name) {
        advancedsql.query.column.Integer column = this.integer(name);

        column.primary().increment().unsigned();

        return column;
    }

    public advancedsql.query.column.BigInteger bigInteger(String name) {
        return this.bigInteger(name, 0);
    }

    public advancedsql.query.column.BigInteger bigInteger(String name, Integer length) {
        advancedsql.query.column.BigInteger column = new advancedsql.query.column.BigInteger(name, length);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.MediumInteger mediumInteger(String name) {
        return this.mediumInteger(name, 0);
    }

    public advancedsql.query.column.MediumInteger mediumInteger(String name, Integer length) {
        advancedsql.query.column.MediumInteger column = new advancedsql.query.column.MediumInteger(name, length);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.TinyInteger tinyInteger(String name) {
        return this.tinyInteger(name, 0);
    }

    public advancedsql.query.column.TinyInteger tinyInteger(String name, Integer length) {
        advancedsql.query.column.TinyInteger column = new advancedsql.query.column.TinyInteger(name, length);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.SmallInteger smallInteger(String name) {
        return this.smallInteger(name, 0);
    }
    public advancedsql.query.column.SmallInteger smallInteger(String name, Integer length) {
        advancedsql.query.column.SmallInteger column = new advancedsql.query.column.SmallInteger(name, length);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.Integer integer(String name) {
        return this.integer(name, 11);
    }

    public advancedsql.query.column.Integer integer(String name, Integer length) {
        advancedsql.query.column.Integer column = new advancedsql.query.column.Integer(name, length);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.Text text(String name) {
        advancedsql.query.column.Text column = new advancedsql.query.column.Text(name);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.MediumText mediumText(String name) {
        advancedsql.query.column.MediumText column = new advancedsql.query.column.MediumText(name);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.Binary binary(String name) {
        advancedsql.query.column.Binary column = new advancedsql.query.column.Binary(name);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.LongBinary longBinary(String name) {
        advancedsql.query.column.LongBinary column = new advancedsql.query.column.LongBinary(name);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.LongText longText(String name) {
        advancedsql.query.column.LongText column = new advancedsql.query.column.LongText(name);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.Boolean booleanColumn(String name) {
        advancedsql.query.column.Boolean column = new advancedsql.query.column.Boolean(name);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.Date date(String name) {
        advancedsql.query.column.Date column = new advancedsql.query.column.Date(name);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.DateTime dateTime(String name) {
        advancedsql.query.column.DateTime column = new advancedsql.query.column.DateTime(name);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.Timestamp timestamp(String name) {
        advancedsql.query.column.Timestamp column = new advancedsql.query.column.Timestamp(name);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.Decimal decimal(String name, Integer length, Integer precision) {
        advancedsql.query.column.Decimal column = new advancedsql.query.column.Decimal(name, length, precision);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.Decimal decimal(String name) {
        return this.decimal(name, 5, 2);
    }

    public advancedsql.query.column.Float floatColumn(String name, Integer length, Integer precision) {
        advancedsql.query.column.Float column = new advancedsql.query.column.Float(name, length, precision);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.Float floatColumn(String name) {
        return this.floatColumn(name, 11, 6);
    }

    public advancedsql.query.column.Double doubleColumn(String name, Integer length, Integer precision) {
        advancedsql.query.column.Double column = new advancedsql.query.column.Double(name, length, precision);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.Double doubleColumn(String name) {
        return this.doubleColumn(name, 11, 8);
    }

    /**
     * Create a primary column named "id" with auto incremented.
     * Example: int(11) PRIMARY KEY AUTO_INCREMENT
     *
     * @return advancedsql.query.column.Integer
     */
    public advancedsql.query.column.Integer id() {
        return this.id("id");
    }

    public advancedsql.query.column.String string(String name) {
        return this.string(name, 255);
    }

    public advancedsql.query.column.String string(String name, Integer length) {
        advancedsql.query.column.String column = new advancedsql.query.column.String(name, length, false);

        this.columns.add(column);

        return column;
    }

    public advancedsql.query.column.Enum enumColumn(String name, Object[] list) {
        advancedsql.query.column.Enum column = new advancedsql.query.column.Enum(name, list);

        this.columns.add(column);

        return column;
    }

    public Base column(java.lang.String name, String content) {
        Base column = new Base(name, content);

        this.columns.add(column);

        return column;
    }

    @Override
    public java.lang.String toQuery() {
        StringBuilder query = new StringBuilder("CREATE TABLE IF NOT EXISTS " + this.table + " ( ");

        for (int i = 0; i < this.columns.size(); i++) query.append(i != this.columns.size() - 1 ? this.columns.get(i).toString() + ", " : this.columns.get(i).toString() + " ");

        query.append(")");

        return query.toString();
    }
}
