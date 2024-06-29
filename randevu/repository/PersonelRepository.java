package learn.randevu.repository;

import learn.randevu.entity.Personel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonelRepository extends JpaRepository<Personel,Long> {
    List<Personel> findAll(Specification<Personel> spec);
}
