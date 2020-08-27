package com.code.advancedsql.query.column;

import com.code.advancedsql.query.action.IAction;

public class Double extends Numeric {

    protected java.lang.Integer precision;

    public Double(IAction<IColumn> action, java.lang.String name) {
        this(action, name, 11, 8);
    }

    public Double(IAction<IColumn> action, java.lang.String name, java.lang.Integer length, java.lang.Integer precision) {
        super(action, name, false, false, length);

        this.precision = precision;
    }

    @Override
    public java.lang.String toString() {
        return this.action.getPrefix() + name + " DOUBLE(" + length + ", " + precision + ")" + (nullable ? " " : " NOT NULL ") + (primary ? " PRIMARY KEY" : "") + (increment ? " AUTO_INCREMENT" : "")+ (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
