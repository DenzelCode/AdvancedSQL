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

    /**
     * Create a primary column with auto incremented.
     * Example: int(11) PRIMARY KEY AUTO_INCREMENT
     * @param name Column name.
     * @return Integer column object.
     */
    public advancedsql.query.column.Integer id(String name) {
        return this.action.id(name);
    }

    /**
     * Create BIGINT column.
     * @param name Column name.
     * @return BigInteger column object.
     */
    public advancedsql.query.column.BigInteger bigInteger(String name) {
        return this.bigInteger(name, 0);
    }

    /**
     * Create BIGINT column.
     * @param name Column name.
     * @param length Column value max length.
     * @return BigInteger column object.
     */
    public advancedsql.query.column.BigInteger bigInteger(String name, Integer length) {
        return this.action.bigInteger(name, length);
    }

    /**
     * Create MEDIUMINT column.
     * @param name Column name.
     * @return MediumInteger column object.
     */
    public advancedsql.query.column.MediumInteger mediumInteger(String name) {
        return this.mediumInteger(name, 0);
    }

    /**
     * Create MEDIUMINT column.
     * @param name Column name.
     * @param length Column value max length.
     * @return MediumInteger column object.
     */
    public advancedsql.query.column.MediumInteger mediumInteger(String name, Integer length) {
        return this.action.mediumInteger(name, length);
    }

    /**
     * Create TINYINT column.
     * @param name Column name.
     * @return MediumInteger column object.
     */
    public advancedsql.query.column.TinyInteger tinyInteger(String name) {
        return this.tinyInteger(name, 0);
    }

    /**
     * Create TINYINT column.
     * @param name Column name.
     * @param length Column value max length.
     * @return TinyInteger column object.
     */
    public advancedsql.query.column.TinyInteger tinyInteger(String name, Integer length) {
        return this.action.tinyInteger(name, length);
    }

    /**
     * Create SMALLINT column.
     * @param name Column name.
     * @return SmallInteger column object.
     */
    public advancedsql.query.column.SmallInteger smallInteger(String name) {
        return this.smallInteger(name, 0);
    }

    /**
     * Create SMALLINT column.
     * @param name Column name.
     * @param length Column value max length.
     * @return SmallInteger column object.
     */
    public advancedsql.query.column.SmallInteger smallInteger(String name, Integer length) {
        return this.action.smallInteger(name, length);
    }

    /**
     * Create INT column.
     * @param name Column name.
     * @return Integer column object.
     */
    public advancedsql.query.column.Integer integer(String name) {
        return this.integer(name, 11);
    }

    /**
     * Create INT column.
     * @param name Column name.
     * @param length Column value max length.
     * @return Integer column object.
     */
    public advancedsql.query.column.Integer integer(String name, Integer length) {
        return this.action.integer(name, length);
    }

    /**
     * Create TEXT column.
     * @param name Column name.
     * @return Text column object.
     */
    public advancedsql.query.column.Text text(String name) {
        return this.action.text(name);
    }

    /**
     * Create MEDIUMTEXT column.
     * @param name Column name.
     * @return MediumText column object.
     */
    public advancedsql.query.column.MediumText mediumText(String name) {
        return this.action.mediumText(name);
    }

    /**
     * Create BLOB column.
     * @param name Column name.
     * @return Binary column object.
     */
    public advancedsql.query.column.Binary binary(String name) {
        return this.action.binary(name);
    }

    /**
     * Create LONGBLOB column.
     * @param name Column name.
     * @return LongBinary column object.
     */
    public advancedsql.query.column.LongBinary longBinary(String name) {
        return this.action.longBinary(name);
    }

    /**
     * Create LONGTEXT column.
     * @param name Column name.
     * @return LongText column object.
     */
    public advancedsql.query.column.LongText longText(String name) {
        return this.action.longText(name);
    }

    /**
     * Create BOOLEAN column.
     * @param name Column name.
     * @return Boolean column object.
     */
    public advancedsql.query.column.Boolean booleanColumn(String name) {
        return this.action.booleanColumn(name);
    }

    /**
     * Create DATE column.
     * @param name Column name.
     * @return Date column object.
     */
    public advancedsql.query.column.Date date(String name) {
        return this.action.date(name);
    }

    /**
     * Create DATETIME column.
     * @param name Column name.
     * @return DateTime column object.
     */
    public advancedsql.query.column.DateTime dateTime(String name) {
        return this.action.dateTime(name);
    }

    /**
     * Create TIMESTAMP column.
     * @param name Column name.
     * @return Timestamp column object.
     */
    public advancedsql.query.column.Timestamp timestamp(String name) {
        return this.action.timestamp(name);
    }

    /**
     * Create DECIMAL column.
     * @param name Column name.
     * @param precision Number precision.
     * @return Decimal column object.
     */
    public advancedsql.query.column.Decimal decimal(String name, Integer length, Integer precision) {
        return this.action.decimal(name, length, precision);
    }

    /**
     * Create DECIMAL column.
     * @param name Column name.
     * @return Decimal column object.
     */
    public advancedsql.query.column.Decimal decimal(String name) {
        return this.decimal(name, 5, 2);
    }

    /**
     * Create FLOAT column.
     * @param name Column name.
     * @param precision Number precision.
     * @return Float column object.
     */
    public advancedsql.query.column.Float floatColumn(String name, Integer length, Integer precision) {
        return this.action.floatColumn(name, length, precision);
    }

    /**
     * Create FLOAT column.
     * @param name Column name.
     * @return Float column object.
     */
    public advancedsql.query.column.Float floatColumn(String name) {
        return this.floatColumn(name, 11, 6);
    }

    /**
     * Create DOUBLE column.
     * @param name Column name.
     * @param precision Number precision.
     * @return Double column object.
     */
    public advancedsql.query.column.Double doubleColumn(String name, Integer length, Integer precision) {
        return this.action.doubleColumn(name, length, precision);
    }

    /**
     * Create DOUBLE column.
     * @param name Column name.
     * @return Double column object.
     */
    public advancedsql.query.column.Double doubleColumn(String name) {
        return this.doubleColumn(name, 11, 8);
    }

    /**
     * Create a primary column with auto incremented.
     * Example: int(11) PRIMARY KEY AUTO_INCREMENT
     *
     * @return Integer column.
     */
    public advancedsql.query.column.Integer id() {
        return this.id("id");
    }

    /**
     * Create VARCHAR column.
     * @param name Column name.
     * @return String column object.
     */
    public advancedsql.query.column.String string(String name) {
        return this.string(name, 255);
    }

    /**
     * Create VARCHAR column.
     * @param name Column name.
     * @param length Column value max length.
     * @return String column object.
     */
    public advancedsql.query.column.String string(String name, Integer length) {
        return this.action.string(name, length);
    }

    /**
     * Create ENUM column.
     * @param name Column name.
     * @param list Array of values for the enum.
     * @return Enum column object.
     */
    public advancedsql.query.column.Enum enumColumn(String name, Object[] list) {
        return this.action.enumColumn(name, list);
    }

    /**
     * Create custom column.
     * @param name Column name.
     * @param content Column content. (Type, attributes, etc.)
     * @return Base column object.
     */
    public Base column(java.lang.String name, String content) {
        return this.action.column(name, content);
    }

    @Override
    public java.lang.String toQuery() {
        StringBuilder query = new StringBuilder("CREATE TABLE " + this.table + " ( ");

        List<IColumn> columns = this.action.getColumns();

        for (int i = 0; i < columns.size(); i++) query.append(i != columns.size() - 1 ? columns.get(i).toString() + ", " : columns.get(i).toString() + " ");

        query.append(")");

        return query.toString().trim();
    }
}
