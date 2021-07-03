package philharmonic.app.service;

import philharmonic.app.model.User;

public interface UserService {
    User add(User user);

    User get(Long id);

    User findByEmail(String email);
}
