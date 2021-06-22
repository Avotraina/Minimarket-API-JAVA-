package mini.market.minimarket.service;

import mini.market.minimarket.exception.UserNotFoundException;
import mini.market.minimarket.model.user;
import mini.market.minimarket.model.vente;
import mini.market.minimarket.repo.VenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {
    private final VenteRepo venteRepo;

    @Autowired
    public VenteService(VenteRepo venteRepo) { this.venteRepo = venteRepo; }

    public vente addVente(vente vente) { return venteRepo.save(vente); }

    public List<vente> findAllVentes() { return venteRepo.findAll(); }

    public List<vente> findVenteByAnnee(Long annee) {
        return venteRepo.findVenteByAnnee(annee).orElseThrow(() -> new UserNotFoundException("Pas de vente sur cette année"));
    }

//    public List<vente> findProductSum(Long productid) {
//        return venteRepo;
//    }
}
