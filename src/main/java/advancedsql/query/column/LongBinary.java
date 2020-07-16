package advancedsql.query.column;

import java.io.FileInputStream;
import java.io.InputStream;

public class LongBinary extends Column {

    protected InputStream defaultValue;

    public LongBinary(java.lang.String name) {
        super(name, false);
    }

    public LongBinary defaultValue(InputStream value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        return name + " LONGBLOB" + (nullable ? " " : " NOT NULL ") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
