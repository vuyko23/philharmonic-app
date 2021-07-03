package philharmonic.app.dao.impl;

import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import philharmonic.app.dao.AbstractDao;
import philharmonic.app.dao.RoleDao;
import philharmonic.app.exception.DataProcessingException;
import philharmonic.app.model.Role;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Role r WHERE r.roleName = :role", Role.class)
                    .setParameter("role", Role.RoleName.valueOf(roleName))
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find Role " + roleName, e);
        }
    }
}
