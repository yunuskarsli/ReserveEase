package learn.randevu.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Data
@Table(name = "paymenthistory")
public class PaymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user_id;
    @ManyToOne
    @JoinColumn(name="service_id")
    private Services services_id;
    private Integer amount;
    private LocalDate date_;
    private Time time_;
}
