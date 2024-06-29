package learn.randevu.Specification;

import learn.randevu.entity.Personel;
import learn.randevu.filter.PersonelFilter;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;


public class PersonelSpecification {
    public static Specification<Personel> filter(PersonelFilter filter) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (filter.getId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), filter.getId()));
            }
            if (filter.getUser_id() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("user_id"), filter.getUser_id()));
            }
            if (filter.getServices_id() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("service_id"), filter.getServices_id()));
            }
            if (filter.getScor() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("scor"), filter.getScor()));
            }
            if (filter.getStart_date() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("start_date"), filter.getStart_date()));
            }
            return predicate;
        };
    }
}
