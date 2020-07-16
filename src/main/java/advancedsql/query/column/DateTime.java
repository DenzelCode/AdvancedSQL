package advancedsql.query.column;

public class DateTime extends Column {

    protected java.lang.String defaultValue;

    public DateTime(java.lang.String name) {
        super(name, false);
    }

    public DateTime defaultValue(java.lang.String value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        return name + " DATETIME" + (nullable ? " " : " NOT NULL ") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
