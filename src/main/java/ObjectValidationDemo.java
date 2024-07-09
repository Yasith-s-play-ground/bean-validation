import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;

import java.util.Set;

public class ObjectValidationDemo {
    public static void main(String[] args) {
        Customer customer = new Customer(-1, "Kasun23", null);

        //Create Validation Factory
        //try with resources to close factory after using
        try (ValidatorFactory vf = Validation.buildDefaultValidatorFactory()) {

            //Normally an app needs only one validator

            //To validate objects
            Validator validator = vf.getValidator();

            //To validate methods
//            ExecutableValidator executableValidator = validator.forExecutables();

            System.out.println(validator);
//            System.out.println(executableValidator);


            Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);

            if (constraintViolations.isEmpty()) {
                System.out.println("Validation passed");
            } else {
                System.out.println("Validation failed");
                constraintViolations.forEach(System.out::println);
            }
        }
    }
}
