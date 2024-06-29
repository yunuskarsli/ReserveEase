package learn.randevu.repository;

import learn.randevu.entity.Feedback;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback , Long> {
    List<Feedback> findAll(Specification<Feedback> spec);

}