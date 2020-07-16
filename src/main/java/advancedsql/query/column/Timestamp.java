package advancedsql.query.column;

public class Timestamp extends Column {

    protected java.lang.String defaultValue;

    public Timestamp(java.lang.String name) {
        super(name, false);
    }

    public Timestamp defaultValue(java.lang.String value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        return name + (nullable ? " " : " NOT NULL ") + "TIMESTAMP" + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
