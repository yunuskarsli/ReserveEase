package learn.randevu.services;

import learn.randevu.Specification.PersonelSpecification;
import learn.randevu.entity.Personel;
import learn.randevu.filter.PersonelFilter;
import learn.randevu.repository.PersonelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonelService {
    @Autowired
    private PersonelRepository personelRepository;

    public ResponseEntity<List<Personel>> getAll() {
        List<Personel> personels = personelRepository.findAll();
        return new ResponseEntity<>(personels, HttpStatus.OK);
    }

    public ResponseEntity<Personel> createPersonel(Personel personel) {
        Personel personel1 = personelRepository.save(personel);
        return new ResponseEntity<>(personel1, HttpStatus.CREATED);
    }

    public ResponseEntity<Personel> save(Personel personel) {
        Personel personel1 = personelRepository.save(personel);
        return new ResponseEntity<>(personel1, HttpStatus.CREATED);
    }

    public ResponseEntity<Personel> updatePersonel(Personel personel) {
        Personel personel1 = personelRepository.save(personel);
        if (personel1 != null) {
            return new ResponseEntity<>(personel1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public List<Personel> getPersonelFilter(PersonelFilter filter) {
        return personelRepository.findAll(PersonelSpecification.filter(filter));
    }
}
