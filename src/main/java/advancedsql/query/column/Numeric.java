package advancedsql.query.column;

public abstract class Numeric extends Column {

    protected java.lang.Boolean unsigned;

    protected java.lang.Integer length;

    protected java.lang.Boolean primary = false;

    protected java.lang.Boolean increment = false;

    protected java.lang.Integer defaultValue;

    public Numeric(java.lang.String name, java.lang.Boolean nullable, java.lang.Boolean unsigned, java.lang.Integer length) {
        super(name, nullable);

        this.unsigned = unsigned;

        this.length = length;
    }

    public IColumn unsigned() {
        this.unsigned = true;

        return this;
    }

    public Numeric primary() {
        this.primary = true;

        return this;
    }

    public Numeric increment() {
        this.increment = true;

        return this;
    }

    public Numeric defaultValue(java.lang.Integer value) {
        this.defaultValue = value;

        return this;
    }
}
