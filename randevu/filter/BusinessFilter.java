package learn.randevu.filter;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import learn.randevu.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessFilter {
    private Integer id;
    private String name_;
    private String type;
    private String address;
    @ManyToOne
    @JoinColumn(name = "users")
    private User owner_id;
    public BusinessFilter(Integer id, String name_, String type, String address, User owner_id) {
        this.id = id;
        this.name_ = name_;
        this.type = type;
        this.address = address;
        this.owner_id = owner_id;
    }



    public BusinessFilter() {

    }
}
