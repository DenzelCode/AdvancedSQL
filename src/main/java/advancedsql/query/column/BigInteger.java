package advancedsql.query.column;

public class BigInteger extends Numeric {

    public BigInteger(java.lang.String name) {
        super(name, false, false, 0);
    }

    public BigInteger(java.lang.String name, java.lang.Integer length) {
        super(name, false, false, length);
    }

    @Override
    public java.lang.String toString() {
        return name + " BIGINT" + (length > 0 ? "(" + length + ")" : "") + (nullable ? " " : " NOT NULL ") + (primary ? " PRIMARY KEY" : "") + (increment ? " AUTO_INCREMENT" : "") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
