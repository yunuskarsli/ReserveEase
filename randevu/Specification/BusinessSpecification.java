package learn.randevu.Specification;

import learn.randevu.entity.Business;
import learn.randevu.filter.BusinessFilter;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

public class BusinessSpecification {
    public static Specification<Business> filter(BusinessFilter filter) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (filter.getId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), filter.getId()));
            }
            if (filter.getName_() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("name"), filter.getName_()));
            }
            if (filter.getType() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("type"), filter.getType()));
            }
            if (filter.getAddress() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("address"), filter.getAddress()));
            }
            if (filter.getOwner_id() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("owner_id"), filter.getOwner_id()));
            }
            return predicate;
        };
    }
}
