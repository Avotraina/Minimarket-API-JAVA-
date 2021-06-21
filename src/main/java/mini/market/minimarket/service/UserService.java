package mini.market.minimarket.service;

import mini.market.minimarket.exception.UserNotFoundException;
import mini.market.minimarket.model.user;
import mini.market.minimarket.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) { this.userRepo = userRepo; }

    public user addUser(user user) {
        return userRepo.save(user);
    }

    public List<user> findAllUsers() { return userRepo.findAll(); }

    public user findUserByUserid(Long userid) {
        return userRepo.findUserByUserid(userid).orElseThrow(() -> new UserNotFoundException("User" + userid + "not found"));
    }

    public List<user> findUserByName(String username) {
        return userRepo.findUserByName(username).orElseThrow(() -> new UserNotFoundException("User" + username + "not found"));
    }

}
