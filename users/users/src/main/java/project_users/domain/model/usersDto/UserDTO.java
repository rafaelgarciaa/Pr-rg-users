package project_users.domain.model.usersDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {

        @NotBlank(message = "El nombre es obligatorio")
        private String name;

        @Email(message = "El formato de email es inválido")
        @NotBlank(message = "El email es obligatorio")
        private String email;

        // Constructor vacío (necesario para frameworks como Jackson/Spring)
        public UserDTO() {
        }

        // Constructor con campos
        public UserDTO(String name, String email) {
                this.name = name;
                this.email = email;
        }

        // Getters y Setters
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public static UserDTO fromEntity(project_users.domain.model.users.User user) {
                return new UserDTO(user.getName(), user.getEmail());
        }
}