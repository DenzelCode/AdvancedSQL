package advancedsql.query.column;

public class String extends Column {

    protected java.lang.Integer length;

    protected java.lang.String defaultValue;

    public String(java.lang.String name, java.lang.Integer length, java.lang.Boolean nullable) {
        super(name, nullable);

        this.name = name;

        this.length = length;
    }

    public String defaultValue(java.lang.String value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        return name + (nullable ? " " : " NOT NULL ") + "VARCHAR(" + length + ")" + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
