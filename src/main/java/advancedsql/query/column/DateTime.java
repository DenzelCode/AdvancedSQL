package advancedsql.query.column;

import advancedsql.query.action.IAction;

public class DateTime extends Column {

    protected java.lang.String defaultValue;

    public DateTime(IAction<IColumn> action, java.lang.String name) {
        super(action, name, false);
    }

    public DateTime defaultValue(java.lang.String value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        return this.action.getPrefix() + name + " DATETIME" + (nullable ? " " : " NOT NULL ") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
