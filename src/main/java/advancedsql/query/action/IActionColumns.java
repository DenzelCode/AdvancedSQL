package advancedsql.query.action;

import advancedsql.query.column.Base;

public interface IActionColumns {

    /**
     * Create a primary column with auto incremented.
     * Example: int(11) PRIMARY KEY AUTO_INCREMENT
     * @param name Column name.
     * @return Integer column object.
     */
    advancedsql.query.column.Integer id(String name);

    /**
     * Create BIGINT column.
     * @param name Column name.
     * @return BigInteger column object.
     */
    advancedsql.query.column.BigInteger bigInteger(String name);

    /**
     * Create BIGINT column.
     * @param name Column name.
     * @param length Column value max length.
     * @return BigInteger column object.
     */
    advancedsql.query.column.BigInteger bigInteger(String name, Integer length);

    /**
     * Create MEDIUMINT column.
     * @param name Column name.
     * @return MediumInteger column object.
     */
    advancedsql.query.column.MediumInteger mediumInteger(String name);

    /**
     * Create MEDIUMINT column.
     * @param name Column name.
     * @param length Column value max length.
     * @return MediumInteger column object.
     */
    advancedsql.query.column.MediumInteger mediumInteger(String name, Integer length);

    /**
     * Create TINYINT column.
     * @param name Column name.
     * @return MediumInteger column object.
     */
    advancedsql.query.column.TinyInteger tinyInteger(String name);

    /**
     * Create TINYINT column.
     * @param name Column name.
     * @param length Column value max length.
     * @return TinyInteger column object.
     */
    advancedsql.query.column.TinyInteger tinyInteger(String name, Integer length);

    /**
     * Create SMALLINT column.
     * @param name Column name.
     * @return SmallInteger column object.
     */
    advancedsql.query.column.SmallInteger smallInteger(String name);

    /**
     * Create SMALLINT column.
     * @param name Column name.
     * @param length Column value max length.
     * @return SmallInteger column object.
     */
    advancedsql.query.column.SmallInteger smallInteger(String name, Integer length);

    /**
     * Create INT column.
     * @param name Column name.
     * @return Integer column object.
     */
    advancedsql.query.column.Integer integer(String name);

    /**
     * Create INT column.
     * @param name Column name.
     * @param length Column value max length.
     * @return Integer column object.
     */
    advancedsql.query.column.Integer integer(String name, Integer length);

    /**
     * Create TEXT column.
     * @param name Column name.
     * @return Text column object.
     */
    advancedsql.query.column.Text text(String name);

    /**
     * Create MEDIUMTEXT column.
     * @param name Column name.
     * @return MediumText column object.
     */
    advancedsql.query.column.MediumText mediumText(String name);

    /**
     * Create BLOB column.
     * @param name Column name.
     * @return Binary column object.
     */
    advancedsql.query.column.Binary binary(String name);

    /**
     * Create LONGBLOB column.
     * @param name Column name.
     * @return LongBinary column object.
     */
    advancedsql.query.column.LongBinary longBinary(String name);

    /**
     * Create LONGTEXT column.
     * @param name Column name.
     * @return LongText column object.
     */
    advancedsql.query.column.LongText longText(String name);

    /**
     * Create BOOLEAN column.
     * @param name Column name.
     * @return Boolean column object.
     */
    advancedsql.query.column.Boolean booleanColumn(String name);

    /**
     * Create DATE column.
     * @param name Column name.
     * @return Date column object.
     */
    advancedsql.query.column.Date date(String name);

    /**
     * Create DATETIME column.
     * @param name Column name.
     * @return DateTime column object.
     */
    advancedsql.query.column.DateTime dateTime(String name);

    /**
     * Create TIMESTAMP column.
     * @param name Column name.
     * @return Timestamp column object.
     */
    advancedsql.query.column.Timestamp timestamp(String name);

    /**
     * Create DECIMAL column.
     * @param name Column name.
     * @param precision Number precision.
     * @return Decimal column object.
     */
    advancedsql.query.column.Decimal decimal(String name, Integer length, Integer precision);

    /**
     * Create DECIMAL column.
     * @param name Column name.
     * @return Decimal column object.
     */
    advancedsql.query.column.Decimal decimal(String name);

    /**
     * Create FLOAT column.
     * @param name Column name.
     * @param precision Number precision.
     * @return Float column object.
     */
    advancedsql.query.column.Float floatColumn(String name, Integer length, Integer precision);

    /**
     * Create FLOAT column.
     * @param name Column name.
     * @return Float column object.
     */
    advancedsql.query.column.Float floatColumn(String name);

    /**
     * Create DOUBLE column.
     * @param name Column name.
     * @param precision Number precision.
     * @return Double column object.
     */
    advancedsql.query.column.Double doubleColumn(String name, Integer length, Integer precision);

    /**
     * Create DOUBLE column.
     * @param name Column name.
     * @return Double column object.
     */
    advancedsql.query.column.Double doubleColumn(String name);

    /**
     * Create a primary column with auto incremented.
     * Example: int(11) PRIMARY KEY AUTO_INCREMENT
     *
     * @return Integer column.
     */
    advancedsql.query.column.Integer id();

    /**
     * Create VARCHAR column.
     * @param name Column name.
     * @return String column object.
     */
    advancedsql.query.column.String string(String name);

    /**
     * Create VARCHAR column.
     * @param name Column name.
     * @param length Column value max length.
     * @return String column object.
     */
    advancedsql.query.column.String string(String name, Integer length);

    /**
     * Create ENUM column.
     * @param name Column name.
     * @param list Array of values for the enum.
     * @return Enum column object.
     */
    advancedsql.query.column.Enum enumColumn(String name, Object[] list);

    /**
     * Create custom column.
     * @param name Column name.
     * @param content Column content. (Type, attributes, etc.)
     * @return Base column object.
     */
    Base column(java.lang.String name, String content);
}
