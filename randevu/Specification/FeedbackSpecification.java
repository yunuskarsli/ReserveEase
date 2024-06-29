package learn.randevu.Specification;

import learn.randevu.entity.Feedback;
import learn.randevu.filter.FeedbackFilter;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

public class FeedbackSpecification {
    public static Specification<Feedback> filter(FeedbackFilter filter) {
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
            if (filter.getScor() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("scor"), filter.getScor()));
            }
            if (filter.getComment_() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("comment_"), filter.getComment_()));
            }
            if (filter.getPersonel_id() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("personel_id"), filter.getPersonel_id()));
            }
            if (filter.getUser_id() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("user_id"), filter.getUser_id()));
            }
            return predicate;
        };
    }
}
