package learn.randevu.services;

import learn.randevu.entity.Communication;
import learn.randevu.repository.CommunicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunicationService {
    @Autowired
    private CommunicationRepository communicationRepository;


    public ResponseEntity<List<Communication>> getAll() {
        List<Communication> communications = communicationRepository.findAll();
        return new ResponseEntity<>(communications, HttpStatus.OK);
    }
}