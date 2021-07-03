package philharmonic.app.service.impl;

import org.springframework.stereotype.Service;
import philharmonic.app.dao.RoleDao;
import philharmonic.app.exception.DataProcessingException;
import philharmonic.app.model.Role;
import philharmonic.app.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName).orElseThrow(
                () -> new DataProcessingException("Can't find Role " + roleName));
    }
}
