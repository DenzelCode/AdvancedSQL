package advancedsql.query.column;

public class LongText extends Column {

    protected java.lang.String defaultValue;
    public LongText defaultValue(java.lang.String value) {
        this.defaultValue = value;

        return this;
    }

    public LongText(java.lang.String name) {
        super(name, false);
    }

    @Override
    public java.lang.String toString() {
        return name + (nullable ? " " : " NOT NULL ") + "LONGTEXT" + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
