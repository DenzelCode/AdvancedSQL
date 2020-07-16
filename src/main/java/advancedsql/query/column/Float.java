package advancedsql.query.column;

public class Float extends Numeric {

    protected java.lang.Integer precision;

    public Float(java.lang.String name) {
        super(name, false, false, 11);

        this.precision = 6;
    }

    public Float(java.lang.String name, java.lang.Integer length, java.lang.Integer precision) {
        super(name, false, false, length);

        this.precision = precision;
    }

    @Override
    public java.lang.String toString() {
        return name + " FLOAT(" + length + ", " + precision + ")" + (nullable ? " " : " NOT NULL ") + (primary ? " PRIMARY KEY" : "") + (increment ? " AUTO_INCREMENT" : "") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
