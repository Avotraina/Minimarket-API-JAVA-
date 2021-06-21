package mini.market.minimarket.repo;

import mini.market.minimarket.model.minimarket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MinimarketRepo extends JpaRepository<minimarket, Long> {

    void deleteProductByProductid(Long productid);

    Optional<minimarket> findProductByProductid(Long productid);
}
