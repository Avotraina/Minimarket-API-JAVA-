package mini.market.minimarket.repo;

import mini.market.minimarket.model.vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VenteRepo extends JpaRepository<vente, String> {

    @Query("SELECT u FROM vente u WHERE u.annee = ?1")
    Optional<List<vente>> findVenteByAnnee(Long annee);

//    @Query(value = "SELECT SUM(price) FROM VENTE_VIEW WHERE (productids= ?1)")
//    Optional<vente>
}
