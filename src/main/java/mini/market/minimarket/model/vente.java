package mini.market.minimarket.model;



//import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class vente implements Serializable {

    @Id
    private Long venteid;
    private Long annee;
    private String mois;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "userids", referencedColumnName = "userid")
    private user user;

    @ManyToOne
    @JoinColumn(name = "productids", referencedColumnName = "productid")
    private minimarket product;

    public vente() {}

    public Long getVenteid() { return venteid; }

    public void setVenteid(Long venteid) { this.venteid = venteid; }

    public Long getAnnee() { return annee; }

    public void setAnnee(Long annee) { this.annee = annee; }

    public String getMois() { return mois; }

    public void setMois(String mois) { this.mois = mois; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public user getUser() { return user; }

    public void setUser(user userid) { this.user = userid; }

    public minimarket getProduct() { return product; }

    public void setProduct(minimarket productid) { this.product = productid; }

}
