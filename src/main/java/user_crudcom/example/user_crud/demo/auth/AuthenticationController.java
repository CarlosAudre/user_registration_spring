package user_crudcom.example.user_crud.demo.auth;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user_crudcom.example.user_crud.demo.exceptions.EmailAlreadyExistsException;
import user_crudcom.example.user_crud.demo.user.User;
import user_crudcom.example.user_crud.demo.user.UserRepository;
import user_crudcom.example.user_crud.demo.user.UserRole;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenService tokenService;

    @Autowired
    RegisterService registerService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO dto){
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO dto){
        if(userRepository.findByEmail(dto.email()) != null){
            throw new EmailAlreadyExistsException("Email já cadastrado");
        }

        if(!registerService.passwordValidation(dto.password())){
            return ResponseEntity.badRequest().body("Senha inválida. A senha precisa ter no mínimo 8 caracteres, 1 letra e um número");
        }

        String encryptedPassword = passwordEncoder.encode(dto.password());

        User newUser = new User(dto.name(), dto.cpf(), dto.email(), encryptedPassword, dto.birthDate(),
                dto.phone(), UserRole.CLIENT);
        this.userRepository.save(newUser);

        return  ResponseEntity.ok().build();

    }


}
