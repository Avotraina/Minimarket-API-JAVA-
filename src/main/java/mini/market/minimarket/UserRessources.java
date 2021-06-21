package mini.market.minimarket;

import com.fasterxml.jackson.core.JsonEncoding;
import mini.market.minimarket.model.user;
import mini.market.minimarket.service.UserService;
import org.aspectj.weaver.ast.Var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRessources {
    private final UserService userService;

    public UserRessources(UserService userService) { this.userService = userService; }

    @GetMapping("/allUser")
    public ResponseEntity<List<user>> getAllUser() {
        List<user> users = userService.findAllUsers();
        return new ResponseEntity<List<user>>(users, HttpStatus.OK);
    }

    @GetMapping("/findUser/{userid}")
    public ResponseEntity<user> getUserByUserid(@PathVariable("userid") Long userid) {
        user users = userService.findUserByUserid(userid);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<user> addUser(@RequestBody user user) {
        user newUser = userService.addUser(user);

        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @GetMapping("/findName/{username}")
    public ResponseEntity<List<user>> getUserByName(@PathVariable("username") String username) {
        List<user> users = userService.findUserByName(username);
        return new ResponseEntity<List<user>>(users, HttpStatus.OK);
    }
}
