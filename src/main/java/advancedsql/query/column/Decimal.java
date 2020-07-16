package advancedsql.query.column;

public class Decimal extends Numeric {

    protected java.lang.Integer precision;

    public Decimal(java.lang.String name) {
        super(name, false, false, 5);

        this.precision = 2;
    }

    public Decimal(java.lang.String name, java.lang.Integer length, java.lang.Integer precision) {
        super(name, false, false, length);

        this.precision = precision;
    }

    @Override
    public java.lang.String toString() {
        return name + (nullable ? " " : " NOT NULL ") + "DECIMAL(" + length + ", " + precision + ")" + (primary ? " PRIMARY KEY" : "") + (increment ? " AUTO_INCREMENT" : "") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
