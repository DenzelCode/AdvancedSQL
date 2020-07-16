package advancedsql.query.column;

public class Boolean extends Column {

    protected java.lang.String defaultValue;

    public Boolean(java.lang.String name) {
        super(name, false);
    }

    public Boolean defaultValue(java.lang.String value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        return name + (nullable ? " " : " NOT NULL ") + "BOOLEAN" + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
