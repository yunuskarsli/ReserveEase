package learn.randevu.filter;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import learn.randevu.entity.Services;
import learn.randevu.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
@Getter
@Setter
public class PaymentHistoryFilter {
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
    public PaymentHistoryFilter(Integer id, User user_id, Services services_id, Integer amount, LocalDate date_, Time time_) {
        this.id = id;
        this.user_id = user_id;
        this.services_id = services_id;
        this.amount = amount;
        this.date_ = date_;
        this.time_ = time_;
    }
    public PaymentHistoryFilter(){

    }


}
