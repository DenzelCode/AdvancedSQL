package com.code.advancedsql.query.action;

import com.code.advancedsql.query.column.Base;
import com.code.advancedsql.query.column.*;
import com.code.advancedsql.query.column.Boolean;
import com.code.advancedsql.query.column.Double;
import com.code.advancedsql.query.column.Enum;
import com.code.advancedsql.query.column.Float;
import com.code.advancedsql.query.column.Integer;

import java.lang.String;

public interface IActionColumns {

    /**
     * Create a primary column with auto incremented.
     * Example: int(11) PRIMARY KEY AUTO_INCREMENT
     * @param name Column name.
     * @return Integer column object.
     */
    Integer id(String name);

    /**
     * Create BIGINT column.
     * @param name Column name.
     * @return BigInteger column object.
     */
    BigInteger bigInteger(String name);

    /**
     * Create BIGINT column.
     * @param name Column name.
     * @param length Column value max length.
     * @return BigInteger column object.
     */
    BigInteger bigInteger(String name, java.lang.Integer length);

    /**
     * Create MEDIUMINT column.
     * @param name Column name.
     * @return MediumInteger column object.
     */
    MediumInteger mediumInteger(String name);

    /**
     * Create MEDIUMINT column.
     * @param name Column name.
     * @param length Column value max length.
     * @return MediumInteger column object.
     */
    MediumInteger mediumInteger(String name, java.lang.Integer length);

    /**
     * Create TINYINT column.
     * @param name Column name.
     * @return MediumInteger column object.
     */
    TinyInteger tinyInteger(String name);

    /**
     * Create TINYINT column.
     * @param name Column name.
     * @param length Column value max length.
     * @return TinyInteger column object.
     */
    TinyInteger tinyInteger(String name, java.lang.Integer length);

    /**
     * Create SMALLINT column.
     * @param name Column name.
     * @return SmallInteger column object.
     */
    SmallInteger smallInteger(String name);

    /**
     * Create SMALLINT column.
     * @param name Column name.
     * @param length Column value max length.
     * @return SmallInteger column object.
     */
    SmallInteger smallInteger(String name, java.lang.Integer length);

    /**
     * Create INT column.
     * @param name Column name.
     * @return Integer column object.
     */
    Integer integer(String name);

    /**
     * Create INT column.
     * @param name Column name.
     * @param length Column value max length.
     * @return Integer column object.
     */
    Integer integer(String name, java.lang.Integer length);

    /**
     * Create TEXT column.
     * @param name Column name.
     * @return Text column object.
     */
    Text text(String name);

    /**
     * Create MEDIUMTEXT column.
     * @param name Column name.
     * @return MediumText column object.
     */
    MediumText mediumText(String name);

    /**
     * Create BLOB column.
     * @param name Column name.
     * @return Binary column object.
     */
    Binary binary(String name);

    /**
     * Create LONGBLOB column.
     * @param name Column name.
     * @return LongBinary column object.
     */
    LongBinary longBinary(String name);

    /**
     * Create LONGTEXT column.
     * @param name Column name.
     * @return LongText column object.
     */
    LongText longText(String name);

    /**
     * Create BOOLEAN column.
     * @param name Column name.
     * @return Boolean column object.
     */
    Boolean booleanColumn(String name);

    /**
     * Create DATE column.
     * @param name Column name.
     * @return Date column object.
     */
    Date date(String name);

    /**
     * Create DATETIME column.
     * @param name Column name.
     * @return DateTime column object.
     */
    DateTime dateTime(String name);

    /**
     * Create TIMESTAMP column.
     * @param name Column name.
     * @return Timestamp column object.
     */
    Timestamp timestamp(String name);

    /**
     * Create DECIMAL column.
     * @param name Column name.
     * @param precision Number precision.
     * @return Decimal column object.
     */
    Decimal decimal(String name, java.lang.Integer length, java.lang.Integer precision);

    /**
     * Create DECIMAL column.
     * @param name Column name.
     * @return Decimal column object.
     */
    Decimal decimal(String name);

    /**
     * Create FLOAT column.
     * @param name Column name.
     * @param precision Number precision.
     * @return Float column object.
     */
    Float floatColumn(String name, java.lang.Integer length, java.lang.Integer precision);

    /**
     * Create FLOAT column.
     * @param name Column name.
     * @return Float column object.
     */
    Float floatColumn(String name);

    /**
     * Create DOUBLE column.
     * @param name Column name.
     * @param precision Number precision.
     * @return Double column object.
     */
    Double doubleColumn(String name, java.lang.Integer length, java.lang.Integer precision);

    /**
     * Create DOUBLE column.
     * @param name Column name.
     * @return Double column object.
     */
    Double doubleColumn(String name);

    /**
     * Create a primary column with auto incremented.
     * Example: int(11) PRIMARY KEY AUTO_INCREMENT
     *
     * @return Integer column.
     */
    Integer id();

    /**
     * Create VARCHAR column.
     * @param name Column name.
     * @return String column object.
     */
    com.code.advancedsql.query.column.String string(String name);

    /**
     * Create VARCHAR column.
     * @param name Column name.
     * @param length Column value max length.
     * @return String column object.
     */
    com.code.advancedsql.query.column.String string(String name, java.lang.Integer length);

    /**
     * Create ENUM column.
     * @param name Column name.
     * @param list Array of values for the enum.
     * @return Enum column object.
     */
    Enum enumColumn(String name, Object[] list);

    /**
     * Create custom column.
     * @param name Column name.
     * @param content Column content. (Type, attributes, etc.)
     * @return Base column object.
     */
    Base column(java.lang.String name, String content);
}
