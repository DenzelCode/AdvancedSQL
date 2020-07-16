package advancedsql.query.column;

import java.io.FileInputStream;
import java.io.InputStream;

public class Binary extends Column {

    protected InputStream defaultValue;

    public Binary(java.lang.String name) {
        super(name, false);
    }

    public Binary defaultValue(InputStream value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        return name + " BLOB" + (nullable ? " " : " NOT NULL ") + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
