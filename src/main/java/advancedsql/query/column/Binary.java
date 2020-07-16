package advancedsql.query.column;

import advancedsql.query.action.IAction;

import java.io.InputStream;

public class Binary extends Column {

    protected InputStream defaultValue;

    public Binary(IAction<IColumn> action, java.lang.String name) {
        super(action, name, false);
    }

    public Binary defaultValue(InputStream value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        return this.action.getPrefix() + name + " BLOB" + (nullable ? " " : " NOT NULL ") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
