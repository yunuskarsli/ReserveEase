package learn.randevu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "service_")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name_;
    private Integer salary_;
    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;
}
