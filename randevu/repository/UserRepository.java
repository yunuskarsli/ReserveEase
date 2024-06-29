package learn.randevu.repository;

import learn.randevu.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll(Specification<User> spec);

    Optional<Object> findByUsername(String username);
}
