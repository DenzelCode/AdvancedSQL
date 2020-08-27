package com.code.advancedsql.query.column;

import com.code.advancedsql.query.action.IAction;

import java.io.InputStream;

public class LongBinary extends Column {

    protected InputStream defaultValue;

    public LongBinary(IAction<IColumn> action, java.lang.String name) {
        super(action, name, false);
    }

    public LongBinary defaultValue(InputStream value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        return this.action.getPrefix() + name + " LONGBLOB" + (nullable ? " " : " NOT NULL ") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
