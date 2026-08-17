package user_crudcom.example.user_crud.demo.auth;

import java.time.LocalDate;

public record RegisterDTO(
        String name,
        String email,
        String cpf,
        String password,
        String phone,
        LocalDate birthDate
) {
}
