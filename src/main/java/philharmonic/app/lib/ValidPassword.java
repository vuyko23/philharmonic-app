package philharmonic.app.lib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "Invalid password please try again. "
            + "Password must be at least 8 characters and contains one digit, "
            + "one lower alpha character and one upper, "
            + "one symbol and does not contain any space, tab, etc";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
