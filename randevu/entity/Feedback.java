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
@Table(name="Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user_id;
    private LocalDate date_;
    private Time time_;
    private Integer scor;
    private String comment_;
    @ManyToOne
    @JoinColumn(name="personel_id")
    private Personel personel_id;
}
