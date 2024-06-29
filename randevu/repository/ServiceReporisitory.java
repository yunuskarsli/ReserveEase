package learn.randevu.repository;

import learn.randevu.entity.Services;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ServiceReporisitory extends JpaRepository<Services, Long> {
    List<Services> findAll(Specification<Services> spec);
}
