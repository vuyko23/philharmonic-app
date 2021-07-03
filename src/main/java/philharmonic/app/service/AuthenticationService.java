package philharmonic.app.service;

import philharmonic.app.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
