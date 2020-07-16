package advancedsql.query.column;

public class Text extends Column {

    protected java.lang.String defaultValue;

    public Text(java.lang.String name) {
        super(name, false);
    }

    public Text defaultValue(java.lang.String value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        return name + " TEXT" + (nullable ? " " : " NOT NULL ") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
