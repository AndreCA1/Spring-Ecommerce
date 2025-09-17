package me.DIO.Ecommerce.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.DIO.Ecommerce.model.User;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class UserDTO {
    @Schema(description = "Database generated ID User")
    @EqualsAndHashCode.Include
    private long id;
    @NotBlank(message = "Required field")
    private String username;
    @NotBlank(message = "Required field")
    private String email;
    private Set<RoleDTO> roles;

    public UserDTO(User entity) {
        id = entity.getId();
        username = entity.getUsername();
        email = entity.getEmail();
        roles = new HashSet<>();
        if (entity.getRoles() != null) {
            entity.getRoles().forEach(role -> roles.add(new RoleDTO(role)));
        }
    }
}
