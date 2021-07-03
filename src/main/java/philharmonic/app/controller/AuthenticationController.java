package philharmonic.app.controller;

import javax.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import philharmonic.app.dto.request.UserRequestDto;
import philharmonic.app.dto.response.UserResponseDto;
import philharmonic.app.model.User;
import philharmonic.app.service.AuthenticationService;
import philharmonic.app.service.mapper.UserMapper;

@Log4j2
@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserMapper userMapper;

    public AuthenticationController(AuthenticationService authService, UserMapper userMapper) {
        this.authService = authService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authService.register(requestDto.getEmail(), requestDto.getPassword());
        log.info("User with email " + requestDto.getEmail() + " register");
        return userMapper.mapToDto(user);
    }
}
