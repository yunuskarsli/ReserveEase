package learn.randevu.services;


import learn.randevu.Specification.UserSpecification;
import learn.randevu.entity.Communication;
import learn.randevu.filter.UserFilter;
import learn.randevu.repository.CommunicationRepository;
import learn.randevu.repository.UserRepository;
import learn.randevu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommunicationRepository communicationRepository;


    //    public List<User> delete(User user){
//        List<User> users =userRepository.delete(user);
//        return new ResponseEntity<>(users,HttpStatus.De);
//    }
    public User update(User user) {
        return userRepository.save(user);
    }

    public ResponseEntity<User> updateUser(User user) {
        User updatedUser1 = userRepository.save(user);

        if (updatedUser1 != null) {
            return new ResponseEntity<>(updatedUser1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<User>> getAll() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    public ResponseEntity<User> save(User user) {
        User users = userRepository.save(user);

        Communication communication=new Communication();
        communication.setEmail(user.getEmail());
        communication.setName(user.getUsername());
        communication.setSurname(user.getSurname());
        communication.setTelNumber(user.getPhone());
        communication.setType(user.getTitle());
        communicationRepository.save(communication);

        return new ResponseEntity<>(users, HttpStatus.CREATED);

    }


    public List<User> getUserFilter(UserFilter filter) {
        return userRepository.findAll(UserSpecification.filter(filter));
    }
}