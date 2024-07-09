import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotBlank
    @Pattern(regexp = "^[A-Za-z ]+$", message = "${validatedValue} is not a valid name")
    private String fullName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Password
    private String password;
    @NotNull
    @DOB
    private LocalDate birthday;
}
