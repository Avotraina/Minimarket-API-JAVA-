package mini.market.minimarket.model;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class minimarket implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(nullable = false, updatable = false, unique = true)
    private Long productid;
    private String productname;
    private Long realprice;
    private Long price;
    private Long number;
    @Column(nullable = false, updatable = false)
    private String productCode;

    @OneToMany(mappedBy = "product")
    private Set<vente> ventes = new HashSet<>();

    public minimarket() {}

    public minimarket(String productname, Long realprice, Long price, Long number) {
        this.productname = productname;
        this.realprice = realprice;
        this.price = price;
        this.number = number;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String name) {
        this.productname = name;
    }

    public Long getRealprice() { return realprice; }

    public void setRealprice(Long realprice) { this.realprice = realprice; }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return "minimarket{" +
                "productid=" + productid +
                ", productname='" + productname + '\'' +
                ", realprice'" + realprice + '\'' +
                ", price='" + price + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

