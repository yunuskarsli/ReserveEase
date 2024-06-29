package learn.randevu.filter;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import learn.randevu.entity.Services;
import learn.randevu.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonelFilter {
    private Integer id;
    private LocalDate start_date;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user_id;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services services_id;
    private Integer scor;

    public PersonelFilter(Integer id, LocalDate start_date, User user_id, Services services_id, Integer scor) {
        this.id = id;
        this.start_date = start_date;
        this.user_id = user_id;
        this.services_id = services_id;
        this.scor = scor;
    }


    public PersonelFilter() {

    }
}
