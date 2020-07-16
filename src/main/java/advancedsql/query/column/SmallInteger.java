package advancedsql.query.column;

public class SmallInteger extends Numeric {

    public SmallInteger(java.lang.String name) {
        super(name, false, false, 0);
    }

    public SmallInteger(java.lang.String name, java.lang.Integer length) {
        super(name, false, false, length);
    }

    @Override
    public java.lang.String toString() {
        return name + (nullable ? " " : " NOT NULL ") + "SMALLINT" + (length > 0 ? "(" + length + ")" : "") + (primary ? " PRIMARY KEY" : "") + (increment ? " AUTO_INCREMENT" : "") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
