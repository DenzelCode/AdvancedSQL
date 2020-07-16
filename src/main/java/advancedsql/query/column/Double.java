package advancedsql.query.column;

public class Double extends Numeric {

    protected java.lang.Integer precision;

    public Double(java.lang.String name) {
        super(name, false, false, 11);

        this.precision = 8;
    }

    public Double(java.lang.String name, java.lang.Integer length, java.lang.Integer precision) {
        super(name, false, false, length);

        this.precision = precision;
    }

    @Override
    public java.lang.String toString() {
        return name + " DOUBLE(" + length + ", " + precision + ")" + (nullable ? " " : " NOT NULL ") + (primary ? " PRIMARY KEY" : "") + (increment ? " AUTO_INCREMENT" : "")+ (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
