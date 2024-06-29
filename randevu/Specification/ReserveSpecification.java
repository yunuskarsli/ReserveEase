package learn.randevu.Specification;

import learn.randevu.entity.Reserve;
import learn.randevu.filter.ReserveFilter;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;


public class ReserveSpecification {
    public static Specification<Reserve> filter(ReserveFilter filter) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (filter.getId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), filter.getId()));
            }
            if (filter.getBook_id() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("book_id"), filter.getBook_id()));

            }
            if (filter.getUser_id() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("user_id"), filter.getUser_id()));
            }
            if (filter.getPersonel_id() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("personel_id"), filter.getPersonel_id()));
            }
            return predicate;
        };
    }
}
