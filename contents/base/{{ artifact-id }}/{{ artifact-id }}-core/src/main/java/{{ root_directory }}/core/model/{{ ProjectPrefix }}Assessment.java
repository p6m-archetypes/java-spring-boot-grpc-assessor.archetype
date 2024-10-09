package {{ root_package }}.core.model;

import {{ root_package }}.grpc.{{ ProjectPrefix }}Level;

public class {{ ProjectPrefix }}Assessment {
    private {{ ProjectPrefix }}Level level = {{ ProjectPrefix }}Level.{{ PROJECT_PREFIX }}_LOW;

    public {{ ProjectPrefix }}Assessment({{ ProjectPrefix }}Level level) {
        this.level = level;
    }

    public {{ ProjectPrefix }}Level getLevel() {
        return level;
    }

    public {{ ProjectPrefix }}Assessment setLevel({{ ProjectPrefix }}Level level) {
        this.level = level;
        return this;
    }
}
