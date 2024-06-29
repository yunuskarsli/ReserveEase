package learn.randevu.repository;

import learn.randevu.entity.Reserve;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReserveRepository  extends JpaRepository<Reserve,Long> {
    List<Reserve> findAll(Specification<Reserve> spec);


    List<Reserve> findByAppointmentDateTimeBefore(LocalDateTime now);

    List<Reserve> findByAppointmentDateTime(LocalDateTime dateTime);
}
