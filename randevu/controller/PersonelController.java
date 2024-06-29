package learn.randevu.controller;

import learn.randevu.entity.Personel;
import learn.randevu.entity.Services;
import learn.randevu.entity.User;
import learn.randevu.filter.PersonelFilter;
import learn.randevu.repository.PersonelRepository;
import learn.randevu.services.PersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("personel")
public class PersonelController {
    @Autowired
    private PersonelRepository personelRepository;
    @Autowired
    private PersonelService personelService;

    @GetMapping("all")
    public ResponseEntity<List<Personel>> all() {
        return personelService.getAll();
    }

    @GetMapping("page")
    public Page<Personel> getPersonel(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "5") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return personelRepository.findAll(pageRequest);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Personel> delete(@RequestBody Personel personel) {
        personelRepository.delete(personel);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("save")
    public ResponseEntity<Personel> save(@RequestBody Personel personel) {
        return personelService.save(personel);
    }

    @PutMapping("update")
    public ResponseEntity<Personel> update(@RequestBody Personel personel) {
        return personelService.updatePersonel(personel);
    }

    @GetMapping("/filter")
    public List<Personel> getPersonelFilter(@RequestParam(required = false) Integer id,
                                            @RequestParam(required = false) LocalDate start_date,
                                            @RequestParam(required = false) User user_id,
                                            @RequestParam(required = false) Services service_id,
                                            @RequestParam(required = false) Integer scor) {
        PersonelFilter filter = new PersonelFilter();
        filter.setId(id);
        filter.setStart_date(start_date);
        filter.setUser_id(user_id);
        filter.setServices_id(service_id);
        filter.setScor(scor);
        return personelService.getPersonelFilter(filter);
    }
}
