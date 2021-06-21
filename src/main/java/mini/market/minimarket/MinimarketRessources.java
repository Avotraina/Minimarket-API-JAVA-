package mini.market.minimarket;

import mini.market.minimarket.model.minimarket;
import mini.market.minimarket.service.MinimarketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/minimarket")
public class MinimarketRessources {
    private final MinimarketService productService;

    public MinimarketRessources(MinimarketService productService) {
        this.productService = productService;
    }

    @GetMapping("/allProduct")
    public ResponseEntity<List<minimarket>> getAllProduct() {
        List<minimarket> products = productService.findAllProducts();
        return new ResponseEntity<List<minimarket>>(products, HttpStatus.OK);
    }

    @GetMapping("/findProduct/{productid}")
    public ResponseEntity<minimarket> getProductById(@PathVariable("productid") Long productid) {
        minimarket products = productService.findProductByProductid(productid);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<minimarket> addProduct(@RequestBody minimarket product) {
        minimarket newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<minimarket> updateProduct(@RequestBody minimarket product) {
        minimarket updateProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @PutMapping("/deleteProduct/{productid}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productid") Long productid) {
        productService.deleteProduct(productid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}