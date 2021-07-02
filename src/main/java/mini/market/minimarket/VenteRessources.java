package mini.market.minimarket;

import mini.market.minimarket.model.minimarket;
import mini.market.minimarket.model.vente;
import mini.market.minimarket.service.VenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RequestMapping("/vente")
public class VenteRessources {
    private final VenteService venteService;
    public VenteRessources(VenteService venteService) { this.venteService = venteService; }

    @PostMapping("/addVente")
    public ResponseEntity<vente> addVente(@RequestBody vente vente) {
        vente newvente = venteService.addVente(vente);
        return new ResponseEntity<>(newvente, HttpStatus.OK);
    }

    @GetMapping("/allVente")
    public ResponseEntity<List<vente>> findAllVentes() {
        List<vente> ventes = venteService.findAllVentes();
        return new ResponseEntity<List<vente>>(ventes, HttpStatus.OK);
    }
    
    @GetMapping("/VenteByAnnee")
    public ResponseEntity<List<vente>> findVenteByAnnee(@RequestHeader Long annee) {
        List<vente> ventes = venteService.findVenteByAnnee(annee);
        return new ResponseEntity<List<vente>>(ventes, HttpStatus.OK);
    }

}
