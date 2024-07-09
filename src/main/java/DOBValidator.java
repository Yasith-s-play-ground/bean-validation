import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class DOBValidator implements ConstraintValidator<DOB, LocalDate> {
    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        if (LocalDate.now().getYear() - localDate.getYear() > 60 || LocalDate.now().getYear() - localDate.getYear() < 18)
            return false;
        return true;
    }
}
