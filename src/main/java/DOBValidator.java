import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class DOBValidator implements ConstraintValidator<DOB, LocalDate> {
    @Override
    public boolean isValid(LocalDate birthday, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate today = LocalDate.now();
        int years = Period.between(today, birthday).getYears();
        return years >= 18 && years <= 60;
    }
}
