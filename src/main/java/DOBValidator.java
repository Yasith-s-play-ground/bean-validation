import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class DOBValidator implements ConstraintValidator<DOB, LocalDate> {
    @Override
    public boolean isValid(LocalDate birthday, ConstraintValidatorContext context) {
        //adding DOBValidator Object to a variable in context
        var elContext = context.unwrap(HibernateConstraintValidatorContext.class); // getting the context to a variable
        elContext.addExpressionVariable("abc", this); // adding this object as a variable to the el context

        //Validation logic
        LocalDate today = LocalDate.now();
        int years = Period.between(birthday, today).getYears();
        return years >= 18 && years <= 60;
    }

    public boolean isChild(LocalDate birthday) {
        return Period.between(birthday, LocalDate.now()).getYears() < 18;
    }
}
