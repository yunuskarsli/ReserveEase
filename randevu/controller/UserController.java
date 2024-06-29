package learn.randevu.controller;

import learn.randevu.filter.UserFilter;
import learn.randevu.repository.UserRepository;
import learn.randevu.services.UserService;
import learn.randevu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("users")


public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("all")
    public ResponseEntity<List<User>> getAll() {
        return userService.getAll();
    }

    @GetMapping("page")
    public Page<User> getUser(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "5") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return userRepository.findAll(pageRequest);
    }

    @DeleteMapping("delete")
    public ResponseEntity<User> deleteUser(@RequestBody User user) {
        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("update")
    public ResponseEntity<User> update(@RequestBody User user) {
        return userService.updateUser(user);
    }


    @PostMapping("save")
    public ResponseEntity<User> save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/filter")
    public List<User> getUserByFilter(@RequestParam(required = false) Integer id,
                                      @RequestParam(required = false) String name,
                                      @RequestParam(required = false) String surname,
                                      @RequestParam(required = false) String email,
                                      @RequestParam(required = false) Integer password_,
                                      @RequestParam(required = false) BigInteger phone) {
        UserFilter filter = new UserFilter();
        filter.setId(id);
        filter.setName_(name);
        filter.setSurname(surname);
        filter.setEmail(email);
        filter.setPassword_(password_);
        filter.setPhone(phone);
        return userService.getUserFilter(filter);
    }

}
