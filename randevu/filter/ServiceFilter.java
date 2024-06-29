package learn.randevu.filter;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import learn.randevu.entity.Business;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceFilter {
    private Integer id;
    private String name_;
    private Integer salary_;
    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business_id;
    public ServiceFilter(Integer id, String name_, Integer salary_, Business business_id) {
        this.id = id;
        this.name_ = name_;
        this.salary_ = salary_;
        this.business_id = business_id;
    }public ServiceFilter(){

    }


}
