package learn.randevu.repository;

import learn.randevu.entity.PersonAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonAppointmentRepository extends JpaRepository<PersonAppointment ,Long> {
}
