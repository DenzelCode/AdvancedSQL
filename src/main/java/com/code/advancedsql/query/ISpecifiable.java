package com.code.advancedsql.query;

public interface ISpecifiable {

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
     * Assign the limit of rows to be affected.
     * @param limit Limit amount.
     * @return Query object.
     */
    IQuery limit(int limit);

    /**
     * @return Limit of rows to be affected.
     */
    int getLimit();
}
