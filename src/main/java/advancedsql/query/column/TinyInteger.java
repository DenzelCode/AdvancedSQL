package advancedsql.query.column;

public class TinyInteger extends Numeric {

    public TinyInteger(java.lang.String name) {
        super(name, false, false, 0);
    }

    public TinyInteger(java.lang.String name, java.lang.Integer length) {
        super(name, false, false, length);
    }

    @Override
    public java.lang.String toString() {
        return name + " TINYINT" + (nullable ? " " : " NOT NULL ") + (length > 0 ? "(" + length + ")" : "") + (primary ? " PRIMARY KEY" : "") + (increment ? " AUTO_INCREMENT" : "") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
