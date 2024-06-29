package learn.randevu.dto;

import learn.randevu.entity.Services;
import learn.randevu.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentHistoryDto {
    private Integer id;
    private User user_id;
    private Services services_id;
    private Integer amount;



}
