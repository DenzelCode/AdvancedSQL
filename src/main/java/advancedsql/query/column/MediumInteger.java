package advancedsql.query.column;

import advancedsql.query.action.IAction;

public class MediumInteger extends Numeric {

    public MediumInteger(IAction<IColumn> action, java.lang.String name) {
        super(action, name, false, false, 0);
    }

    public MediumInteger(IAction<IColumn> action, java.lang.String name, java.lang.Integer length) {
        super(action, name, false, false, length);
    }

    @Override
    public java.lang.String toString() {
        return this.action.getPrefix() + name + " MEDIUMINT" + (nullable ? " NULL" : " NOT NULL") + (length > 0 ? "(" + length + ")" : "") + (primary ? " PRIMARY KEY" : "") + (increment ? " AUTO_INCREMENT" : "") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
