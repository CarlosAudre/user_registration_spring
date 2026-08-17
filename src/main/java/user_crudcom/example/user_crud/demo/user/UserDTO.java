package user_crudcom.example.user_crud.demo.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserDTO(
        String name,
        String email,
        String cpf,
        String phone,
        LocalDate birthDate,
        LocalDateTime createDate
) {
}
