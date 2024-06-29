package learn.randevu.filter;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import learn.randevu.entity.Personel;
import learn.randevu.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.awt.print.Book;

@Getter
@Setter
public class ReserveFilter {
    public ReserveFilter(){

    }
    public ReserveFilter(Integer id,Book book_id, Personel personel_id, User user_id) {
        this.id = id;
        this.book_id=book_id;

        this.personel_id = personel_id;
        this.user_id = user_id;
    }




    private Integer id;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book_id;
    @ManyToOne
    @JoinColumn(name="personel_id")
    private Personel personel_id;
    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user_id;
}
