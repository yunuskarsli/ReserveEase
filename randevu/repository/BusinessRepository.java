package learn.randevu.repository;

import learn.randevu.entity.Business;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    List<Business> findAll(Specification<Business> spec);
//    List<Business> findAll(B)
}
