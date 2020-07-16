package advancedsql.query.column;

import advancedsql.query.action.IAction;

public class String extends Column {

    protected java.lang.Integer length;

    protected java.lang.String defaultValue;

    public String(IAction<IColumn> action, java.lang.String name, java.lang.Integer length, java.lang.Boolean nullable) {
        super(action, name, nullable);

        this.name = name;

        this.length = length;
    }

    public String defaultValue(java.lang.String value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        return this.action.getPrefix() + name + " VARCHAR(" + length + ")" + (nullable ? " " : " NOT NULL") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
