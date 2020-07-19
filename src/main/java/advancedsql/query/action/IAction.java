package advancedsql.query.action;

import advancedsql.query.column.Base;
import advancedsql.query.column.IColumn;

import java.util.List;

public interface IAction<T> {
    /**
     * @return Action columns.
     */
    List<T> getColumns();

    /**
     * @return Action prefix.
     */
    java.lang.String getPrefix();

    java.lang.String toString();
}
