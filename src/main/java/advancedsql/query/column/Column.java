package advancedsql.query.column;

class Column implements IColumn {
    protected java.lang.String name;

    protected java.lang.Boolean nullable;

    protected java.lang.Boolean nativeDefault;

    public Column(java.lang.String name, boolean nullable) {
        this.name = name;

        this.nullable = nullable;

        this.nativeDefault = false;
    }

    @Override
    public java.lang.String setName() {
        return this.name;
    }

    @Override
    public IColumn nullable() {
        this.nativeDefault = true;

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
