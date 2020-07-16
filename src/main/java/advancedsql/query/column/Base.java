package advancedsql.query.column;

public class Base extends Column {

    protected java.lang.Integer length;

    protected java.lang.String content;

    public Base(java.lang.String name, java.lang.String content) {
        super(name, true);

        this.name = name;

        this.content = content;
    }

    @Override
    public java.lang.String toString() {
        return name + "  " + content;
    }
}
