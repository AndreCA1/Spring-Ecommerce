package me.DIO.Ecommerce.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInsertDTO extends UserDTO{

    @NotBlank(message = "Campo obrigatório")
    @Size(min = 2, max = 50)
    private String password;

}
