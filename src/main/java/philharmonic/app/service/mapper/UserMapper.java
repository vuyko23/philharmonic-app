package philharmonic.app.service.mapper;

import org.springframework.stereotype.Component;
import philharmonic.app.dto.response.UserResponseDto;
import philharmonic.app.model.User;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        return responseDto;
    }
}
