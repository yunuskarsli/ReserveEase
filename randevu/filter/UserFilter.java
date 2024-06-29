package learn.randevu.filter;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
@Getter
@Setter
public class UserFilter {
    private Integer id;

    public UserFilter(Integer id, String name_, String surname, String email, Integer password_, BigInteger phone) {
        this.id = id;
        this.name_ = name_;
        this.surname = surname;
        this.email = email;
        this.password_ = password_;
        this.phone = phone;
    }

    private String name_;
    private String surname;
    private String email;
    private Integer password_;
    private BigInteger phone;

    public UserFilter() {

    }
}
