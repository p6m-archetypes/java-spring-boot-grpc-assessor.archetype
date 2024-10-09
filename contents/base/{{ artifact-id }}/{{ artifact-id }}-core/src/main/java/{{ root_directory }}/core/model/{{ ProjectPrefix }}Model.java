package {{ root_package }}.core.model;

public class {{ ProjectPrefix }}Model {
    long attempts;

    public {{ ProjectPrefix }}Model(long attempts) {
        this.attempts = attempts;
    }

    public long getAttempts() {
        return attempts;
    }

    public {{ ProjectPrefix }}Model setAttempts(long attempts) {
        this.attempts = attempts;
        return this;
    }
}
