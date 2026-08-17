package user_crudcom.example.user_crud.demo.user;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AdmController {
    @Autowired
    UserService userService;

    @GetMapping
    ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}")
    ResponseEntity<UserDTO> updateUser(
            @PathVariable("id") Long id,
            @RequestBody @Valid UpdateUserDTO dto
    ){
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
       return ResponseEntity.ok().build();
    }

}
