package AfterTheRefactor.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final List<String> permissions;

    public User(String name, List<String> permissions) {
        this.name = name;
        this.permissions = permissions == null ? new ArrayList<>() : permissions;
    }

    public String getName() { return name; }

    public boolean hasPermission(String perm) {
        return permissions.contains(perm);
    }
}
