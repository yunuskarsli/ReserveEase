package learn.randevu.dto;

import learn.randevu.entity.Business;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDto {
    private Integer id;
    private String name_;
    private Business business_id;



    public ServiceDto() {

    }
}
