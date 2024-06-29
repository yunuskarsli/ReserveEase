package learn.randevu.dto;

import learn.randevu.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReserveDto {
    private Integer id;
    private User user_id;
    private LocalDateTime appointmntDateTime;

}
