package com.code.advancedsql.query.column;

public interface IColumn {

    /**
     * @return Column name.
     */
    java.lang.String setName();

    /**
     * Allow null values on a column.
     * @return Column object.
     */
    IColumn nullable();

    /**
     * Allow SQL code on default.
     * @return Column object.
     */
    IColumn nativeDefault();

    /**
     * @return String representation of the column.
     */
    java.lang.String toString();
}
