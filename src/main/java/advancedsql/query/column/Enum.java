package advancedsql.query.column;

import java.util.Arrays;
import java.util.List;

public class Enum extends Column {

    protected Object[] list;

    protected Object defaultValue;

    public Enum(java.lang.String name, Object[] list) {
        super(name, false);

        this.name = name;

        this.list = list;
    }

    public Enum defaultValue(Object value) {
        this.defaultValue = value;

        return this;
    }

    @Override
    public java.lang.String toString() {
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < list.length; i++) {
            if (list.length == 1 || i == list.length - 1)
                string.append("'").append(list[i]).append("'");
            else
                string.append("'").append(list[i]).append("', ");
        }

        return name + " ENUM(" + string.toString() + ")" + (defaultValue != null ? " DEFAULT " + (!nativeDefault ? "'" + defaultValue + "'" : defaultValue) : "");
    }
}
