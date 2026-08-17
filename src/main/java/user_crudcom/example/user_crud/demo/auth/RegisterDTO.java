package user_crudcom.example.user_crud.demo.auth;

public record RegisterDTO(
        String name,
        String email,
        String password,
        String phone
) {
}
