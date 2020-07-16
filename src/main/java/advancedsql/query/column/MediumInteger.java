package advancedsql.query.column;

public class MediumInteger extends Numeric {

    public MediumInteger(java.lang.String name) {
        super(name, false, false, 0);
    }

    public MediumInteger(java.lang.String name, java.lang.Integer length) {
        super(name, false, false, length);
    }

    @Override
    public java.lang.String toString() {
        return name + " MEDIUMINT" + (nullable ? " " : " NOT NULL ") + (length > 0 ? "(" + length + ")" : "") + (primary ? " PRIMARY KEY" : "") + (increment ? " AUTO_INCREMENT" : "") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
