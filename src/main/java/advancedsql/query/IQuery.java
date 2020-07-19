package advancedsql.query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IQuery {

    /**
     * Specify what values will be affected for example:
     * query.where("first_name = ? AND last_name = ?", "Denzel", "Code");
     * @param where Where statement.
     * @param execute Values of the statement.
     * @return Query object.
     */
    IQuery where(String where, Object... execute);

    /**
     * Specify what values will be affected for example:
     * query.where("first_name = 'Denzel' AND last_name = 'Code'");
     * @param where Where statement.
     * @return Query object.
     */
    IQuery where(String where);

    /**
     * Execute query and return a boolean.
     * Recommended for: CREATE, ALTER, DROP, TRUNCATE.
     * @return boolean.
     * @throws SQLException Exception when something goes wrong.
     */
    Boolean executeStatement() throws SQLException;

    /**
     * Execute query and return an integer.
     * Recommended for: INSERT, UPDATE, DELETE.
     * @return integer.
     * @throws SQLException Exception when something goes wrong.
     */
    int executeUpdate() throws SQLException;

    /**
     * Execute query and return a ResultSet.
     * Recommended for: SELECT, SHOW.
     * @return ResultSet.
     * @throws SQLException Exception when something goes wrong.
     */
    ResultSet executeQuery() throws SQLException;

    /**
     * Execute query and return a PreparedStatement.
     * Recommended for: General.
     * @return PreparedStatement.
     * @throws SQLException Exception when something goes wrong.
     */
    PreparedStatement executePrepare() throws SQLException;

    /**
     * Get PreparedStatement of the query.
     * This just works if you already executed the query.
     * @return PreparedStatement.
     */
    PreparedStatement getPrepare();

    /**
     * @return String representation of the Query.
     */
    String toQuery();

    /**
     * @return String representation of the Query.
     */
    String toString();
}
