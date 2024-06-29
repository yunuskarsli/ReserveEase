package learn.randevu.filter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookFilter {


    public BookFilter(Integer id, LocalDateTime dateTime) {
        this.id = id;
        this.dateTime = dateTime;

    }

    private Integer id;
    private LocalDateTime dateTime;


    public BookFilter() {

    }
}

