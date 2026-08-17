package user_crudcom.example.user_crud.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_crudcom.example.user_crud.demo.exceptions.UserNotFoundException;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getAllUsers(){
        return userRepository.findAll().stream().map((user ->
                new UserDTO(
                        user.getName(),
                        user.getEmail(),
                        user.getCpf(),
                        user.getPhone(),
                        user.getBirthDate(),
                        user.getCreatedAt()
                        ))).toList();
    }

    public UserDTO updateUser(Long id, UserDTO dto){
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPhone(dto.phone());
        user.setBirthDate(dto.birthDate());

        userRepository.save(user);
        return new UserDTO(
                user.getName(),
                user.getEmail(),
                user.getCpf(),
                user.getPhone(),
                user.getBirthDate(),
                user.getCreatedAt()
        );
    }

    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }
}
