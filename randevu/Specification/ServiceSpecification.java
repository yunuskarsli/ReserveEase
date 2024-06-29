package learn.randevu.Specification;

import learn.randevu.entity.Services;
import learn.randevu.filter.ServiceFilter;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

public class ServiceSpecification {
    public static Specification<Services> filter(ServiceFilter filter) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (filter.getId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), filter.getId()));
            }
            if (filter.getName_() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("name"), filter.getName_()));
            }
            if (filter.getSalary_() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("salary"), filter.getSalary_()));
            }
            if (filter.getBusiness_id() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("business_id"), filter.getBusiness_id()));
            }
            return predicate;

        };
    }
}
