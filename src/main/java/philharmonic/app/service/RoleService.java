package philharmonic.app.service;

import philharmonic.app.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
