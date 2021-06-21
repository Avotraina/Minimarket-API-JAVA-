package mini.market.minimarket.repo;

import mini.market.minimarket.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<user, String> {
    Optional<user> findUserByUserid(Long userid);

    @Query("SELECT u FROM user u WHERE u.username = ?1")
    Optional<List<user>> findUserByName(String username);

}
