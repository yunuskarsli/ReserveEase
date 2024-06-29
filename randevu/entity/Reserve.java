package learn.randevu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@Entity

@Table
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private LocalDateTime   appointmentDateTime;
    @ManyToOne
    @JoinColumn(name="personel_id")
    private Personel personel_id;
    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user_id;

}