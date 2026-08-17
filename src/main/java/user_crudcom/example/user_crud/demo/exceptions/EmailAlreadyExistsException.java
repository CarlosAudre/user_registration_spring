package user_crudcom.example.user_crud.demo.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(){
        super("Email já cadastrado");
    }

    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
