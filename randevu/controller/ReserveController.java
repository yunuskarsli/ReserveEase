package learn.randevu.controller;

import learn.randevu.entity.Personel;
import learn.randevu.entity.Reserve;
import learn.randevu.entity.User;
import learn.randevu.filter.ReserveFilter;
import learn.randevu.repository.ReserveRepository;
import learn.randevu.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("reserve")
public class ReserveController {
    @Autowired
    private ReserveService reserveService;

    @Autowired
    private ReserveRepository reserveRepository;

    @GetMapping("all")
    public ResponseEntity<List<Reserve>> getAll() {
        List<Reserve> reserves = reserveRepository.findAll();
        return new ResponseEntity<>(reserves, HttpStatus.OK);
    }
    @GetMapping("page")
    public Page<Reserve> page(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "5") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return reserveRepository.findAll(pageRequest);
    }
    @DeleteMapping("delete")
    public ResponseEntity<Reserve> delete(@RequestBody Reserve reserve) {
        reserveRepository.delete(reserve);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("save")
    public ResponseEntity<Reserve> save(@RequestBody Reserve reserve) {
        return reserveService.save(reserve);
    }

    @PutMapping("update")
    public ResponseEntity<Reserve> updateReserve(@RequestBody Reserve reserve) {
        return reserveService.updateReserve(reserve);
    }

    @GetMapping("filter")
    public List<Reserve> getReserveFilter(@RequestParam(required = false) Integer id,
                                          @RequestParam(required = false) Book book_id,
                                          @RequestParam(required = false) Personel personel_id,
                                          @RequestParam(required = false) User user_id) {
        ReserveFilter filter = new ReserveFilter();
        filter.setId(id);
        filter.setBook_id(book_id);
        filter.setUser_id(user_id);
        filter.setPersonel_id(personel_id);
        return reserveService.getReserveFilter(filter);
    }

        @PostMapping("saves")
        public ResponseEntity<?> saveReservation(@RequestBody  Reserve reserve) {
        LocalDateTime appointmentDateTime = reserve.getAppointmentDateTime();
        return reserveService.saveReservation(appointmentDateTime,reserve);
    }
}
