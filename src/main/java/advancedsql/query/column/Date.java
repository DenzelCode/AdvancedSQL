package advancedsql.query.column;

public class Date extends Column {

    protected java.lang.String defaultValue;

    public Date(java.lang.String name) {
        super(name, false);
    }

    public Date defaultValue(java.lang.String value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        return name + " DATE" + (nullable ? " " : " NOT NULL ") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
