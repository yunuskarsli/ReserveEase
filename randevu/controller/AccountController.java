package learn.randevu.controller;

import learn.randevu.entity.Account;
import learn.randevu.repository.AccountRepository;
import learn.randevu.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountReporistory;

    @GetMapping("all")
    public ResponseEntity<List<Account>> getAll() {
        List<Account> account = accountReporistory.findAll();
        return new ResponseEntity<>(account, HttpStatus.OK);

    }@PostMapping("save")
    public ResponseEntity<Account> save(@RequestBody Account account){
        return accountService.updateAccount(account);
    }
    @PutMapping("update")
    public ResponseEntity<Account> update(@RequestBody Account account ){
        return accountService.updateAccount(account);
    }
    @DeleteMapping("delete")
    public ResponseEntity<Account> deleteAccount(@RequestBody Account account){
        accountReporistory.delete(account);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
