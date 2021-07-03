package philharmonic.app.dao;

import java.util.Optional;
import philharmonic.app.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
