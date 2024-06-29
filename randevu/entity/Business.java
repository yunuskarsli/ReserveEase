package learn.randevu.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "business")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name_;
    private String type;
    private BigInteger phone;
    private String address;
    @ManyToOne
    @JoinColumn(name = "users")
    private User owner_id;
    private LocalDateTime business_appointment;
    private String email;
}

