package advancedsql.query.action;

import advancedsql.query.column.Base;
import advancedsql.query.column.IColumn;

import java.util.List;

public interface IAction<T> {
    List<T> getColumns();

    java.lang.String getPrefix();

    java.lang.String toString();
}
