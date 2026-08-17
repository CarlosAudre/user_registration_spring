package user_crudcom.example.user_crud.demo.user;

public enum UserRole {
    CLIENT("client"),
    ADMIN("admin");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
