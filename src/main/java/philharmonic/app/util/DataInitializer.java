package philharmonic.app.util;

import java.util.Set;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import philharmonic.app.model.Role;
import philharmonic.app.model.User;
import philharmonic.app.service.AuthenticationService;
import philharmonic.app.service.RoleService;
import philharmonic.app.service.UserService;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;
    private final AuthenticationService authenticationService;

    public DataInitializer(RoleService roleService, UserService userService,
                           AuthenticationService authenticationService) {
        this.roleService = roleService;
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @PostConstruct
    public void injectData() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(adminRole);
        roleService.add(userRole);
        User admin = new User();
        admin.setEmail("admin@email.com");
        admin.setPassword("1234");
        admin.setRoles(Set.of(roleService.getRoleByName("ADMIN")));
        userService.add(admin);
        authenticationService.register("user@email.com", "1234");
    }
}
