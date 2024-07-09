import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = PasswordValidator.class)/* if we use password annotation anywhere
validation is done by PasswordValidator class*/
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    /* Any constraint annotation must have below 3 methods message, groups and Payload */
    String message() default "Invalid Password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
