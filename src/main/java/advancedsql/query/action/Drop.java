package advancedsql.query.action;

import java.util.ArrayList;
import java.util.List;

public class Drop implements IAction<String> {

    private List<String> columns = new ArrayList<>();

    @Override
    public List<String> getColumns() {
        return this.columns;
    }

    public Drop column(String name) {
        this.columns.add(name);

        return this;
    }

    @Override
    public String getPrefix() {
        return "DROP ";
    }
}
