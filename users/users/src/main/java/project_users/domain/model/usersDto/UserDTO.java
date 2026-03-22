package project_users.domain.model.usersDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public record UserDTO(
        @NotBlank(message = "El nombre es obligatorio")
        String name,

        @Email(message = "El formato de email es inválido")
        @NotBlank(message = "El email es obligatorio")
        String email
) {
        public static UserDTO fromEntity(project_users.domain.model.users.User user) {
                return new UserDTO(user.getName(), user.getEmail());
        }
}