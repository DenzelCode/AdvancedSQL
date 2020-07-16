package advancedsql.query.column;

public interface IColumn {

    java.lang.String setName();

    IColumn nullable();

    IColumn nativeDefault();

    java.lang.String toString();
}
