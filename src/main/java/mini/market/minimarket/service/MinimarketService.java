package mini.market.minimarket.service;

import mini.market.minimarket.exception.ProductNotFoundException;
import mini.market.minimarket.model.minimarket;
import mini.market.minimarket.repo.MinimarketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MinimarketService {
    private final MinimarketRepo minimarketRepo;

    @Autowired
    public MinimarketService(MinimarketRepo minimarketRepo) {
        this.minimarketRepo = minimarketRepo;
    }

    public minimarket addProduct(minimarket product) {
        product.setProductCode(UUID.randomUUID().toString());
        return minimarketRepo.save(product);
    }

    public List<minimarket> findAllProducts() {
        return minimarketRepo.findAll();
    }

    public minimarket findProductByProductid(Long productid) {
        return minimarketRepo.findProductByProductid(productid).orElseThrow(() -> new ProductNotFoundException("Product" + productid + "not found"));
    }

    public minimarket updateProduct(minimarket product) {
        return minimarketRepo.save(product);
    }

    public void deleteProduct(Long productid) {
        minimarketRepo.deleteProductByProductid(productid);
    }
}
