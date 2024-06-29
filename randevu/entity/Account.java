package learn.randevu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "business_id", referencedColumnName = "id")
    private Business business;

    private Integer expenses;
    private Integer revenues;
    private Integer balance;

}
