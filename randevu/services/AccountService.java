package learn.randevu.services;

import learn.randevu.entity.Account;
import learn.randevu.entity.Reserve;
import learn.randevu.repository.AccountRepository;
import learn.randevu.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountReporistory;


    private Account account;

    private Reserve reserve;

    @Autowired
    private ReserveRepository reserveRepository;

    public List<Account> getAll(){
    return accountReporistory.findAll();
    }
    public ResponseEntity<Account> updateAccount(Account account){
        Account updateAccount =accountReporistory.save(account);
        if (updateAccount!=null){
            return new ResponseEntity<>(updateAccount, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Account> save(Account account){
        Account account1=accountReporistory.save(account);
        return new ResponseEntity<>(account1,HttpStatus.CREATED);
    }



    public Account save() {
        return accountReporistory.save(account);
    }


    public Account findByBusinessId(Integer id) {
        return accountReporistory.findAccountByBusiness_Id(id).get();
    }

}
