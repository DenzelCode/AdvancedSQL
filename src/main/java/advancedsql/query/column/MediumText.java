package advancedsql.query.column;

public class MediumText extends Column {

    protected java.lang.String defaultValue;

    public MediumText(java.lang.String name) {
        super(name, false);
    }

    public MediumText defaultValue(java.lang.String value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        return name + (nullable ? " " : " NOT NULL ") + "MEDIUMTEXT" + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
