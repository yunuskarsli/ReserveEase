package learn.randevu.repository;

import learn.randevu.entity.PaymentHistory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory,Long> {
    List<PaymentHistory> findAll(Specification<PaymentHistory> spec);
}
