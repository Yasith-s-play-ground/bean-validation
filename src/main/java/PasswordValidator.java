import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;

public class PasswordValidator implements ConstraintValidator</*annotation*/Password, /*Data Type*/String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (!password.matches(".*\\d.*")) return false;
        if (!password.matches(".*[A-Z].*")) return false;
        if (!password.matches(".*[a-z].*")) return false;
        char[] charArray = password.toCharArray();
        HashSet<Object> characters = new HashSet<>();
        for (char c : charArray) {
            characters.add(c);
        }
        return characters.size() >= password.length();
    }
}
