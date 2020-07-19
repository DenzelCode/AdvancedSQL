package advancedsql.query.column;

import advancedsql.query.action.IAction;

public class MediumText extends Column {

    protected java.lang.String defaultValue;

    public MediumText(IAction<IColumn> action, java.lang.String name) {
        super(action, name, false);
    }

    /**
     * Set default value.
     * @param value Default value.
     * @return Column object.
     */
    public MediumText defaultValue(java.lang.String value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        return this.action.getPrefix() + name + " MEDIUMTEXT" + (nullable ? " " : " NOT NULL ") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
