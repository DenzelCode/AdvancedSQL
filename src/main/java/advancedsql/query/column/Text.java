package advancedsql.query.column;

import advancedsql.query.action.IAction;

public class Text extends Column {

    protected java.lang.String defaultValue;

    public Text(IAction<IColumn> action, java.lang.String name) {
        super(action, name, false);
    }

    public Text defaultValue(java.lang.String value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        return this.action.getPrefix() + name + " TEXT" + (nullable ? " " : " NOT NULL ") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
