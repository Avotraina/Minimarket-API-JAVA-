package mini.market.minimarket.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.ValueGenerationType;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
//@IdClass(value = user.ID.class)
public class user implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(nullable = false, updatable = false)
    private Long userid;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<vente> ventes = new HashSet<>();


    public user() {}

    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getUserid() { return userid; }

    public void setUserid(Long userid) { this.userid = userid; }

    public String getUsername() { return username; }

    public void setUsername(String name) { this.username = name; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "user{" +
                "Userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public enum id {}
}
