package advancedsql.query;

import advancedsql.table.ITable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Update extends ExecuteUpdate<Update> {

    private final List<String> fields = new ArrayList<>();

    private final List<Object> values = new ArrayList<>();

    public Update(ITable table) {
        super(table);
    }

    public Update(ITable table, Map<String, Object> fields) {
        super(table);

        this.setFields(fields);
    }

    public Update setField(String field, Object value) {
        this.fields.add(field);

        this.values.add(value);

        this.execute.add(value);

        return this;
    }

    public Update field(String field, Object value) {
        return this.setField(field, value);
    }

    public Update setFields(Map<String, Object> values) {
        for (Map.Entry<String, Object> entry: values.entrySet()) this.setField(entry.getKey(), entry.getValue());

        return this;
    }

    public Update fields(Map<String, Object> values) {
        return this.setFields(values);
    }

    @Override
    public String toQuery() {
        StringBuilder query = new StringBuilder("UPDATE " + this.table + " ");

        for (int i = 0; i < this.fields.size(); i++) query.append(this.fields.size() == 1 ? "SET " + this.fields.get(i) + " = ? " : (i == 0 ? "SET " + this.fields.get(i) + " = ?, " : (i != this.fields.size() - 1 ? this.fields.get(i) + " = ?, " : this.fields.get(i) + " = ?")));

        query.append(this.where != null ? " WHERE " + this.where : "");

        query.append(this.limit > 0 ? " LIMIT " + this.limit : "");

        return query.toString();
    }
}
