package tech.c3n7.muziki.auth.dao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    @NotBlank(message="This field is required.")
    private String firstName;

    @NotBlank(message="This field is required.")
    private String lastName;

    @NotBlank(message="This field is required.")
    @Email(message="Please enter a valid email address.")
    private String email;

    @NotBlank(message="This field is required.")
    private String password;
}
