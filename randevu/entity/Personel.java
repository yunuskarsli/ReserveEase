package learn.randevu.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter


@Entity
@Data
@Table(name ="Personel")
public class Personel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private LocalDate start_date;
    @OneToOne
    @JoinColumn(name ="user_id")
    private User user_id;
    private LocalDateTime personAppointment;
    @ManyToOne
    @JoinColumn(name="services_id")
    private Services services_id;
    private Integer scor;

}