package learn.randevu.filter;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import learn.randevu.entity.Personel;
import learn.randevu.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
public class FeedbackFilter {
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;
    private LocalDate date_;
    private Time time_;
    private Integer scor;
    private String comment_;
    @ManyToOne
    @JoinColumn(name = "personel_id")
    private Personel personel_id;

    public FeedbackFilter(Integer id, User user_id, LocalDate date_, Time time_, Integer scor, String comment_, Personel personel_id) {
        this.id = id;
        this.user_id = user_id;
        this.date_ = date_;
        this.time_ = time_;
        this.scor = scor;
        this.comment_ = comment_;
        this.personel_id = personel_id;
    }

    public FeedbackFilter() {

    }

}
