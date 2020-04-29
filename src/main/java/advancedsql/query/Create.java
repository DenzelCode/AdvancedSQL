package advancedsql.query;

import advancedsql.table.ITable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Create extends Action<Create> {

    private List<String> columns = new ArrayList<>();

    private List<String> types = new ArrayList<>();

    public Create(ITable table) {
        super(table);
    }

    public Create setColumn(String column, String type) {
        this.columns.add(column);

        this.types.add(type);

        return this;
    }

    public Create column(String column, String type) {
        return this.setColumn(column, type);
    }

    public Create setColumns(Map<String, String> columns) {
        for (Map.Entry<String, String> entry: columns.entrySet()) this.setColumn(entry.getKey(), entry.getValue());

        return this;
    }

    public Create columns(Map<String, String> columns) {
        return this.setColumns(columns);
    }

    @Override
    public String toQuery() {
        StringBuilder query = new StringBuilder("CREATE TABLE IF NOT EXISTS " + this.table + " ( ");

        for (int i = 0; i < this.columns.size(); i++) query.append(i != this.columns.size() - 1 ? this.columns.get(i) + " " + this.types.get(i) + ", " : this.columns.get(i) + " " + this.types.get(i) + " ");

        query.append(")");

        return query.toString();
    }
}
