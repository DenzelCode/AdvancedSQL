package com.code.advancedsql.query.column;

import com.code.advancedsql.query.action.IAction;

abstract class Column implements IColumn {
    protected java.lang.String name;

    protected java.lang.Boolean nullable;

    protected java.lang.Boolean nativeDefault;

    protected IAction action;

    public Column(IAction<IColumn> action, java.lang.String name, boolean nullable) {
        this.name = name;

        this.nullable = nullable;

        this.nativeDefault = false;

        this.action = action;
    }

    @Override
    public java.lang.String setName() {
        return this.name;
    }

    @Override
    public IColumn nullable() {
        this.nullable = true;

        return this;
    }

    @Override
    public IColumn nativeDefault() {
        this.nativeDefault = true;

        return this;
    }

    public java.lang.String toString() {
        return null;
    }
}
