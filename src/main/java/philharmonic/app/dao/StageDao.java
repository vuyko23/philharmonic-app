package philharmonic.app.dao;

import java.util.List;
import java.util.Optional;
import philharmonic.app.model.Stage;

public interface StageDao {
    Stage add(Stage stage);

    Optional<Stage> get(Long id);

    List<Stage> getAll();
}
