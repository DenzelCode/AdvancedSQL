package advancedsql.query;

import advancedsql.table.ITable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Update extends ExecuteUpdate<Update> {

    private final List<String> fields = new ArrayList<>();

    public Update(ITable table) {
        super(table);
    }

    public Update(ITable table, Map<String, Object> fields) {
        super(table);

        this.fields(fields);
    }

    /**
     * Columns and values that you want to update.
     * @param field Column name
     * @param value Row value
     * @return Query object.
     */
    public Update field(String field, Object value) {
        this.fields.add(field);

        this.execute.add(value);

        return this;
    }

    /**
     * Columns and values that you want to update.
     * @param values Map
     * @return Query object.
     */
    public Update fields(Map<String, Object> values) {
        for (Map.Entry<String, Object> entry: values.entrySet()) this.field(entry.getKey(), entry.getValue());

        return this;
    }

    @Override
    public String toQuery() {
        StringBuilder query = new StringBuilder("UPDATE " + this.table + " ");

        for (int i = 0; i < this.fields.size(); i++) query.append(this.fields.size() == 1 ? "SET " + this.fields.get(i) + " = ? " : (i == 0 ? "SET " + this.fields.get(i) + " = ?, " : (i != this.fields.size() - 1 ? this.fields.get(i) + " = ?, " : this.fields.get(i) + " = ?")));

        query.append(this.where != null ? "WHERE " + this.where : "");

        query.append(this.limit > 0 ? " LIMIT " + this.limit : "");

        return query.toString().trim();
    }
}
