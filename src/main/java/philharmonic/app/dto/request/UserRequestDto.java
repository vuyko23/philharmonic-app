package philharmonic.app.dto.request;

import javax.validation.constraints.Size;
import philharmonic.app.lib.FieldsValueMatch;
import philharmonic.app.lib.ValidEmail;
import philharmonic.app.lib.ValidPassword;

@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!"
)
public class UserRequestDto {
    @ValidEmail
    private String email;
    @Size(min = 8, max = 40)
    @ValidPassword
    private String password;
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
