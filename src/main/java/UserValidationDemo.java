import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;

import java.time.LocalDate;
import java.util.Set;

public class UserValidationDemo {
    public static void main(String[] args) {
//        User user = new User("Kasun Sampath", "kasun@ijse.lk", "Kasun1", LocalDate.now());
//        User user = new User("Kasun Sampath", "kasun@ijse.lk", "Kasun1", LocalDate.of(1920,5,2));
        User user = new User("Kasun Sampath", "kasun@ijse.lk", "Kasun1", LocalDate.of(2000,5,2));
        try (ValidatorFactory vf = Validation.
                byProvider(HibernateValidator.class).configure()
                .constraintExpressionLanguageFeatureLevel(ExpressionLanguageFeatureLevel.BEAN_METHODS)
                .buildValidatorFactory()) {
            Validator validator = vf.getValidator();
            Set<ConstraintViolation<User>> violationSet = validator.validate(user);
            if (violationSet.isEmpty()) {
                System.out.println("Validation Passed");
            } else {
                System.out.println("Validation Failed");
                violationSet.forEach(System.out::println);
            }
        }
    }
}
