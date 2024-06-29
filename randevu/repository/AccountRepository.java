package learn.randevu.repository;

import learn.randevu.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    List<Account> findAll();

    Optional<Account> findAccountById(Integer id);

    Optional<Account> findAccountByBusiness_Id(Integer id);









}
