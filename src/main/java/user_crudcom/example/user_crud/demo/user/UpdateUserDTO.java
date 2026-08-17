package user_crudcom.example.user_crud.demo.user;

import java.time.LocalDate;

public record UpdateUserDTO(
        String name,
        String email,
        String phone,
        LocalDate birthDate
) {
}
