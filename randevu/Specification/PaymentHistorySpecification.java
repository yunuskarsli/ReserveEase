package learn.randevu.Specification;

import learn.randevu.entity.PaymentHistory;
import learn.randevu.filter.PaymentHistoryFilter;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;


public class PaymentHistorySpecification {
    public static Specification<PaymentHistory> filter(PaymentHistoryFilter filter) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (filter.getId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), filter.getId()));
            }
            if (filter.getDate_() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("date_"), filter.getDate_()));
            }
            if (filter.getTime_() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("time_"), filter.getTime_()));
            }
            if (filter.getServices_id() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("services_id"), filter.getServices_id()));
            }
            if (filter.getUser_id() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("user_id"), filter.getUser_id()));
            }
            if (filter.getAmount() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("amount"), filter.getAmount()));

            }
            return predicate;
        };
    }
}
