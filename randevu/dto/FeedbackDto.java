package learn.randevu.dto;

import learn.randevu.entity.Personel;
import learn.randevu.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackDto {
    private Integer id;

    private User user_id;
    private String comment_;
    private Personel personel_id;

}
