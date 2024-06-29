package learn.randevu.Specification;

import jakarta.persistence.criteria.Predicate;
import learn.randevu.entity.User;
import learn.randevu.filter.UserFilter;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
    public static Specification<User> filter(UserFilter filter) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (filter.getId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), filter.getId()));
            }
            if (filter.getName_() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("name_"), filter.getName_()));
            }
            if (filter.getSurname() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("surname"), filter.getSurname()));
            }
            if (filter.getEmail() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("email"), filter.getEmail()));
            }
            if (filter.getPassword_() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("password_"), filter.getPassword_()));
            }
            if (filter.getPhone() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("phone"), filter.getPhone()));
            }
            return predicate;
        };
    }
}