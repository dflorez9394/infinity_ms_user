package com.infinity.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotBlank(message = "El documento es obligatorio")
    @Size(min = 9, max = 12)
    private String document;

    @NotBlank(message = "el nombre es obligatorio")
    @Size(max=20)
    private  String name;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 20, message = "El apellido no puede superar los 20 caracteres")
    @Pattern(
            regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü]+$",
            message = "El apellido solo puede contener letras"
    )
    private String lastname;

    @Email(
            regexp = "^[A-Za-z0-9._%+-]+@miempresa\\.com$",
            message = "El correo no es valido"
    )
    private String email;
}
