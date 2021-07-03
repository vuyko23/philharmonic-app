package philharmonic.app.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import philharmonic.app.dao.AbstractDao;
import philharmonic.app.dao.StageDao;
import philharmonic.app.model.Stage;

@Repository
public class StageDaoImpl extends AbstractDao<Stage> implements StageDao {
    public StageDaoImpl(SessionFactory factory) {
        super(factory, Stage.class);
    }
}
