package com.example.backend_RestAPI.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO {

    @NotBlank(message = "O nome não pode ser vazio!")
    private String name;

    @Email(message = "Email inválido!")
    @NotBlank(message = "Email não pode ser vazio")
    private String email;

    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d).+$",
            message = "A senha deve conter letras e números"
    )
    @NotBlank(message = "Senha não pode ser vazia!")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    private String password;
}
