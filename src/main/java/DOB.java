import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = DOBValidator.class)/* if we use DOB annotation anywhere
validation is done by DOBValidator class*/
@Retention(RetentionPolicy.RUNTIME)
public @interface DOB {
    /* Any constraint annotation must have below 3 methods message, groups and Payload */
    String message() default "Age must be between 18 and 60";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
